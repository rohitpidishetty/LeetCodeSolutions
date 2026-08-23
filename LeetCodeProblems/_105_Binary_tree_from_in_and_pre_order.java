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

class Solution {
  private int idx;
  private int[] preorder;
  private Map<Integer, Integer> ordMap;

  private TreeNode binaryTree(int[] inorder, int start, int limit) {
    if (limit < start)
      return null;
    TreeNode root = new TreeNode(preorder[idx++]);
    int i = ordMap.get(root.val);
    root.left = binaryTree(inorder, start, i - 1);
    root.right = binaryTree(inorder, i + 1, limit);
    return root;
  }

  public TreeNode buildTree(int[] preorder, int[] inorder) {
    idx = 0;
    this.preorder = preorder;
    ordMap = new HashMap<>();
    for (int i = 0; i < preorder.length; i++)
      ordMap.put(inorder[i], i);
    return binaryTree(inorder, 0, preorder.length - 1);
  }
}

public class _105_Binary_tree_from_in_and_pre_order {
  public static void main(String[] args) {
    System.out.println(new Solution().buildTree(new int[] { 3, 9, 20, 15, 7 }, new int[] { 9, 3, 15, 20, 7 }));
  }
}
