class Solution {

  public int surfaceArea(int[][] grid) {
    int area = 0;

    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] > 0) {
          area += 2;
          area += (i == 0)
            ? grid[i][j]
            : Math.max(grid[i][j] - grid[i - 1][j], 0);
          area += (i == n - 1)
            ? grid[i][j]
            : Math.max(grid[i][j] - grid[i + 1][j], 0);
          area += (j == 0)
            ? grid[i][j]
            : Math.max(grid[i][j] - grid[i][j - 1], 0);
          area += (j == n - 1)
            ? grid[i][j]
            : Math.max(grid[i][j] - grid[i][j + 1], 0);
        }
      }
    }
    return 0;
  }
}

public class _892_Surface_Area_of_3D_Shapes {

  public static void main(String[] args) {
    System.out.println(
      new Solution().surfaceArea(
        new int[][] { { 2, 2, 2 }, { 2, 1, 2 }, { 2, 2, 2 } }
      )
    );
  }
}
