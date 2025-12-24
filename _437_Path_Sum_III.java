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

  // protected int dfs(TreeNode root, int targetSum) {
  //   if (root == null) return 0;
  //   if (root.val == targetSum) return 1;
  //   return (
  //     dfs(root.left, targetSum - root.val) +
  //     dfs(root.right, targetSum - root.val)
  //   );
  // }

  // protected int node(TreeNode root, int targetSum) {
  //   if (root == null) return 0;
  //   return (
  //     dfs(root, targetSum) +
  //     node(root.left, targetSum) +
  //     node(root.right, targetSum)
  //   );
  // }

  private int optimized_dfs(
    TreeNode root,
    int targetSum,
    Map<Long, Integer> freq,
    long curr_val
  ) {
    if (root == null) return 0;
    curr_val += root.val;
    // System.out.println(
    //   curr_val + " - " + (curr_val - targetSum) + " = " + targetSum
    // );
    // (current_sum:A)+ B = targetSum, then B == A - targetSum.
    // Check if curr_val - targetSum is present in the freq.
    int present = freq.getOrDefault(curr_val - targetSum, 0);
    freq.put(curr_val, freq.getOrDefault(curr_val, 0) + 1);
    int l = optimized_dfs(root.left, targetSum, freq, curr_val);
    int r = optimized_dfs(root.right, targetSum, freq, curr_val);
    freq.put(curr_val, freq.get(curr_val) - 1);
    return l + r + present;
  }

  public int pathSum(TreeNode root, int targetSum) {
    // return node(root, targetSum); // O(n^2) complexity
    Map<Long, Integer> freq = new HashMap<>() {
      {
        put(0L, 1);
      }
    };
    long curr_val = 0;
    return optimized_dfs(root, targetSum, freq, curr_val);
  }
}

public class _437_Path_Sum_III {

  public static void main(String[] args) {
    System.out.println(
      new Solution()
        .pathSum(
          new TreeNode(
            10,
            new TreeNode(
              5,
              new TreeNode(
                3,
                new TreeNode(3, null, null),
                new TreeNode(-2, null, null)
              ),
              new TreeNode(2, null, new TreeNode(1, null, null))
            ),
            new TreeNode(-3, null, new TreeNode(11, null, null))
          ),
          8
        )
    );
  }
}
