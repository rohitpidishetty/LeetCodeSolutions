class Solution {
  private int minInitialHealth = Integer.MAX_VALUE;

  private void solve(int[][] matrix, int i, int j, int sum, int minHealthSoFar) {
    if (i >= matrix.length || j >= matrix[0].length)
      return;
    sum += matrix[i][j];
    minHealthSoFar = Math.min(minHealthSoFar, sum);

    if (i == matrix.length - 1 && j == matrix[0].length - 1) {
      int healthNeeded = minHealthSoFar >= 1 ? 1 : 1 - minHealthSoFar;
      minInitialHealth = Math.min(minInitialHealth, healthNeeded);
      return;
    }
    solve(matrix, i + 1, j, sum, minHealthSoFar);
    solve(matrix, i, j + 1, sum, minHealthSoFar);
  }

  public int calculateMinimumHP(int[][] dungeon) {

    solve(dungeon, 0, 0, 0, 0);
    return minInitialHealth;
  }
}

public class _174_Dungeon_Game {
  public static void main(String[] args) {
    System.out.println(new Solution().calculateMinimumHP(new int[][] {
        { -3, 5 }

    }));
  }
}
