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

  private int count = 0;

  private void solve(TreeNode r, int target, long sum, Map<Long, Integer> map) {
    if (r == null) return;
    sum += r.val;
    count += map.getOrDefault(sum - target, 0);
    map.put(sum, map.getOrDefault(sum, 0) + 1);

    solve(r.left, target, sum, map);
    solve(r.right, target, sum, map);
    map.put(sum, map.get(sum) - 1);
  }

  public int pathSum(TreeNode root, int targetSum) {
    Map<Long, Integer> map = new HashMap<>();
    map.put(0L, 1);
    solve(root, targetSum, 0L, map);
    return count;
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
