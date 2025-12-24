class Solution {

  private Integer[][] memo;

  private int solve(int idx, int[] prices, int fee, boolean buy) {
    if (idx == prices.length) return 0;
    int x = ((buy) ? 1 : 0);
    if (this.memo[idx][x] != null) return this.memo[idx][x];
    int take;
    // skip
    int skip = solve(idx + 1, prices, fee, buy);
    if (buy) {
      // take - buy
      take = -prices[idx] + solve(idx + 1, prices, fee, false);
    } else {
      // take - sell
      take = prices[idx] + solve(idx + 1, prices, fee, true) - fee;
    }
    return this.memo[idx][x] = Math.max(skip, take);
  }

  public int maxProfit(int[] prices, int fee) {
    int idx;
    boolean buy;
    this.memo = new Integer[prices.length + 1][2];
    return solve(idx = 0, prices, fee, buy = true);
  }
}

public class _714_Best_Time_to_Buy_and_Sell_Stock_with_Transaction_Fee {

  public static void main(String[] args) {
    System.out.println(
      new Solution().maxProfit(new int[] { 1, 3, 7, 5, 10, 3 }, 3)
    );
  }
}
