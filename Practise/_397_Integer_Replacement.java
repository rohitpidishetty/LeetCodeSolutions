class Solution {

  private Integer[] memo;

  private int solve(int n) {
    if (memo[n] != null) return memo[n];
    if (n == 1) return 0;
    memo[n] =
      ((n & 1) != 1 ? solve(n / 2) : Math.min(solve(n - 1), solve(n + 1))) + 1;
    return memo[n];
  }

  public int integerReplacement(int n) {
    // memo = new Integer[n + 2];
    // return solve(n);

    // int[] dp = new int[n + 2];
    // dp[0] = 0;
    // for (int i = 2; i <= n; i++) {
    //   if ((i & 1) != 1) dp[i] = dp[i / 2] + 1;
    //   else dp[i] =
    //     Math.min(dp[i - 1], dp[i + 1] == 0 ? Integer.MAX_VALUE : dp[i + 1]) + 1;
    // }
    // return dp[n];

    long num = n;
    int steps = 0;

    while (num != 1) {
      if ((num & 1) == 0) num >>= 1;
      else {
        // xxxxx0x (-1)
        // xxxxx1x (+1)
        if (num == 3 || (num & 2) == 0) num--; // better to subtract
        else num++; // better to add
      }
      steps++;
    }

    return steps;
  }
}

public class _397_Integer_Replacement {

  public static void main(String[] args) {
    System.out.println(new Solution().integerReplacement(100000000));
  }
}
