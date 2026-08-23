import java.util.Arrays;

class Solution {

  private void spread(int i, int j, char[][] grid) {
    if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) return;
    if (grid[i][j] != '1') return;
    grid[i][j] = '0';
    spread(i - 1, j, grid);
    spread(i + 1, j, grid);
    spread(i, j + 1, grid);
    spread(i, j - 1, grid);
  }

  public int numIslands(char[][] grid) {
    int coutner = 0;

    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        if (grid[i][j] == '1') {
          spread(i, j, grid);
          coutner++;
        }
      }
    }

    return coutner;
  }
}

public class _200_Number_of_Islands {

  public static void main(String[] args) {
    System.out.println(new Solution().numIslands(new char[][] { { '1' } }));
  }
}
