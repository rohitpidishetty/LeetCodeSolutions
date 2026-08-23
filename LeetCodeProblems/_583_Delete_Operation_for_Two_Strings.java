class Solution {

  private Integer[][] memo;

  private int lcs(String w1, int i, String w2, int j) {
    if (i <= 0 || j <= 0) return 0;
    if (this.memo[i][j] != null) return this.memo[i][j];
    if (w1.charAt(i - 1) == w2.charAt(j - 1)) this.memo[i][j] =
      lcs(w1, i - 1, w2, j - 1) + 1;
    else this.memo[i][j] = Math.max(
      lcs(w1, i, w2, j - 1),
      lcs(w1, i - 1, w2, j)
    );
    return this.memo[i][j];
  }

  private int solve(String w1, String w2) {
    int n = w1.length(), m = w2.length();
    this.memo = new Integer[n + 1][m + 1];
    int lcs = lcs(w1, n, w2, m);
    return n + m - 2 * lcs;
  }

  public int minDistance(String word1, String word2) {
    return solve(word1, word2);
  }
}

public class _583_Delete_Operation_for_Two_Strings {

  public static void main(String[] args) {
    System.out.println(new Solution().minDistance("sea", "eat"));
  }
}
