class Solution {

  private int max = Integer.MIN_VALUE;

  private int solve(TreeNode r) {
    if (r == null) return 0;
    int lh = solve(r.left);

    int rh = solve(r.right);

    max = Math.max(max, lh + rh + 1);
    return 1 + Math.max(lh, rh);
  }

  public int diameterOfBinaryTree(TreeNode root) {
    return solve(root);
  }
}

public class _543_Diameter_of_Binary_Tree {

  public static void main(String[] args) {
    TreeNode root = new TreeNode(
      1,
      new TreeNode(2, new TreeNode(4), new TreeNode(5)),
      new TreeNode(3)
    );
    System.out.println(new Solution().diameterOfBinaryTree(root));
  }
}
