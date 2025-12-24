class Solution {

  private Integer[][] memo;

  private int solve(int[][] matrix, int i, int j, int previous) {
    // Base condition
    if (
      i < 0 ||
      i > matrix.length - 1 ||
      j < 0 ||
      j > matrix[0].length - 1 ||
      matrix[i][j] <= previous
    ) return 0;
    if (memo[i][j] != null) return memo[i][j];
    // Core
    int a = solve(matrix, i - 1, j, matrix[i][j]);
    int b = solve(matrix, i + 1, j, matrix[i][j]);
    int c = solve(matrix, i, j + 1, matrix[i][j]);
    int d = solve(matrix, i, j - 1, matrix[i][j]);

    memo[i][j] = 1 + Math.max(Math.max(a, b), Math.max(c, d));
    return memo[i][j];
  }

  public int longestIncreasingPath(int[][] matrix) {
    memo = new Integer[201][201];
    int MAX_VAL = Integer.MIN_VALUE;
    int n = matrix.length;
    int m = matrix[0].length;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        int max = solve(matrix, i, j, -1);
        MAX_VAL = Math.max(MAX_VAL, max);
      }
    }
    return MAX_VAL;
  }
}

public class _329_Longest_Increasing_Path_in_a_Matrix {

  public static void main(String[] args) {
    System.out.println(
      new Solution()
        .longestIncreasingPath(
          new int[][] { { 9, 9, 4 }, { 6, 6, 8 }, { 2, 1, 1 } }
        )
    );
  }
}
