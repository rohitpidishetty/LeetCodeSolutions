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

  private int max = 1000000;
  private int min = Integer.MAX_VALUE;

  private void solve(TreeNode r) {
    if (r == null) return;
    solve(r.right);
    this.min = Math.min(min, max - r.val);
    this.max = r.val;
    solve(r.left);
  }

  public int minDiffInBST(TreeNode root) {
    solve(root);
    return this.min;
  }
}

public class _783_Minimum_Distance_Between_BST_Nodes {

  public static void main(String[] args) {
    System.out.println(
      new Solution()
        .minDiffInBST(
          new TreeNode(
            4,
            new TreeNode(2, new TreeNode(1), new TreeNode(3)),
            new TreeNode(6)
          )
        )
    );
  }
}
