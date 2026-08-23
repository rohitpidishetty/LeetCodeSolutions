class Solution {

  public int maxProfit(int[] prices) {
    int n = prices.length;
    int maxProfit = 0;
    int minSoFar = Integer.MAX_VALUE;
    for (int i = 0; i < n; i++) {
      minSoFar = Math.min(minSoFar, prices[i]);
      int todaysProfit = prices[i] - minSoFar;
      maxProfit = Math.max(maxProfit, todaysProfit);
    }
    return maxProfit;
  }
}

public class _121_Best_Time_to_Buy_and_Sell_Stock {

  public static void main(String[] args) {
    System.out.println(
      new Solution().maxProfit(new int[] { 7, 1, 5, 3, 6, 4 })
    );
  }
}
