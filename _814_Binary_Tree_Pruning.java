class TreeNode {

  int val;
  TreeNode left;
  TreeNode right;

  TreeNode() {}

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

  private TreeNode solve(TreeNode r) {
    if (r == null) return null;
    r.right = solve(r.right);
    r.left = solve(r.left);
    if (r.val == 0 && r.left == null && r.right == null) return null;

    return r;
  }

  public TreeNode pruneTree(TreeNode root) {
    return solve(root);
  }
}

public class _814_Binary_Tree_Pruning {

  public static void main(String[] args) {
    new Solution().pruneTree(
      new TreeNode(
        1,
        new TreeNode(
          1,
          new TreeNode(1, new TreeNode(0), null),
          new TreeNode(1)
        ),
        new TreeNode(0, new TreeNode(0), new TreeNode(1))
      )
    );
  }
}
