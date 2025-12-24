import java.util.ArrayList;
import java.util.List;

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
  private static int ret_val;

  private void solve(TreeNode root, int numberBuilder) {
    if (root == null)
      return;
    numberBuilder = numberBuilder * 10 + root.val;
    if (root.left == null && root.right == null)
      Solution.ret_val += numberBuilder;
    solve(root.left, numberBuilder);
    if (root.right != null)
      solve(root.right, numberBuilder);
  }

  public int sumNumbers(TreeNode root) {
    Solution.ret_val = 0;
    solve(root, 0);
    return Solution.ret_val;
  }
}

public class _129_Sum_Root_to_Leaf_Numbers {
  public static void main(String[] args) {
    System.out.println(new Solution()
        .sumNumbers(new TreeNode(1,
            new TreeNode(2, null, null),
            new TreeNode(3, null, null))));
  }
}
