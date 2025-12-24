class Solution {

  private Integer[][][] memo;

  private int solve(int i1, int j1, int i2, int[][] grid) {
    int j2 = i1 + j1 - i2;

    if (
      i1 < 0 ||
      i1 > grid.length - 1 ||
      j1 < 0 ||
      j1 > grid[0].length - 1 ||
      i2 < 0 ||
      i2 > grid.length - 1 ||
      j2 < 0 ||
      j2 > grid[0].length - 1 ||
      grid[i1][j1] == -1 ||
      grid[i2][j2] == -1
    ) return Integer.MIN_VALUE;

    if (this.memo[i1][j1][i2] != null) return this.memo[i1][j1][i2];

    if (i1 == grid.length - 1 && j1 == grid[0].length - 1) return grid[i1][j1];

    int res = (i1 == i2 && j1 == j2)
      ? grid[i1][j1]
      : grid[i1][j1] + grid[i2][j2];

    int n =
      res +
      Math.max(
        Math.max(solve(i1, j1 + 1, i2, grid), solve(i1 + 1, j1, i2, grid)),
        Math.max(
          solve(i1, j1 + 1, i2 + 1, grid),
          solve(i1 + 1, j1, i2 + 1, grid)
        )
      );

    this.memo[i1][j1][i2] = n;
    return n;
  }

  public int cherryPickup(int[][] grid) {
    int i1, j1, i2, j2, sum;
    int n = grid.length;
    this.memo = new Integer[n][n][n];
    return Math.max(0, solve(i1 = 0, j1 = 0, i2 = 0, grid));
  }
}

public class _741_Cherry_Pickup {

  public static void main(String[] args) {
    System.out.println(
      new Solution()
        .cherryPickup(new int[][] { { 0, 1, -1 }, { 1, 0, -1 }, { 1, 1, 1 } })
    );
  }
}
