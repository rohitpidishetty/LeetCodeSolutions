import java.util.Arrays;

class Solution {

  private int solve(
    String a,
    String b,
    int i,
    int j,
    int n,
    int m,
    int memo[][]
  ) {
    if (i >= n || j >= m) return 0;
    if (memo[i][j] != -1) return memo[i][j];
    if (a.charAt(i) == b.charAt(j)) return memo[i][j] = (1 +
      solve(a, b, i + 1, j + 1, n, m, memo));
    return memo[i][j] = Math.max(
      solve(a, b, i + 1, j, n, m, memo),
      solve(a, b, i, j + 1, n, m, memo)
    );
  }

  public int lcs(String str1, String str2) {
    int[][] memo = new int[str1.length()][str2.length()];
    for (int[] arr : memo) Arrays.fill(arr, -1);
    return solve(str1, str2, 0, 0, memo.length, memo[0].length, memo);
  }
}

public class _Longest_Common_Subsequence {

  public static void main(String[] args) {
    System.out.println(new Solution().lcs("bdefg", "bfg"));
  }
}
