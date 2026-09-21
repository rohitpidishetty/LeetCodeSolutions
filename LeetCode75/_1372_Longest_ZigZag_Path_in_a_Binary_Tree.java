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

  private int max = 0;

  private void solve(TreeNode t, boolean isRight, int soFarLength) {
    if (t == null) return;

    max = Math.max(max, soFarLength);
    if (isRight) {
      solve(t.left, false, soFarLength + 1);
      solve(t.right, true, 1);
    } else {
      solve(t.right, true, soFarLength + 1);
      solve(t.left, false, 1);
    }
  }

  public int longestZigZag(TreeNode root) {
    solve(root, true, 0);
    return max;
  }
}

public class _1372_Longest_ZigZag_Path_in_a_Binary_Tree {

  public static void main(String[] args) {
    System.out.println(
      new Solution().longestZigZag(
        new TreeNode(
          1,
          null,
          new TreeNode(
            1,
            new TreeNode(1),
            new TreeNode(
              1,
              new TreeNode(1, null, new TreeNode(1, null, new TreeNode(1))),
              new TreeNode(1)
            )
          )
        )
      )
    );
  }
}
