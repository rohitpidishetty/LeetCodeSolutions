import java.util.Arrays;

class Solution {

  private int solve(int tot, int index, int[] coins, int[][] memo) {
    if (tot == 0) return 1;
    if (tot < 0 || index >= coins.length) return 0;

    if (memo[tot][index] != -1) return memo[tot][index];

    int take = solve(tot - coins[index], index, coins, memo);
    int skip = solve(tot, index + 1, coins, memo);

    return memo[tot][index] = take + skip;
  }

  public int change(int amount, int[] coins) {
    int[][] memo = new int[amount + 1][coins.length];

    for (int[] row : memo) Arrays.fill(row, -1);

    return solve(amount, 0, coins, memo);
  }
}

public class _518_Coin_Change_II {

  public static void main(String[] args) {
    System.out.println(new Solution().change(5, new int[] { 1, 2, 5 }));
  }
}
