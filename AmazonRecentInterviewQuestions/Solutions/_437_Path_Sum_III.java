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

  private int solve(TreeNode r, int T, Map<Long, Integer> map, long sum) {
    if (r == null) return 0;
    sum += r.val;
    // sum - T = removable
    int present = map.getOrDefault(sum - T, 0);
    map.put(sum, map.getOrDefault(sum, 0) + 1);
    int left = solve(r.left, T, map, sum);
    int right = solve(r.right, T, map, sum);
    map.put(sum, map.get(sum) - 1);
    return left + right + present;
  }

  public int pathSum(TreeNode root, int targetSum) {
    Map<Long, Integer> map = new HashMap<>();
    map.put(0L, 1);
    return solve(root, targetSum, map, 0L);
  }
}

public class _437_Path_Sum_III {

  public static void main(String[] args) {
    System.out.println(
      new Solution().pathSum(
        new TreeNode(
          10,
          new TreeNode(
            5,
            new TreeNode(3, new TreeNode(3), new TreeNode(-2)),
            new TreeNode(2, null, new TreeNode(1))
          ),
          new TreeNode(-3, null, new TreeNode(11))
        ),
        8
      )
    );
  }
}
