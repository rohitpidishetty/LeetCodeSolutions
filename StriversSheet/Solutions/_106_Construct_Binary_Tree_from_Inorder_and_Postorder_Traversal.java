import java.util.HashMap;
import java.util.Map;

class Solution {

  private int rootPosition;
  private int[] roots;

  private TreeNode build(int[] arr, int l, int h, Map<Integer, Integer> map) {
    if (l > h || rootPosition < 0) return null;
    int currRoot = roots[rootPosition--];

    TreeNode root = new TreeNode(currRoot);
    root.right = build(arr, map.get(currRoot) + 1, h, map);
    root.left = build(arr, l, map.get(currRoot) - 1, map);
    return root;
  }

  public TreeNode buildTree(int[] inorder, int[] postorder) {
    Map<Integer, Integer> map = new HashMap<>();
    roots = postorder;
    for (int i = 0; i < inorder.length; i++) map.put(inorder[i], i);
    rootPosition = inorder.length - 1;
    return build(inorder, 0, inorder.length - 1, map);
  }
}

public class _106_Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal {

  public static void main(String[] args) {
    TreeNode tn = new Solution().buildTree(
      new int[] { 9, 3, 15, 20, 7 },
      new int[] { 9, 15, 7, 20, 3 }
    );
  }
}
