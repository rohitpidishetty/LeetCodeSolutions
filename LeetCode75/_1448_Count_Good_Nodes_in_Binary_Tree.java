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

  private int count = 0;

  private void solve(TreeNode tn, int max) {
    if (tn == null) return;
    if (tn.val >= max) count++;
    int newMax = Math.max(max, tn.val);
    solve(tn.left, newMax);
    solve(tn.right, newMax);
  }

  public int goodNodes(TreeNode root) {
    solve(root, Integer.MIN_VALUE);
    return count;
  }
}

public class _1448_Count_Good_Nodes_in_Binary_Tree {

  public static void main(String[] args) {
    System.out.println(
      new Solution().goodNodes(
        new TreeNode(
          3,
          new TreeNode(1, new TreeNode(3), null),
          new TreeNode(4, new TreeNode(1), new TreeNode(5))
        )
      )
    );
  }
}
