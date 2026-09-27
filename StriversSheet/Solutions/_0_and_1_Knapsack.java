class Solution {

  private int solve(
    int[] wt,
    int[] val,
    int n,
    int W,
    int idx,
    int currWeight
  ) {
    if (idx >= n) return 0;
    // skip
    int skip = solve(wt, val, n, W, idx + 1, currWeight);

    // take
    int take = 0;

    if (currWeight + wt[idx] <= W) take =
      val[idx] + solve(wt, val, n, W, idx + 1, currWeight + wt[idx]);

    return Math.max(skip, take);
  }

  public int knapsack01(int[] wt, int[] val, int n, int W) {
    return solve(wt, val, n, W, 0, 0);
  }
}

public class _0_and_1_Knapsack {

  public static void main(String[] args) {
    System.out.println(
      new Solution().knapsack01(
        new int[] { 10, 20, 30 },
        new int[] { 60, 100, 120 },
        3,
        50
      )
    );
  }
}
