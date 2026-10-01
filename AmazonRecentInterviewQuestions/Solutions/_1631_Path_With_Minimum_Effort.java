class Solution {

  private boolean dfs(
    int i,
    int j,
    int n,
    int m,
    int[][] heights,
    int effort,
    boolean[][] visited
  ) {
    if (i == n && j == m) return true;
    visited[i][j] = true;
    int[][] dirs = new int[][] { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };
    for (int[] dir : dirs) {
      int ni = dir[0] + i;
      int nj = dir[1] + j;
      if (ni < 0 || ni > n || nj < 0 || nj > m || visited[ni][nj]) continue;
      int diff = Math.abs(heights[i][j] - heights[ni][nj]);
      if (diff > effort) continue;
      visited[ni][nj] = true;
      if (dfs(ni, nj, n, m, heights, effort, visited)) return true;
    }
    return false;
  }

  private boolean isPossible(int[][] heights, int effort, int n, int m) {
    return dfs(0, 0, n - 1, m - 1, heights, effort, new boolean[n][m]);
  }

  public int minimumEffortPath(int[][] heights) {
    int l = 0;
    int h = 0;
    int n = heights.length;
    int m = heights[0].length;

    int min = heights[0][0];
    int max = heights[0][0];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        min = Math.min(min, heights[i][j]);
        max = Math.max(max, heights[i][j]);
      }
    }

    h = max - min;

    while (l <= h) {
      int effort = (l + (h - l) / 2);
      if (isPossible(heights, effort, n, m)) h = effort - 1;
      else l = effort + 1;
    }
    return l;
  }
}

public class _1631_Path_With_Minimum_Effort {

  public static void main(String[] args) {
    System.out.println(
      new Solution().minimumEffortPath(
        new int[][] { { 1, 2, 2 }, { 3, 8, 2 }, { 5, 3, 5 } }
      )
    );
  }
}
