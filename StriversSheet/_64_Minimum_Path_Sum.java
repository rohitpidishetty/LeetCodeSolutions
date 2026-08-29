import java.util.Arrays;

class Solution {

  private int dfs(int[][] g, int i, int j, int[][] memo, int n, int m) {
    if (i >= n || j >= m) return Integer.MAX_VALUE;
    if (memo[i][j] != -1) return memo[i][j];
    if (i == n - 1 && j == m - 1) return g[i][j];
    return memo[i][j] =
      g[i][j] +
      Math.min(dfs(g, i, j + 1, memo, n, m), dfs(g, i + 1, j, memo, n, m));
  }

  public int minPathSum(int[][] grid) {
    int n = grid.length;
    int m = grid[0].length;
    int memo[][] = new int[n][m];
    for (int mem[] : memo) Arrays.fill(mem, -1);
    return dfs(grid, 0, 0, memo, n, m);
  }
}

public class _64_Minimum_Path_Sum {

  public static void main(String[] args) {
    System.out.println(
      new Solution().minPathSum(
        new int[][] { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } }
      )
    );
  }
}
