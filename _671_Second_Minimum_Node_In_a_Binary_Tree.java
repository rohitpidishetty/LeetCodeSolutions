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

  private int solve(TreeNode r, int prevMin) {
    if (r == null) return -1;
    if (r.val > prevMin) return r.val;

    int left = solve(r.left, r.val);
    int right = solve(r.right, r.val);

    if (left == -1) return right;
    if (right == -1) return left;

    return Math.min(left, right);
  }

  public int findSecondMinimumValue(TreeNode root) {
    return solve(root, root.val);
  }
}

public class _671_Second_Minimum_Node_In_a_Binary_Tree {

  public static void main(String[] args) {
    System.out.println(
      new Solution()
        .findSecondMinimumValue(
          new TreeNode(
            2,
            new TreeNode(2),
            new TreeNode(5, new TreeNode(5), new TreeNode(7))
          )
        )
    );
  }
}
