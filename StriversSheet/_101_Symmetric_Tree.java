class Solution {

  private boolean solve(TreeNode lt, TreeNode rt) {
    if (lt == null && rt == null) return true;
    if (
      (lt == null && rt != null) ||
      (lt != null && rt == null) ||
      (lt.val != rt.val)
    ) return false;
    return solve(lt.left, rt.right) && solve(lt.right, rt.left);
  }

  public boolean isSymmetric(TreeNode root) {
    if (root == null || (root.left == null && root.right == null)) return true;
    return solve(root.left, root.right);
  }
}

public class _101_Symmetric_Tree {

  public static void main(String[] args) {
    System.out.println(
      new Solution().isSymmetric(
        new TreeNode(
          1,
          new TreeNode(2, new TreeNode(3), new TreeNode(4)),
          new TreeNode(2, new TreeNode(3), new TreeNode(4))
        )
      )
    );
  }
}
