import java.util.Arrays;

class Solution {

  private long[][][] cache;
  private long mod = 1_000_000_007;

  private long solve(
    int people,
    int minProfit,
    int[] group,
    int[] profit,
    int currentProfit,
    int idx
  ) {
    if (people < 0) return 0;
    if (idx == group.length) {
      if (currentProfit >= minProfit) return 1;
      return 0;
    }

    if (
      this.cache[idx][currentProfit][people] != -1
    ) return this.cache[idx][currentProfit][people];
    long skip = solve(people, minProfit, group, profit, currentProfit, idx + 1);
    long take = solve(
      people - group[idx],
      minProfit,
      group,
      profit,
      Math.min(minProfit, currentProfit + profit[idx]),
      idx + 1
    );

    return this.cache[idx][currentProfit][people] = ((skip + take) % this.mod);
  }

  public int profitableSchemes(
    int n,
    int minProfit,
    int[] group,
    int[] profit
  ) {
    this.cache = new long[101][101][101];
    for (long[][] a : this.cache) for (long[] b : a) Arrays.fill(b, -1);
    return (int) (solve(n, minProfit, group, profit, 0, 0) % this.mod);
  }
}

public class _879_Profitable_Schemes {

  public static void main(String[] args) {
    System.out.println(
      new Solution().profitableSchemes(
        10,
        5,
        new int[] { 2, 3, 5 },
        new int[] { 6, 7, 8 }
      )
    );

    System.out.println(
      new Solution().profitableSchemes(
        5,
        3,
        new int[] { 2, 2 },
        new int[] { 2, 3 }
      )
    );
  }
}
