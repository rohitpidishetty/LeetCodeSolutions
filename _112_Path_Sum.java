
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
  private boolean dfs(TreeNode root, int ts, int sum) {
    if (root == null)
      return false;
    sum += root.val;
    if (root.left == null && root.right == null)
      return sum == ts;
    return (dfs(root.left, ts, sum) || dfs(root.right, ts, sum));
  }

  public boolean hasPathSum(TreeNode root, int targetSum) {
    return dfs(root, targetSum, 0);
  }
}

public class _112_Path_Sum {
  public static void main(String[] args) {

    TreeNode root = new TreeNode(5,
        new TreeNode(4,
            new TreeNode(11,
                new TreeNode(7),
                new TreeNode(2)),
            null),
        new TreeNode(8,
            new TreeNode(13),
            new TreeNode(4,
                null,
                new TreeNode(1))));

    System.out.println(new Solution().hasPathSum(root, 22));
  }
}
