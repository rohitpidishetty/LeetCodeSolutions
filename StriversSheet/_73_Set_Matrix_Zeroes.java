import java.util.Arrays;
import java.util.Stack;

class Solution {

  public void setZeroes(int[][] matrix) {
    if (matrix == null || matrix.length == 0) return;
    int n = matrix.length;
    int m = matrix[0].length;
    boolean row_points[] = new boolean[n];
    boolean col_points[] = new boolean[m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (matrix[i][j] == 0) {
          row_points[i] = true;
          col_points[j] = true;
        }
      }
    }

    for (int i = 0; i < n; i++) {
      if (!row_points[i]) continue;
      for (int j = 0; j < m; j++) matrix[i][j] = 0;
    }

    for (int j = 0; j < m; j++) {
      if (!col_points[j]) continue;
      for (int i = 0; i < n; i++) matrix[i][j] = 0;
    }

    // System.out.println(Arrays.deepToString(matrix));
  }
}

public class _73_Set_Matrix_Zeroes {

  public static void main(String[] args) {
    new Solution().setZeroes(
      new int[][] { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 0, 1 } }
    );
  }
}
