class Solution {

  private boolean solve(TreeNode r, long min, long max) {
    if (r == null) return true;
    if (!(r.val > min && r.val < max)) return false;
    return solve(r.left, min, r.val) && solve(r.right, r.val, max);
  }

  public boolean isValidBST(TreeNode root) {
    return solve(root, Long.MIN_VALUE, Long.MAX_VALUE);
  }
}

public class _98_Validate_Binary_Search_Tree {

  public static void main(String[] args) {
    System.out.println(
      new Solution().isValidBST(
        new TreeNode(
          5,
          new TreeNode(1),
          new TreeNode(4, new TreeNode(3), new TreeNode(6))
        )
      )
    );
  }
}
