import java.util.ArrayList;
import java.util.Arrays;

class Solution {

  private int minSteps = Integer.MAX_VALUE;

  // Approach - 1
  private void solve(int index, int[] array, int totalSteps) {
    if (index > array.length - 1 || totalSteps > minSteps) return;
    if (index == array.length - 1) {
      if (minSteps > totalSteps) minSteps = totalSteps;
    }

    for (int steps = (index + 1); steps <= index + array[index]; steps++) {
      totalSteps++;
      solve(steps, array, totalSteps);
      totalSteps--;
    }
  }

  public int jump(int[] nums) {
    // solve(0, nums, 0);
    // return minSteps;

    // Approach - 2
    int dp[] = new int[nums.length];
    dp[nums.length - 1] = 0;
    for (int i = nums.length - 2; i >= 0; i--) {
      // CRFD | CRTP
      if (nums[i] + i == nums.length) dp[i] = 1;
      else {
        if (nums[i] == 0) dp[i] = 0;
        else {
          int min = 0;
          for (int j = (nums[i] + i); j >= (i + 1); j--) {
            if (dp[j] != 0) {
              min = dp[j];
              break;
            }
          }
          dp[i] = min + 1;
        }
      }
    }
    return dp[0];
  }
}

public class _45 {

  public static void main(String[] args) {
    System.out.println(new Solution().jump(new int[] { 2, 0, 2, 0, 1 }));
  }
}
