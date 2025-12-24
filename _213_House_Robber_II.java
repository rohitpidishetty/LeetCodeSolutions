class Solution {

  public int rob(int[] nums) {
    int n = nums.length;
    if (n == 0) return 0;
    if (n == 1) return nums[0];
    if (n == 2) return Math.max(nums[0], nums[1]);

    // Case 1: Rob from index 0 to n-2
    // Case 2: Rob from index 1 to n-1
    return Math.max(robRange(nums, 0, n - 2), robRange(nums, 1, n - 1));
  }

  private int robRange(int[] nums, int start, int end) {
    int[] dp = new int[end - start + 2];
    dp[1] = nums[start];
    for (int i = 2; i < dp.length; i++) {
      int steal = nums[start + i - 1] + dp[i - 2];
      int skip = dp[i - 1];
      dp[i] = Math.max(steal, skip);
    }
    return dp[dp.length - 1];
  }
}

public class _213_House_Robber_II {

  public static void main(String[] args) {
    System.out.println(new Solution().rob(new int[] { 1, 3, 1, 3, 100 }));
  }
}
