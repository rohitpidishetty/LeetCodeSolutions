import java.util.ArrayList;
import java.util.Arrays;

class Solution {

  private int[][] memo;

  private int solve(int amt, int[] cns, int sum, int start, int limit) {
    if (sum > amt || start > limit - 1)
      return 0;
    if (this.memo[sum][start] != -1)
      return this.memo[sum][start];
    if (sum == amt)
      return 1;
    int ans = 0;
    for (int i = start; i < limit; i++)
      ans += solve(amt, cns, sum + cns[i], i, limit);
    return this.memo[sum][start] = ans;
  }

  public int change(int amount, int[] coins) {
    int n = coins.length;
    int sum, start;
    this.memo = new int[amount + 1][n];
    for (int arr[] : this.memo)
      Arrays.fill(arr, -1);
    return solve(amount, coins, sum = 0, start = 0, n);
  }
}

public class _518_Coin_Change_II {
  public static void main(String[] args) {
    System.out.println(new Solution().change(5, new int[] { 1, 2, 5 }));
  }
}
