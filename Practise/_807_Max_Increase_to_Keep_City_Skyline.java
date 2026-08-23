import java.util.Arrays;

class Solution {

  public int maxIncreaseKeepingSkyline(int[][] grid) {
    int r[] = new int[grid.length];
    int idx = 0;
    for (int row[] : grid) {
      int max = Integer.MIN_VALUE;
      for (int i = 0; i < row.length; i++) max = Math.max(max, row[i]);
      r[idx++] = max;
    }
    int col[] = new int[grid[0].length];
    idx = 0;
    for (int j = 0; j < col.length; j++) {
      int max = Integer.MIN_VALUE;
      for (int i = 0; i < grid.length; i++) max = Math.max(max, grid[i][j]);
      col[idx++] = max;
    }

    int sum = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        sum += Math.min(r[i], col[j]) - grid[i][j];
      }
    }

    return sum;
  }
}

public class _807_Max_Increase_to_Keep_City_Skyline {

  public static void main(String[] args) {
    System.out.println(
      new Solution().maxIncreaseKeepingSkyline(
        new int[][] {
          { 3, 0, 8, 4 },
          { 2, 4, 5, 7 },
          { 9, 2, 6, 3 },
          { 0, 3, 1, 0 },
        }
      )
    );
  }
}
