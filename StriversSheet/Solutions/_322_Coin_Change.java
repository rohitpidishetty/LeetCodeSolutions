import java.util.Arrays;

class Solution {

  private int solve(int coins[], int amount, int level, int memo[]) {
    if (amount == 0) return 0;
    if (amount < 0) return Integer.MAX_VALUE;
    if (memo[amount] != -1) return memo[amount];

    int min = Integer.MAX_VALUE;
    for (int coin : coins) {
      int res = solve(coins, amount - coin, level + 1, memo);
      if (res != Integer.MAX_VALUE) min = Math.min(min, 1 + res);
    }
    return memo[amount] = min;
  }

  public int coinChange(int[] coins, int amount) {
    int memo[] = new int[amount + 1];
    Arrays.fill(memo, -1);
    int sol = solve(coins, amount, 0, memo);
    return sol == Integer.MAX_VALUE ? -1 : sol;
  }
}

public class _322_Coin_Change {

  public static void main(String[] args) {
    System.out.println(new Solution().coinChange(new int[] { 1, 2, 5 }, 11));
  }
}
