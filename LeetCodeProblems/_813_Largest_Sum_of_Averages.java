import java.util.*;

class Solution {

  private int[] prefixSum;
  private int total;
  private Map<String, Double> memo;

  private double solve(int[] nums, int idx, int k) {
    String key = idx + "-" + k;
    if (memo.containsKey(key)) return memo.get(key);

    int n = nums.length;

    if (k == 0) {
      double sum = (prefixSum[n] - prefixSum[idx]) / (double) (n - idx);
      memo.put(key, sum);
      return sum;
    }

    double maxSum = 0.0;

    for (int i = idx + 1; i <= n - k; i++) {
      double current = (prefixSum[i] - prefixSum[idx]) / (double) (i - idx);
      double next = solve(nums, i, k - 1);
      maxSum = Math.max(maxSum, current + next);
    }

    memo.put(key, maxSum);
    return maxSum;
  }

  public double largestSumOfAverages(int[] nums, int k) {
    int n = nums.length;
    prefixSum = new int[n + 1];
    prefixSum[0] = 0;
    for (int i = 0; i < n; i++) prefixSum[i + 1] = prefixSum[i] + nums[i];
    total = prefixSum[n];

    memo = new HashMap<>();
    return solve(nums, 0, k - 1);
  }
}

public class _813_Largest_Sum_of_Averages {

  public static void main(String[] args) {
    System.out.println(
      new Solution().largestSumOfAverages(new int[] { 1, 2, 3, 4, 5, 6, 7 }, 4)
    );

    System.out.println(
      new Solution().largestSumOfAverages(new int[] { 1, 2 }, 1)
    );
  }
}
