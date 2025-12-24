import java.util.Arrays;

// class Solution {

//   public int maximalSquare(char[][] matrix) {
//     int max = Integer.MIN_VALUE;
//     for (int i = 1; i < matrix.length; i++) {
//       for (int j = 1; j < matrix[0].length; j++) {
//         if (matrix[i][j] == '0') continue;
//         matrix[i][j] = (char) (Math.min(
//             Math.min((int) matrix[i - 1][j], (int) matrix[i][j - 1]),
//             (int) matrix[i - 1][j - 1]
//           ) +
//           1);
//         max = Math.max(matrix[i][j] - '0', max);
//       }
//     }
//     return max != Integer.MIN_VALUE ? max * max : 1;
//   }
// }

class Solution {

  public int maximalSquare(char[][] matrix) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;

    int rows = matrix.length, cols = matrix[0].length;
    int[][] dp = new int[rows][cols];
    int max = 0;

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        if (matrix[i][j] == '1') {
          if (i == 0 || j == 0) {
            dp[i][j] = 1;
          } else {
            dp[i][j] =
              Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) +
              1;
          }
          max = Math.max(max, dp[i][j]);
        }
      }
    }
    return max * max;
  }
}

public class _221_Maximal_Square {

  public static void main(String[] args) {
    System.out.println(new Solution().maximalSquare(new char[][] { { '0' } }));
  }
}
