import java.util.Arrays;

class Solution {

  public int matrixScore(int[][] grid) {
    int n = grid.length;
    int m = grid[0].length;
    for (int row = 0; row < n; row++) {
      if (
        grid[row][0] == 0 // Flip the row
      ) for (int col = 0; col < m; col++) grid[row][col] = 1 - grid[row][col];
    }
    for (int col = 1; col < m; col++) {
      int zeroCount = 0;
      for (int row = 0; row < n; row++) if (grid[row][col] == 0) zeroCount++;
      int onesCount = n - zeroCount;
      if (zeroCount > onesCount) {
        for (int row = 0; row < n; row++) grid[row][col] = 1 - grid[row][col];
      }
    }
    int sum = 0;
    for (int i = 0; i < n; i++) {
      int rowSum = 0;
      for (int j = 0; j < m; j++) {
        if (grid[i][j] == 1) rowSum += Math.pow(2, (m - j - 1));
      }
      sum += rowSum;
    }
    return sum;
  }
}

public class _861_Score_After_Flipping_Matrix {

  public static void main(String[] args) {
    System.out.println(
      new Solution().matrixScore(
        new int[][] { { 0, 0, 1, 1 }, { 1, 0, 1, 0 }, { 1, 1, 0, 0 } }
      )
    );
  }
}
