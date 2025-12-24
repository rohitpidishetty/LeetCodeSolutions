// import java.util.*;

// class Solution {

//   // 80/81 (TLE)
//   private Integer[][] memo;
//   private int MOD = 1_000_000_007;

//   // private int solve(int n, int k) {
//   //   if (n == 0) return 0;
//   //   if (k == 0) return 1;
//   //   if (this.memo[n][k] != null) return this.memo[n][k] % this.MOD;
//   //   int res = 0;
//   //   for (int i = 0; i <= Math.min(n - 1, k); i++) res =
//   //     (res % this.MOD) + (solve(n - 1, k - i) % this.MOD);
//   //   return this.memo[n][k] = res % this.MOD;
//   // }

//   // public int kInversePairs(int n, int k) {
//   //   this.memo = new Integer[n + 1][k + 1];
//   //   return solve(n, k);
//   // }

//   public int kInversePairs(int n, int k) {
//     int[][] memo = new int[n + 1][k + 1];

//     for (int i = 0; i <= n; i++) memo[i][0] = 1;
//     for (int i = 1; i <= n; i++) {
//       for (int j = 1; j <= k; j++) {
//         for (int inversion = 0; inversion <= Math.min(i - 1, j); inversion++) {
//           memo[i][j] =
//             ((memo[i][j] % MOD) + (memo[i - 1][j - inversion] % MOD)) % MOD;
//         }
//       }
//     }
//     return memo[n][k];
//   }
// }

// public class _629_K_Inverse_Pairs_Array {

//   public static void main(String[] args) {
//     System.out.println(new Solution().kInversePairs(3, 1));
//   }
// }

import java.util.*;

class Solution {

  private final int MOD = 1_000_000_007;

  public int kInversePairs(int n, int k) {
    int[][] dp = new int[n + 1][k + 1];
    dp[0][0] = 1;

    for (int i = 1; i <= n; i++) {
      dp[i][0] = 1;
      for (int j = 1; j <= k; j++) {
        long val = dp[i][j - 1] + dp[i - 1][j];
        if (j >= i) val -= dp[i - 1][j - i];
        dp[i][j] = (int) (((val % MOD) + MOD) % MOD);
      }
    }

    return dp[n][k];
  }
}

public class _629_K_Inverse_Pairs_Array {

  public static void main(String[] args) {
    System.out.println(new Solution().kInversePairs(3, 1));
  }
}
