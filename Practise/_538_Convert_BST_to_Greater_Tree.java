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
  private int currVal = 0;

  private TreeNode solve(TreeNode r) {
    if (r == null)
      return null;

    TreeNode right = solve(r.right);
    this.currVal += r.val;
    TreeNode newNode = new TreeNode(this.currVal);
    newNode.right = right;
    newNode.left = solve(r.left);

    return newNode;
  }

  public TreeNode convertBST(TreeNode root) {

    return solve(root);
  }
}

public class _538_Convert_BST_to_Greater_Tree {
  public static void main(String[] args) {

    TreeNode root = new TreeNode(4);
    root.left = new TreeNode(1);
    root.right = new TreeNode(6);
    root.left.left = new TreeNode(0);
    root.left.right = new TreeNode(2);
    root.right.left = new TreeNode(5);
    root.right.right = new TreeNode(7);
    root.left.right.right = new TreeNode(3);
    root.right.right.right = new TreeNode(8);
    TreeNode greaterTree = new Solution().convertBST(root);
    System.out.println(greaterTree.val);
  }
}
