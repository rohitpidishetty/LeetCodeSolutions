class Solution {

  public int projectionArea(int[][] grid) {
    int n = grid.length;
    int xy = 0,
      yz = 0,
      zx = 0;

    for (int i = 0; i < n; i++) {
      int maxRow = 0;
      int maxCol = 0;
      for (int j = 0; j < n; j++) {
        if (grid[i][j] > 0) xy++;
        maxRow = Math.max(maxRow, grid[i][j]);
        maxCol = Math.max(maxCol, grid[j][i]);
      }
      // System.out.println(i + " " + maxRow + ", " + maxCol);
      yz += maxRow;
      zx += maxCol;
    }
    return xy + yz + zx;
  }
}

public class _883_Projection_Area_of_3D_Shapes {

  public static void main(String[] args) {
    System.out.println(
      new Solution().projectionArea(new int[][] { { 1, 2 }, { 3, 4 } })
    );
  }
}
