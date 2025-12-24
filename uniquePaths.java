import java.util.Arrays;

class Solution {
  public int uniquePaths(int m, int n) {
    int x[][] = new int[m][n];
    x[m - 1][n - 1] = 1;
    for (int i = m - 1; i >= 0; i--) {
      for (int j = n - 1; j >= 0; j--) {
        if (i == m - 1 && j == n - 1)
          continue;
        x[i][j] = (j + 1 > n - 1 ? 0 : x[i][j + 1]) + (i + 1 > m - 1 ? 0 : x[i + 1][j]);
      }
    }
    return x[0][0];
  }

  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    int r = obstacleGrid.length - 1;
    int c = obstacleGrid[0].length - 1;
    if (obstacleGrid[r][c] == 1)
      return 0;
    obstacleGrid[r][c] = 1;
    for (int i = r; i >= 0; i--) {
      for (int j = c; j >= 0; j--) {
        if (i == r && j == c)
          continue;
        obstacleGrid[i][j] = (obstacleGrid[i][j] == 0)
            ? (j + 1 > c ? 0 : obstacleGrid[i][j + 1]) + (i + 1 > r ? 0 : obstacleGrid[i + 1][j])
            : 0;
      }
    }
    return obstacleGrid[0][0];
  }

  private int findMinPath(int[][] grid, int r, int c, int sum) {
    sum += grid[r][c];
    if (r == 0 && c == 0)
      return sum;
    else if (r == 0 && c != 0)
      return findMinPath(grid, r, c - 1, sum);
    else if (r != 0 && c == 0)
      return findMinPath(grid, r - 1, c, sum);
    else if (grid[r - 1][c] < grid[r][c - 1])
      return findMinPath(grid, r - 1, c, sum);
    else
      return Math.min(findMinPath(grid, r - 1, c, sum), findMinPath(grid, r, c - 1, sum));
  }

  // public int minPathSum(int[][] grid) {
  // return this.findMinPath(grid, grid.length - 1, grid[0].length - 1, 0);
  // }

  public int minPathSum(int[][] grid) {
    int m = grid.length;
    int n = grid[0].length;
    int[][] dp = new int[m][n];

    dp[0][0] = grid[0][0];

    for (int i = 1; i < m; i++)
      dp[i][0] = dp[i - 1][0] + grid[i][0];

    System.out.println(Arrays.deepToString(dp));

    for (int j = 1; j < n; j++)
      dp[0][j] = dp[0][j - 1] + grid[0][j];
    System.out.println(Arrays.deepToString(dp));

    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
      }
    }

    return dp[m - 1][n - 1];
  }

}

public class uniquePaths {
  public static void main(String[] args) {
    // System.out.println(new Solution().uniquePathsWithObstacles(new int[][] { { 0,
    // 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } }));
    System.out.println(new Solution().minPathSum(new int[][] { { 1, 2, 3 }, { 4, 5, 6 } }));
  }
}
