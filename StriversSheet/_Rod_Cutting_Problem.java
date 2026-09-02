import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

  private int solve(int index, int[] price, int n, int[][] memo) {
    if (index >= price.length) return 0;
    if (memo[index][n] != -1) return memo[index][n];
    // skip
    int skip = solve(index + 1, price, n, memo);
    // take
    int take = 0;
    int rodLen = (index + 1);
    if (rodLen <= n) take =
      price[index] + solve(index, price, n - rodLen, memo);
    return memo[index][n] = Math.max(skip, take);
  }

  public int RodCutting(int price[], int n) {
    int[][] memo = new int[n + 1][n + 1];
    for (int[] arr : memo) Arrays.fill(arr, -1);
    return solve(0, price, n, memo);
  }
  // private int solve(int s, int[] p, int n, List<Integer> buff) {
  //   if (n == 0) {
  //     int profit = 0;
  //     for (int i = 0; i < buff.size(); i++) profit += p[buff.get(i) - 1];
  //     return profit;
  //   }
  //   int max = Integer.MIN_VALUE;
  //   for (int i = s; i < n; i++) {
  //     buff.add((i + 1));
  //     max = Math.max(max, solve(i, p, n - (i + 1), buff));
  //     buff.remove(buff.size() - 1);
  //   }
  //   return max;
  // }
  // public int RodCutting(int price[], int n) {
  //   return solve(0, price, n, new ArrayList<>());
  // }
}

public class _Rod_Cutting_Problem {

  public static void main(String[] args) {
    System.out.println(
      new Solution().RodCutting(new int[] { 1, 6, 8, 9, 10, 19, 7, 20 }, 8)
    );
  }
}
