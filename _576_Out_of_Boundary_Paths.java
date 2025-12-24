class Solution {
  private Long[][][] memo;

  private long dfs(int i, int j, int m, int n, int maxMoves) {
    if (i < 0 || i > m - 1 || j < 0 || j > n - 1)
      return 1;

    if (maxMoves == 0)
      return 0;
    if (this.memo[i][j][maxMoves] != null)
      return this.memo[i][j][maxMoves];
    long ans = 0;

    ans += dfs(i + 1, j, m, n, maxMoves - 1) % 1_000_000_007;
    ans += dfs(i - 1, j, m, n, maxMoves - 1) % 1_000_000_007;
    ans += dfs(i, j + 1, m, n, maxMoves - 1) % 1_000_000_007;
    ans += dfs(i, j - 1, m, n, maxMoves - 1) % 1_000_000_007;
    this.memo[i][j][maxMoves] = ans % 1_000_000_007;

    return ans % 1_000_000_007;
  }

  public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {

    this.memo = new Long[m][n][maxMove + 1];

    return (int) dfs(startRow, startColumn, m, n, maxMove) % 1_000_000_007;
  }
}

public class _576_Out_of_Boundary_Paths {
  public static void main(String[] args) {
    int m, n, maxMove, startRow, startColumn;
    System.out.println(new Solution().findPaths(m = 36, n = 5, maxMove = 50, startRow = 15, startColumn = 3));
  }
}
