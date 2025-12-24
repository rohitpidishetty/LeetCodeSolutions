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

  private int globalMax = 0;

  private int solve(TreeNode r) {
    if (r == null) return 0;
    int lc = solve(r.left), rc = solve(r.right);
    int right = 0, left = 0;
    if (r.right != null && r.val == r.right.val) right = rc + 1;
    if (r.left != null && r.val == r.left.val) left = lc + 1;
    globalMax = Math.max(globalMax, right + left);
    return Math.max(right, left);
  }

  public int longestUnivaluePath(TreeNode root) {
    solve(root);
    return this.globalMax;
  }
}

public class _687_Longest_Univalue_Path {

  public static void main(String[] args) {
    System.out.println(
      new Solution()
        .longestUnivaluePath(
          new TreeNode(
            1,
            new TreeNode(4, new TreeNode(4), new TreeNode(4)),
            new TreeNode(5, null, new TreeNode(5))
          )
        )
    );
  }
}
