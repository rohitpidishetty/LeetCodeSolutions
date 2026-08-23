class Solution {

  private Integer[][] memo;

  private int solve(String a, int i, String b, int j, int[] s1ps, int[] s2ps) {
    if (i < 0 && j < 0) return 0;
    if (j < 0) return s1ps[i];
    if (i < 0) return s2ps[j];
    if (this.memo[i][j] != null) return this.memo[i][j];
    char _a = a.charAt(i), _b = b.charAt(j);
    if (_a == _b) return (
      this.memo[i][j] = solve(a, i - 1, b, j - 1, s1ps, s2ps)
    );
    return (
      this.memo[i][j] = Math.min(
        ((int) _a) + solve(a, i - 1, b, j, s1ps, s2ps),
        ((int) _b) + solve(a, i, b, j - 1, s1ps, s2ps)
      )
    );
  }

  public int minimumDeleteSum(String s1, String s2) {
    int i, j, n = s1.length(), m = s2.length();
    this.memo = new Integer[n][m];

    int[] s1PreSum = new int[n];
    int[] s2PreSum = new int[m];

    s1PreSum[0] = (int) s1.charAt(0);
    s2PreSum[0] = (int) s2.charAt(0);
    for (i = 1; i < n; i++) s1PreSum[i] += (s1PreSum[i - 1] +
      (int) s1.charAt(i));
    for (i = 1; i < m; i++) s2PreSum[i] += (s2PreSum[i - 1] +
      (int) s2.charAt(i));
    return solve(s1, i = n - 1, s2, j = m - 1, s1PreSum, s2PreSum);
  }
}

public class _712_Minimum_ASCII_Delete_Sum_for_Two_Strings {

  public static void main(String[] args) {
    System.out.println(new Solution().minimumDeleteSum("sea", "eat"));
  }
}
