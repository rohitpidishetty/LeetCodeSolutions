import java.util.Arrays;

class Solution {

  private int solve(int idx, int[] prices, int fee, int bought, int[][] memo) {
    if (idx == prices.length) return 0;
    if (memo[idx][bought] != -1) return memo[idx][bought];

    // skip
    int skip = solve(idx + 1, prices, fee, bought, memo);

    // take
    int take = 0;
    if (bought == 0) take = -prices[idx] + solve(idx + 1, prices, fee, 1, memo);
    else take = prices[idx] + solve(idx + 1, prices, fee, 0, memo) - fee;

    return memo[idx][bought] = Math.max(take, skip);
  }

  public int maxProfit(int[] prices, int fee) {
    int[][] memo = new int[prices.length][2];
    for (int[] mem : memo) Arrays.fill(mem, -1);
    return solve(0, prices, fee, 0, memo);
  }
}

public class _714_Best_Time_to_Buy_and_Sell_Stock_with_Transaction_Fee {

  public static void main(String[] args) {
    System.out.println(
      new Solution().maxProfit(new int[] { 1, 3, 2, 8, 4, 9 }, 2)
    );
  }
}
