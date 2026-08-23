class Solution {

  public boolean isToeplitzMatrix(int[][] matrix) {
    int n = matrix.length, m = matrix[0].length;
    for (int i = 1; i < n; i++) {
      for (int j = 1; j < m; j++) {
        if (matrix[i][j] != matrix[i - 1][j - 1]) return false;
      }
    }
    return true;
  }
}

public class _766_Toeplitz_Matrix {

  public static void main(String[] args) {
    System.out.println(
      new Solution().isToeplitzMatrix(new int[][] { { 18 }, { 66 } })
    );
  }
}
