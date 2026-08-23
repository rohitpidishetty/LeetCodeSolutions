import java.util.Arrays;

class Solution {
  public int findMaxConsecutiveOnes(int[] nums) {
    int max = 0;
    int n = nums.length;
    for (int i = 0; i < n; i++) {
      if (i > 0 && nums[i] == 1 && nums[i - 1] != 0)
        nums[i] += nums[i - 1];
      max = Math.max(max, nums[i]);
    }
    return max;
  }
}

public class _485_Max_Consecutive_Ones {
  public static void main(String[] args) {
    System.out.println(new Solution().findMaxConsecutiveOnes(new int[] { 0 }));
  }
}
