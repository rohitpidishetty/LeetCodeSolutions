import java.util.Arrays;

class Solution {

  public int uniquePaths(int m, int n) {
    int X = m - 1;
    int Y = n - 1;
    int matrix[][] = new int[m][n];
    while (X >= 0) matrix[(X--)][n - 1] = 1;
    while (Y >= 0) matrix[m - 1][(Y--)] = 1;
    for (int i = m - 2; i >= 0; i--) {
      for (int j = n - 2; j >= 0; j--) {
        matrix[i][j] = (matrix[i][j + 1]) + (matrix[i + 1][j]);
      }
    }
    return matrix[0][0];
  }
}

public class _62_Unique_Paths {

  public static void main(String[] args) {
    System.out.println(new Solution().uniquePaths(3, 7));
  }
}
