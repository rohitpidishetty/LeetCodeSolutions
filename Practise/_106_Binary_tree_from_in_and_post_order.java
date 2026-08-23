import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class TreeNode {
  int val;
  TreeNode right;
  TreeNode left;

  TreeNode() {
  }

  TreeNode(int val) {
    this.val = val;
  }

  TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }
}

interface treeBuilder {
  public TreeNode binaryTree(int[] inorder, int start, int limit);
}

class Solution {

  private int[] postOrdArr;
  private int postOrdArrIdx;
  private Map<Integer, Integer> inOrd;

  public TreeNode binaryTree(int[] inorder, int start, int limit) {
    if (limit < start)
      return null;
    TreeNode root = new TreeNode(postOrdArr[postOrdArrIdx--]);
    int i = inOrd.get(root.val);
    root.right = binaryTree(inorder, i + 1, limit);
    root.left = binaryTree(inorder, start, i - 1);
    return root;
  }

  public TreeNode buildTree(int[] postorder, int[] inorder) {
    this.postOrdArrIdx = postorder.length - 1;
    this.postOrdArr = postorder;
    inOrd = new HashMap<>();
    for (int i = 0; i < inorder.length; i++)
      inOrd.put(inorder[i], i);
    return binaryTree(inorder, 0, inorder.length - 1);
  }
}

public class _106_Binary_tree_from_in_and_post_order {
  public static void main(String[] args) {
    System.out.println(new Solution().buildTree(new int[] { 9, 3, 15, 20, 7 }, new int[] { 9, 15, 7, 20, 3 }));
  }
}
