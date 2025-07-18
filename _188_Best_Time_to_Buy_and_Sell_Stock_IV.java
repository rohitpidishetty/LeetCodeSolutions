import java.util.Arrays;

class Solution {

  private int memo[][][];

  private int solve(
    int k,
    int[] prices,
    int state,
    int index,
    int transactionCompleted
  ) {
    if (k <= transactionCompleted || index > prices.length - 1) return 0;
    // State: 0 -> Buy | 1 -> Sell
    if (
      memo[state][index][transactionCompleted] != Integer.MIN_VALUE
    ) return memo[state][index][transactionCompleted];
    if (state == 0) {
      // We can buy or ignore
      int bought =
        -prices[index] + solve(k, prices, 1, index + 1, transactionCompleted);
      int didNotBuy = solve(k, prices, state, index + 1, transactionCompleted);
      memo[state][index][transactionCompleted] = Math.max(bought, didNotBuy);
      return memo[state][index][transactionCompleted];
    } else {
      // We can sell or ignore
      int sold =
        prices[index] +
        solve(k, prices, 0, index + 1, transactionCompleted + 1); // transaction + 1 as we have completed one whole transaction i.e, bought and sold
      int didNotSell = solve(k, prices, 1, index + 1, transactionCompleted);
      memo[state][index][transactionCompleted] = Math.max(sold, didNotSell);
      return memo[state][index][transactionCompleted];
    }
  }

  public int maxProfit(int k, int[] prices) {
    memo = new int[2][1001][k + 1];
    for (int i = 0; i < 2; i++) for (int j = 0; j < 1001; j++) Arrays.fill(
      memo[i][j],
      Integer.MIN_VALUE
    );
    return solve(k, prices, 0, 0, 0);
  }
}

public class _188_Best_Time_to_Buy_and_Sell_Stock_IV {

  public static void main(String[] args) {
    System.out.println(
      new Solution().maxProfit(2, new int[] { 3, 2, 6, 5, 0, 3 })
    );
  }
}
