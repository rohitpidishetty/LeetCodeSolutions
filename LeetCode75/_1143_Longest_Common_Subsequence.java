import java.util.Arrays;

class Solution {

  private int solve(
    String str1,
    String str2,
    int i,
    int j,
    int n,
    int m,
    int[][] memo
  ) {
    if (i == n || j == m) return 0;
    if (memo[i][j] != -1) return memo[i][j];
    char a = str1.charAt(i);
    char b = str2.charAt(j);
    if (a == b) return memo[i][j] =
      1 + solve(str1, str2, i + 1, j + 1, n, m, memo);
    return memo[i][j] = Math.max(
      solve(str1, str2, i + 1, j, n, m, memo),
      solve(str1, str2, i, j + 1, n, m, memo)
    );
  }

  public int longestCommonSubsequence(String text1, String text2) {
    int n = text1.length();
    int m = text2.length();
    int[][] memo = new int[n][m];
    for (int[] mem : memo) Arrays.fill(mem, -1);
    return solve(text1, text2, 0, 0, n, m, memo);
  }
}

public class _1143_Longest_Common_Subsequence {

  public static void main(String[] args) {
    System.out.println(new Solution().longestCommonSubsequence("abc", "def"));
  }
}
