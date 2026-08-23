import java.util.Arrays;

class Solution {

  private int[] memo;

  private int solve(int idx, int[] cost) {
    if (idx >= cost.length) return 0;
    if (this.memo[idx] != -1) return this.memo[idx];
    return (
      this.memo[idx] = Math.min(
        cost[idx] + solve(idx + 1, cost),
        cost[idx] + solve(idx + 2, cost)
      )
    );
  }

  public int minCostClimbingStairs(int[] cost) {
    this.memo = new int[cost.length + 1];
    Arrays.fill(this.memo, -1);
    return Math.min(solve(0, cost), solve(1, cost));
  }
}

public class __746_Min_Cost_Climbing_Stairs {

  public static void main(String[] args) {
    System.out.println(
      new Solution()
        .minCostClimbingStairs(new int[] { 1, 100, 1, 1, 1, 100, 1, 1, 100, 1 })
    );
  }
}
