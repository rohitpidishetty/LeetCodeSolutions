class Solution {

  private Integer[][] memo;

  private int solve(int[] prices, int transactionStatus, int idx) {
    if (
      memo[idx][transactionStatus] != null
    ) return memo[idx][transactionStatus];
    // Base condition
    if (idx >= prices.length) return 0;

    // SKIP
    int skip = solve(prices, transactionStatus, idx + 1);

    // TAKE
    int take = 0;
    if (transactionStatus == 0) take = -prices[idx] + solve(prices, 1, idx + 1);
    else take = prices[idx] + solve(prices, 0, idx + 2);

    memo[idx][transactionStatus] = Math.max(take, skip);
    return memo[idx][transactionStatus];
  }

  public int maxProfit(int[] prices) {
    memo = new Integer[prices.length + 2][2];

    return solve(prices, 0, 0);
  }
}

public class _309_Best_Time_to_Buy_and_Sell_Stock_with_Cooldown {

  public static void main(String[] args) {
    System.out.println(new Solution().maxProfit(new int[] { 1, 2, 3, 0, 2 }));
  }
}
