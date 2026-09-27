import java.util.Arrays;

class Solution {

  private int[][] memo;

  private int solve(int i, int j, int n, int m, String a, String b) {
    if (i >= n) return m - j;
    if (j >= m) return n - i;
    if (memo[i][j] != -1) return memo[i][j];
    if (a.charAt(i) == b.charAt(j)) return memo[i][j] = solve(
      i + 1,
      j + 1,
      n,
      m,
      a,
      b
    );
    return memo[i][j] = (1 +
      Math.min(
        Math.min(solve(i + 1, j, n, m, a, b), solve(i, j + 1, n, m, a, b)),
        solve(i + 1, j + 1, n, m, a, b)
      ));
  }

  public int minDistance(String word1, String word2) {
    int n = word1.length();
    int m = word2.length();
    memo = new int[n][m];
    for (int mem[] : memo) Arrays.fill(mem, -1);
    return solve(0, 0, n, m, word1, word2);
  }
}

public class _72_Edit_Distance {

  public static void main(String[] args) {
    System.out.println(new Solution().minDistance("horse", "ros"));
  }
}
