class Solution {

  private boolean solve(
    int i,
    int n,
    String s1,
    int j,
    int m,
    String s2,
    int k,
    String s3,
    int o,
    Boolean[][][] memo
  ) {
    if (i == n && j == m) return memo[i][j][k] = true;
    if (memo[i][j][k] != null) return memo[i][j][k];
    if (
      i < n &&
      j < m &&
      k < o &&
      s1.charAt(i) == s3.charAt(k) &&
      s2.charAt(j) == s3.charAt(k)
    ) {
      return memo[i][j][k] = (solve(
          i + 1,
          n,
          s1,
          j,
          m,
          s2,
          k + 1,
          s3,
          o,
          memo
        ) ||
        solve(i, n, s1, j + 1, m, s2, k + 1, s3, o, memo));
    } else if (i < n && k < o && s1.charAt(i) == s3.charAt(k)) {
      if (
        solve(i + 1, n, s1, j, m, s2, k + 1, s3, o, memo)
      ) return memo[i][j][k] = true;
      return memo[i][j][k] = false;
    } else if (j < m && k < o && s2.charAt(j) == s3.charAt(k)) {
      if (
        solve(i, n, s1, j + 1, m, s2, k + 1, s3, o, memo)
      ) return memo[i][j][k] = true;
      return memo[i][j][k] = false;
    }
    return memo[i][j][k] = false;
  }

  public boolean isInterleave(String s1, String s2, String s3) {
    int m = s1.length();
    int n = s2.length();
    int o = s3.length();
    if (n + m != o) return false;
    Boolean[][][] memo = new Boolean[m + 1][n + 1][o + 1];

    return solve(0, m, s1, 0, n, s2, 0, s3, o, memo);
  }
}

public class _97_Interleaving_String {

  public static void main(String[] args) {
    System.out.println(
      new Solution().isInterleave("aabcc", "dbbca", "aadbbcbcac")
    );
  }
}
