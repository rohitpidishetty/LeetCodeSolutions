import java.util.HashMap;
import java.util.Map;

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

  private int solve(TreeNode r, Map<TreeNode, Integer> memo) {
    if (r == null) return 0;
    if (memo.containsKey(r)) return memo.get(r);
    // skip

    int skip = solve(r.left, memo) + solve(r.right, memo);

    // take

    int take =
      r.val +
      (r.left != null
        ? solve(r.left.left, memo) + solve(r.left.right, memo)
        : 0) +
      (r.right != null
        ? solve(r.right.left, memo) + solve(r.right.right, memo)
        : 0);
    int max = Math.max(skip, take);
    memo.put(r, max);
    return max;
  }

  public int rob(TreeNode root) {
    Map<TreeNode, Integer> memo = new HashMap<>();
    return solve(root, memo);
  }
}

public class _337_House_Robber_III {

  public static void main(String[] args) {
    int ans = new Solution().rob(
      new TreeNode(
        3,
        new TreeNode(2, null, new TreeNode(3)),
        new TreeNode(3, null, new TreeNode(1))
      )
    );
    System.out.println(ans);
  }
}
