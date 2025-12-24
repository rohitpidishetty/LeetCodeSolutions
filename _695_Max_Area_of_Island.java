class Solution {

  private int dfs(int i, int j, int[][] grid) {
    if (
      i < 0 ||
      i >= grid.length ||
      j < 0 ||
      j >= grid[0].length ||
      grid[i][j] == 0
    ) return 0;
    grid[i][j] = 0;
    int area =
      dfs(i - 1, j, grid) +
      dfs(i, j - 1, grid) +
      dfs(i + 1, j, grid) +
      dfs(i, j + 1, grid);
    return area + 1;
  }

  public int maxAreaOfIsland(int[][] grid) {
    int MAX_AREA = 0;
    for (int i = 0; i < grid.length; i++) for (
      int j = 0;
      j < grid[i].length;
      j++
    ) if (grid[i][j] == 1) MAX_AREA = Math.max(dfs(i, j, grid), MAX_AREA);

    return MAX_AREA;
  }
}

public class _695_Max_Area_of_Island {

  public static void main(String[] args) {
    System.out.println(
      new Solution()
        .maxAreaOfIsland(
          new int[][] {
            { 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 },
            { 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0 },
            { 0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0 },
          }
        )
    );
  }
}
