// import java.util.HashMap;
// import java.util.HashSet;
// import java.util.Map;

// class Solution {

//   private int MOD = (int) Math.pow(10, 9) + 7;
//   private Long[][] memo;

//   private long solve(String s, int i, int j) {
//     if (i > j) return 0;
//     if (this.memo[i][j] != null) return this.memo[i][j];
//     if (i == j) return this.memo[i][j] = 1l;
//     else if (s.charAt(i) == s.charAt(j)) return (
//       memo[i][j] = (1 + solve(s, i + 1, j) + solve(s, i, j - 1)) % this.MOD
//     );
//     else {
//       return (
//         memo[i][j] =
//           (((solve(s, i + 1, j) + solve(s, i, j - 1) - solve(s, i + 1, j - 1)) %
//               this.MOD) +
//             this.MOD) %
//           this.MOD
//       );
//     }
//   }

//   public long countPalindromicSubsequences(String s) {
//     int n = s.length();
//     this.memo = new Long[1000][1000];
//     return solve(s, 0, n - 1);
//   }
// }

class Solution {

  private static final int MOD = 1_000_000_007;
  private Long[][] memo;

  private long solve(String s, int i, int j) {
    if (i > j) return 0;
    if (i == j) return 1;
    if (memo[i][j] != null) return memo[i][j];

    long res;
    if (s.charAt(i) == s.charAt(j)) {
      int low = i + 1, high = j - 1;

      while (low <= high && s.charAt(low) != s.charAt(i)) low++;
      while (low <= high && s.charAt(high) != s.charAt(i)) high--;

      if (low > high) {
        res = 2 * solve(s, i + 1, j - 1) + 2;
      } else if (low == high) {
        res = 2 * solve(s, i + 1, j - 1) + 1;
      } else {
        res = 2 * solve(s, i + 1, j - 1) - solve(s, low + 1, high - 1);
      }
    } else {
      res = solve(s, i + 1, j) + solve(s, i, j - 1) - solve(s, i + 1, j - 1);
    }

    res = ((res % MOD) + MOD) % MOD;
    return memo[i][j] = res;
  }

  public int countPalindromicSubsequences(String s) {
    int n = s.length();
    memo = new Long[n][n];
    return (int) solve(s, 0, n - 1);
  }
}

public class _730_Count_Different_Palindromic_Subsequences {

  public static void main(String[] args) {
    System.out.println(
      new Solution().countPalindromicSubsequences(new String("abccbc"))
    );
  }
}
