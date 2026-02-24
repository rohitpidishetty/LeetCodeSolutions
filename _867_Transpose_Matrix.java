class Solution {

  public int[][] transpose(int[][] matrix) {
    int n = matrix.length;
    int m = matrix[0].length;
    int[][] new_mat = new int[m][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) new_mat[j][i] = matrix[i][j];
    }
    return new_mat;
  }
}

public class _867_Transpose_Matrix {

  public static void main(String[] args) {
    System.out.println(
      new Solution().transpose(new int[][] { { 1, 2, 3 }, { 4, 5, 6 } })
    );
  }
}
