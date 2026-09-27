class Solution {

  private int max = Integer.MIN_VALUE;

  private int solve(TreeNode r) {
    if (r == null) return 0;
    int left = solve(r.left);
    int right = solve(r.right);
    max = Math.max(max, r.val + Math.max(0, left) + Math.max(0, right));
    return r.val + Math.max(0, Math.max(left, right));
  }

  public int maxPathSum(TreeNode root) {
    solve(root);
    return max;
  }
}

public class _124_Binary_Tree_Maximum_Path_Sum {

  public static void main(String[] args) {
    System.out.println(
      new Solution().maxPathSum(
        new TreeNode(
          -10,
          new TreeNode(9),
          new TreeNode(20, new TreeNode(15), new TreeNode(7))
        )
      )
    );
  }
}
