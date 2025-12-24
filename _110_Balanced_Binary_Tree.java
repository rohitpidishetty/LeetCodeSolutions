
class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

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

  private int checkHeight(TreeNode root) {
    if (root == null)
      return 0;
    return Math.max(checkHeight(root.left), checkHeight(root.right)) + 1;
  }

  private boolean checkIfBalanced(TreeNode root) {

    if (root == null)
      return true;
    if (Math.abs(checkHeight(root.left) - checkHeight(root.right)) > 1)
      return false;
    return checkIfBalanced(root.left) && checkIfBalanced(root.right);
  }

  public boolean isBalanced(TreeNode root) {
    return checkIfBalanced(root);
  }
}

public class _110_Balanced_Binary_Tree {
  public static void main(String[] args) {
    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(9);
    root.right = new TreeNode(20);
    root.right.left = new TreeNode(15);
    root.right.right = new TreeNode(7);
    System.out.println(new Solution().isBalanced(root));
  }
}