import java.util.Arrays;

class Solution {

  public void rotate(int[][] matrix) {
    if (matrix == null || matrix.length == 0) return;
    int n = matrix.length;

    for (int i = 0; i < n; i++) {
      for (int j = i; j < n; j++) {
        if (i == j) continue;
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
      }
    }
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n / 2; j++) {
        int temp = matrix[i][(n - 1) - j];
        matrix[i][(n - 1) - j] = matrix[i][j];
        matrix[i][j] = temp;
      }
    }
  }
}

public class _48_Rotate_Image {

  public static void main(String[] args) {
    new Solution().rotate(
      new int[][] {
        { 5, 1, 9, 11 },
        { 2, 4, 8, 10 },
        { 13, 3, 6, 7 },
        { 15, 14, 12, 16 },
      }
    );
  }
}
