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
  private int min = Integer.MAX_VALUE;

  private void fn(TreeNode r, int p) {
    if (r == null)
      return;
    fn(r.left, p);
    this.min = Math.min(this.min, Math.abs(r.val - p));
    fn(r.right, p);
  }

  private void solve(TreeNode r, int prev) {
    if (r == null)
      return;

    solve(r.left, r.val);
    if (prev != -1)
      fn(r, prev);
    solve(r.right, r.val);
  }

  public int getMinimumDifference(TreeNode root) {
    solve(root, -1);
    return this.min;
  }
}

public class _530_Minimum_Absolute_Difference_in_BST {
  public static void main(String[] args) {
    System.out.println(new Solution()
        .getMinimumDifference(
            new TreeNode(4,
                new TreeNode(2,
                    new TreeNode(1),
                    new TreeNode(3)),
                new TreeNode(6))));
  }
}
