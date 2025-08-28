import java.util.Arrays;

class NumMatrix {

  private int[][] buffer;

  public NumMatrix(int[][] matrix) {
    int n = matrix.length;
    int m = matrix[0].length;
    buffer = new int[n][m];
    for (int j = 0; j < m; j++) {
      for (int i = 0; i < n; i++) buffer[i][j] = (i == 0)
        ? matrix[i][j]
        : matrix[i][j] + buffer[i - 1][j];
    }

    for (int i = 0; i < n; i++) {
      for (int j = 1; j < m; j++) buffer[i][j] += buffer[i][j - 1];
    }
  }

  public int sumRegion(int row1, int col1, int row2, int col2) {
    int x = buffer[row2][col2] - ((col1 == 0) ? 0 : buffer[row2][col1 - 1]);
    int y =
      (row1 == 0 ? 0 : buffer[row1 - 1][col2]) -
      ((row1 == 0 || col1 == 0) ? 0 : buffer[row1 - 1][col1 - 1]);
    return x - y;
  }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */

public class _304_Range_Sum_Query_2D_Immutable {

  public static void main(String[] args) {
    NumMatrix obj = new NumMatrix(
      new int[][] {
        { 3, 0, 1, 4, 2 },
        { 5, 6, 3, 2, 1 },
        { 1, 2, 0, 1, 5 },
        { 4, 1, 0, 1, 7 },
        { 1, 0, 3, 0, 5 },
      }
    );
    System.out.println(obj.sumRegion(0, 0, 3, 2));
  }
}
