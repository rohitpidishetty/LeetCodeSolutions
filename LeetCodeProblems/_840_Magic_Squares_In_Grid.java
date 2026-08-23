class Solution {

  private boolean isMagicSquare(int r, int c, int[][] grid) {
    Integer rowSum = null;
    boolean[] unique = new boolean[10];
    for (int i = 0; i < 3; i++) {
      int sum = 0;
      for (int j = 0; j < 3; j++) {
        if (
          grid[i + r][j + c] < 1 ||
          grid[i + r][j + c] > 9 ||
          unique[grid[i + r][j + c] - 1]
        ) return false;
        sum += grid[i + r][j + c];
        unique[grid[i + r][j + c] - 1] = true;
      }
      if (rowSum == null) rowSum = sum;
      if (rowSum != sum) return false;
    }

    boolean cols = ((grid[r + 0][c] + grid[r + 1][c] + grid[r + 2][c] ==
        rowSum) &&
      (grid[r + 0][c + 1] + grid[r + 1][c + 1] + grid[r + 2][c + 1] ==
        rowSum) &&
      (grid[r + 0][c + 2] + grid[r + 1][c + 2] + grid[r + 2][c + 2] == rowSum));
    if (!cols) return false;

    return (
      (grid[r + 0][c] + grid[r + 1][c + 1] + grid[r + 2][c + 2] == rowSum) &&
      (grid[r + 0][c + 2] + grid[r + 1][c + 1] + grid[r + 2][c] == rowSum)
    );
  }

  public int numMagicSquaresInside(int[][] grid) {
    int n = grid.length,
      m = grid[0].length;
    int count = 0;
    for (int i = 0; i < n - 2; i++) {
      for (int j = 0; j < m - 2; j++) if (isMagicSquare(i, j, grid)) count++;
    }
    return count;
  }
}

public class _840_Magic_Squares_In_Grid {

  public static void main(String[] args) {
    System.out.println(
      new Solution().numMagicSquaresInside(
        new int[][] { { 4, 3, 8, 4 }, { 9, 5, 1, 9 }, { 2, 7, 6, 2 } }
      )
    );
  }
}
