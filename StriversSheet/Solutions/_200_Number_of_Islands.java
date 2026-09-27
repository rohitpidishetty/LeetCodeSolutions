class Solution {

  private void floodFill(int i, int j, int n, int m, char[][] grid) {
    if (i < 0 || i >= n || j < 0 || j >= m || grid[i][j] == '0') return;
    grid[i][j] = '0';
    floodFill(i - 1, j, n, m, grid);
    floodFill(i + 1, j, n, m, grid);
    floodFill(i, j - 1, n, m, grid);
    floodFill(i, j + 1, n, m, grid);
  }

  public int numIslands(char[][] grid) {
    int n = grid.length;
    int m = grid[0].length;
    int num = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (grid[i][j] != '0') {
          floodFill(i, j, n, m, grid);
          num++;
        }
      }
    }
    return num;
  }
}

public class _200_Number_of_Islands {

  public static void main(String[] args) {
    System.out.println(
      new Solution().numIslands(
        new char[][] {
          { '1', '1', '0', '1', '0' },
          { '1', '1', '0', '1', '0' },
          { '1', '1', '0', '0', '0' },
          { '0', '0', '0', '0', '0' },
        }
      )
    );
  }
}
