import java.util.Arrays;

class Solution {

  private int solve(int[] cuts, int l, int r, int[][] memo) {
    if (r - l < 2) return 0;
    if (memo[l][r] != -1) return memo[l][r];
    int min = Integer.MAX_VALUE;
    for (int i = l + 1; i <= r - 1; i++) {
      int cost =
        (cuts[r] - cuts[l]) + solve(cuts, l, i, memo) + solve(cuts, i, r, memo);
      min = Math.min(min, cost);
    }
    return memo[l][r] = min;
  }

  public int minCost(int n, int[] cuts) {
    int m = cuts.length;
    int newCuts[] = new int[m + 2];
    int i = 1;
    for (; i <= m; i++) newCuts[i] = cuts[i - 1];
    newCuts[i] = n;
    Arrays.sort(newCuts);
    int[][] memo = new int[m + 2][m + 2];
    for (int[] mem : memo) Arrays.fill(mem, -1);
    return solve(newCuts, 0, newCuts.length - 1, memo);
  }
}

public class _1547_Minimum_Cost_to_Cut_a_Stick {

  public static void main(String[] args) {
    System.out.println(new Solution().minCost(7, new int[] { 1, 3, 4, 5 }));
  }
}
