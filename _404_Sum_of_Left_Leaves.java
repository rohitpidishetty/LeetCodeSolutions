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

  private int solve(TreeNode r, boolean isLeft) {
    if (r == null) return 0;
    if (r.left == null && r.right == null && isLeft) return r.val;
    return solve(r.left, true) + solve(r.right, false);
  }

  public int sumOfLeftLeaves(TreeNode root) {
    if (root.left == null && root.right == null) return 0;
    return solve(root, false);
  }
}

public class _404_Sum_of_Left_Leaves {

  public static void main(String[] args) {
    System.out.println(
      new Solution()
        .sumOfLeftLeaves(
          new TreeNode(
            3,
            new TreeNode(9, null, null),
            new TreeNode(
              20,
              new TreeNode(15, null, null),
              new TreeNode(7, null, null)
            )
          )
        )
    );
  }
}
