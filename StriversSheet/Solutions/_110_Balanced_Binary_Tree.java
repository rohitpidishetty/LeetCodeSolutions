class Solution {

  private int height(TreeNode r) {
    if (r == null) return 0;
    int lth = height(r.left);
    int rth = height(r.right);
    return 1 + Math.max(lth, rth);
  }

  private boolean solve(TreeNode r) {
    if (r == null) return true;
    int lh = height(r.left);
    int rh = height(r.right);
    if (Math.abs(lh - rh) > 1) return false;
    boolean ltb = solve(r.left);
    boolean rtb = solve(r.right);
    return ltb && rtb;
  }

  public boolean isBalanced(TreeNode root) {
    return solve(root);
  }
}

public class _110_Balanced_Binary_Tree {

  public static void main(String[] args) {
    TreeNode root = new TreeNode(
      1,
      new TreeNode(2, new TreeNode(4), new TreeNode(5)),
      new TreeNode(3)
    );
    System.out.println(new Solution().isBalanced(root));
  }
}
