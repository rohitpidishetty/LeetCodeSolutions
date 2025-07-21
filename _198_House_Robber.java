class Solution {
  public int rob(int[] nums) {
    if (nums.length == 0)
      return 0;
    if (nums.length == 1)
      return nums[0];
    if (nums.length == 2)
      return Math.max(nums[0], nums[1]);
    int[] dp = new int[nums.length + 1];
    dp[1] = nums[0];
    // dp[i] = nums[i-1]
    for (int i = 2; i < dp.length; i++) {
      int steal = nums[i - 1] + dp[i - 2]; // Consider stealing the current cell. This will also be added with so far collected from alternative houses.
      int skip = dp[i - 1]; // Skip by just considering the previous value.
      dp[i] = Math.max(steal, skip); // Update by calculating the max from both cases.
    }
    return dp[nums.length];
  }
}
