import java.util.HashMap;
import java.util.Map;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

  private Map<TreeNode, Integer> memo;

  public int rob(TreeNode root) {
    memo = new HashMap<>();
    return solve(root);
  }

  private int solve(TreeNode root) {
    if (root == null) return 0;
    if (memo.containsKey(root)) return memo.get(root);
    int skip = solve(root.left) + solve(root.right);
    int take = root.val;
    take +=
      ((root.left != null)
          ? solve(root.left.left) + solve(root.left.right)
          : 0) +
      ((root.right != null)
          ? solve(root.right.left) + solve(root.right.right)
          : 0);
    int ret = Math.max(take, skip);
    memo.put(root, ret);
    return ret;
  }
}
