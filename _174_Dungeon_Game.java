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

    // solve(dungeon, 0, 0, 0, 0);
    // return minInitialHealth;

    int n = dungeon.length - 1;
    int m = dungeon[0].length - 1;
    int infinity = Integer.MAX_VALUE;

    for (int i = n; i >= 0; i--) {
      for (int j = m; j >= 0; j--) {
        if (i == n && j == m)
          dungeon[i][j] = dungeon[i][j] > 0 ? 1 : (dungeon[i][j] * -1) + 1;
        else {
          int right = j + 1 > m ? infinity : dungeon[i][j + 1];
          int down = i + 1 > n ? infinity : dungeon[i + 1][j];
          int result = (right < down) ? right - dungeon[i][j] : down - dungeon[i][j];
          dungeon[i][j] = result <= 0 ? 1 : result;
        }
      }
    }

    return dungeon[0][0];
  }
}

public class _174_Dungeon_Game {
  public static void main(String[] args) {
    System.out.println(new Solution().calculateMinimumHP(new int[][] {
        { -3, 5 }

    }));
  }
}
