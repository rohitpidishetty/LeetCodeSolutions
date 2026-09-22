import java.util.Arrays;

class Solution {

  private int solve(int idx, int[] cost, int[] memo) {
    if (idx > cost.length) return Integer.MAX_VALUE;
    if (idx == cost.length) return 0;
    if (memo[idx] != -1) return memo[idx];
    return memo[idx] = (cost[idx] +
      Math.min(solve(idx + 1, cost, memo), solve(idx + 2, cost, memo)));
  }

  public int minCostClimbingStairs(int[] cost) {
    int n = cost.length;
    int[] memo = new int[n];
    Arrays.fill(memo, -1);
    int a = solve(0, cost, memo);
    int b = solve(1, cost, memo);
    return Math.min(a, b);
  }
}

public class _746_Min_Cost_Climbing_Stairs {

  public static void main(String[] args) {
    System.out.println(
      new Solution().minCostClimbingStairs(
        new int[] { 1, 100, 1, 1, 1, 100, 1, 1, 100, 1 }
      )
    );
  }
}
