import java.util.HashMap;
import java.util.Map;

class Solution {

  private int rootPosition;
  private int[] roots;

  private TreeNode build(int[] arr, int l, int h, Map<Integer, Integer> map) {
    if (l > h || rootPosition >= arr.length) return null;
    int currRoot = roots[rootPosition++];

    TreeNode root = new TreeNode(currRoot);
    root.left = build(arr, l, map.get(currRoot) - 1, map);
    root.right = build(arr, map.get(currRoot) + 1, h, map);
    return root;
  }

  public TreeNode buildTree(int[] preorder, int[] inorder) {
    Map<Integer, Integer> map = new HashMap<>();
    roots = preorder;
    for (int i = 0; i < inorder.length; i++) map.put(inorder[i], i);
    rootPosition = 0;
    return build(inorder, 0, inorder.length - 1, map);
  }
}

public class _105_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal {

  public static void main(String[] args) {
    TreeNode tn = new Solution().buildTree(
      new int[] { 3, 9, 20, 15, 7 },
      new int[] { 9, 3, 15, 20, 7 }
    );
  }
}
