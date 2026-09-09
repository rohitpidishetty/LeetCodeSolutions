import java.util.Arrays;

class Solution {

  public void rotate(int[][] matrix) {
    int n = matrix.length;
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
      }
    }
    for (int i = 0; i < n; i++) {
      int l = 0;
      int r = n - 1;
      while (l < r) {
        int temp = matrix[i][l];
        matrix[i][l] = matrix[i][r];
        matrix[i][r] = temp;
        l++;
        r--;
      }
    }
  }
}

public class _48_Rotate_Image {

  public static void main(String[] args) {
    int[][] matrix = new int[][] {
      { 5, 1, 9, 11 },
      { 2, 4, 8, 10 },
      { 13, 3, 6, 7 },
      { 15, 14, 12, 16 },
    };
    new Solution().rotate(matrix);
  }
}
