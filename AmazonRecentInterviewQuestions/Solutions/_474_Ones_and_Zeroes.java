import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

  private int solve(int idx, String[] strs, int m, int n, int[][][] memo) {
    if (idx == strs.length) return 0;
    if (memo[m][n][idx] != -1) return memo[m][n][idx];

    // skip
    int skip = solve(idx + 1, strs, m, n, memo);

    // take
    int ones = 0;
    int zeros = 0;
    int s = strs[idx].length();
    for (int i = 0; i < s; i++) if (strs[idx].charAt(i) == '0') zeros++;
    ones = s - zeros;
    int take = Integer.MIN_VALUE;
    if (m - zeros > -1 && n - ones > -1) {
      take = 1 + solve(idx + 1, strs, m - zeros, n - ones, memo);
    }
    return memo[m][n][idx] = Math.max(skip, take);
  }

  public int findMaxForm(String[] strs, int m, int n) {
    // generate sub-sets
    int[][][] memo = new int[m + 1][n + 1][strs.length];
    for (int[][] mem : memo) for (int cache[] : mem) Arrays.fill(cache, -1);
    return solve(0, strs, m, n, memo);
  }
}

public class _474_Ones_and_Zeroes {

  public static void main(String[] args) {
    System.out.println(
      new Solution().findMaxForm(
        new String[] { "10", "0001", "111001", "1", "0" },
        5,
        3
      )
    );
  }
}
