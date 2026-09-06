import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

class Solution {

  private void dfs(
    int i,
    int j,
    int[][] heights,
    boolean[][] visited,
    int prev_i,
    int prev_j,
    int n,
    int m
  ) {
    if (
      i < 0 ||
      i >= n ||
      j < 0 ||
      j >= m ||
      visited[i][j] ||
      heights[i][j] < heights[prev_i][prev_j]
    ) return;

    visited[i][j] = true;
    dfs(i + 1, j, heights, visited, i, j, n, m);
    dfs(i - 1, j, heights, visited, i, j, n, m);
    dfs(i, j + 1, heights, visited, i, j, n, m);
    dfs(i, j - 1, heights, visited, i, j, n, m);
  }

  public List<List<Integer>> pacificAtlantic(int[][] heights) {
    int n = heights.length;
    int m = heights[0].length;
    boolean[][] pacificReachable = new boolean[n][m];
    boolean[][] atlanticReachable = new boolean[n][m];
    List<List<Integer>> ans = new ArrayList<>();

    int i = 0;
    int j = 0;
    for (; j < m; j++) dfs(i, j, heights, pacificReachable, i, j, n, m);
    j--;
    for (; i < n; i++) dfs(i, j, heights, atlanticReachable, i, j, n, m);
    i--;
    for (; j > -1; j--) dfs(i, j, heights, atlanticReachable, i, j, n, m);
    j++;
    for (; i > -1; i--) dfs(i, j, heights, pacificReachable, i, j, n, m);

    for (i = 0; i < n; i++) {
      for (j = 0; j < m; j++) if (
        pacificReachable[i][j] && atlanticReachable[i][j]
      ) ans.add(new ArrayList<>(List.of(i, j)));
    }
    return ans;
  }
}

public class _417_Pacific_Atlantic_Water_Flow {

  public static void main(String[] args) {
    System.out.println(
      new Solution().pacificAtlantic(
        new int[][] {
          { 1, 2, 2, 3, 5 },
          { 3, 2, 3, 4, 4 },
          { 2, 4, 5, 3, 1 },
          { 6, 7, 1, 4, 5 },
          { 5, 1, 1, 2, 4 },
        }
      )
    );
  }
}
