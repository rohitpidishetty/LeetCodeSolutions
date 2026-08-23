import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {

  public int orderOfLargestPlusSign(int n, int[][] mines) {
    int[][] dp = new int[n][n];

    for (int i = 0; i < n; i++) Arrays.fill(dp[i], n);

    for (int[] mine : mines) dp[mine[0]][mine[1]] = 0;

    for (int i = 0; i < n; i++) {
      int count = 0;
      for (int j = 0; j < n; j++) {
        count = (dp[i][j] == 0) ? 0 : count + 1;
        dp[i][j] = Math.min(dp[i][j], count);
      }
    }

    for (int i = 0; i < n; i++) {
      int count = 0;
      for (int j = n - 1; j >= 0; j--) {
        count = (dp[i][j] == 0) ? 0 : count + 1;
        dp[i][j] = Math.min(dp[i][j], count);
      }
    }

    for (int j = 0; j < n; j++) {
      int count = 0;
      for (int i = 0; i < n; i++) {
        count = (dp[i][j] == 0) ? 0 : count + 1;
        dp[i][j] = Math.min(dp[i][j], count);
      }
    }

    int max = 0;
    for (int j = 0; j < n; j++) {
      int count = 0;
      for (int i = n - 1; i >= 0; i--) {
        count = (dp[i][j] == 0) ? 0 : count + 1;
        dp[i][j] = Math.min(dp[i][j], count);
        max = Math.max(max, dp[i][j]);
      }
    }

    return max;
  }
}

public class _764_Largest_Plus_Sign {

  public static void main(String[] args) {
    System.out.println(
      new Solution().orderOfLargestPlusSign(5, new int[][] { { 4, 2 } })
    );
  }
}
