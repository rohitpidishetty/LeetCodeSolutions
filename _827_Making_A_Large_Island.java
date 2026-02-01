import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {

  private int dfs(int i, int j, int n, int[][] grid, int unqId) {
    if (
      i < 0 ||
      j < 0 ||
      i >= n ||
      j >= n ||
      grid[i][j] == unqId ||
      grid[i][j] == 0
    ) return 0;
    grid[i][j] = unqId;
    int area = 0;
    area += dfs(i - 1, j, n, grid, unqId);
    area += dfs(i + 1, j, n, grid, unqId);
    area += dfs(i, j - 1, n, grid, unqId);
    area += dfs(i, j + 1, n, grid, unqId);
    return area + 1;
  }

  public int largestIsland(int[][] grid) {
    Map<Integer, Integer> areas = new HashMap<>();
    int n = grid.length;
    int uniqueId = 2;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == 1) {
          // Flood fill and assign unique value.
          areas.put(uniqueId, dfs(i, j, n, grid, uniqueId));
          uniqueId++;
        }
      }
    }

    areas.put(0, 0);
    areas.put(1, 0);

    int neighbors[][] = new int[][] {
      { -1, 0 },
      { 0, -1 },
      { 1, 0 },
      { 0, 1 },
    };

    int maxArea = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == 0) {
          // Check neighbors
          Set<Integer> marked = new HashSet<>();
          int sum = 1;
          for (int neighbor[] : neighbors) {
            int i_ = neighbor[0] + i,
              j_ = neighbor[1] + j;
            if (i_ < 0 || j_ < 0 || i_ >= n || j_ >= n) continue;

            if (grid[i_][j_] > 1 && !marked.contains(grid[i_][j_])) {
              sum += areas.get(grid[i_][j_]);
              marked.add(grid[i_][j_]);
            }
          }
          maxArea = Math.max(maxArea, sum);
        }
      }
    }
    return maxArea != 0 ? maxArea : (n * n);
  }
}

public class _827_Making_A_Large_Island {

  public static void main(String[] args) {
    System.out.println(
      new Solution().largestIsland(new int[][] { { 1, 1 }, { 1, 1 } })
    );
  }
}
