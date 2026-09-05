import java.util.Arrays;

class Solution {

  private int solve(int idx, int[] nums, int[] memo) {
    if (idx >= nums.length) return 0;
    if (memo[idx] != -1) return memo[idx];
    return memo[idx] = Math.max(
      solve(idx + 1, nums, memo),
      nums[idx] + solve(idx + 2, nums, memo)
    );
  }

  public int rob(int[] nums) {
    int[] memo = new int[nums.length];
    Arrays.fill(memo, -1);
    return solve(0, nums, memo);
  }
}

public class _198_House_Robber {

  public static void main(String[] args) {
    System.out.println(new Solution().rob(new int[] { 2, 7, 9, 3, 1 }));
  }
}
