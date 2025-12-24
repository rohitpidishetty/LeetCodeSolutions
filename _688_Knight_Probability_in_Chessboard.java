class Solution {

  private int[][] moves = {
    { -1, -2 },
    { -2, -1 },
    { -2, 1 },
    { -1, 2 },
    { 1, 2 },
    { 2, 1 },
    { 2, -1 },
    { 1, -2 },
  };

  private Double[][][] memo;

  private double solve(int n, int k, int r, int c) {
    if (r < 0 || r >= n || c < 0 || c >= n) return 0;
    if (this.memo[r][c][k] != null) return this.memo[r][c][k];
    if (k == 0) return 1;
    double ans = 0;
    for (int i = 0; i < 8; i++) ans += solve(
      n,
      k - 1,
      r + this.moves[i][0],
      c + this.moves[i][1]
    );

    return this.memo[r][c][k] = ((double) ans / (double) 8);
  }

  public double knightProbability(int n, int k, int row, int column) {
    this.memo = new Double[n][n][k + 1];
    return solve(n, k, row, column);
  }
}

public class _688_Knight_Probability_in_Chessboard {

  public static void main(String[] args) {
    System.out.println(new Solution().knightProbability(9, 4, 0, 0));
  }
}
