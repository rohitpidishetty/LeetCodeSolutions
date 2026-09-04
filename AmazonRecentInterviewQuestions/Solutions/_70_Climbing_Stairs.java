import java.util.Arrays;

class Solution {

  private int solve(int total, int curr, int[] memo) {
    if (curr > total) return 0;
    if (curr == total) return 1;
    if (memo[curr] != -1) return memo[curr];
    return memo[curr] =
      solve(total, curr + 1, memo) + solve(total, curr + 2, memo);
  }

  public int climbStairs(int n) {
    int[] memo = new int[n];
    Arrays.fill(memo, -1);
    return solve(n, 0, memo);
  }
}

public class _70_Climbing_Stairs {

  public static void main(String[] args) {
    System.out.println(new Solution().climbStairs(7));
  }
}
