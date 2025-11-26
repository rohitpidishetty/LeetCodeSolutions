import java.util.*;

class Solution {

  public int findLengthOfLCIS(int[] nums) {
    int n = nums.length;
    int count[] = new int[n];
    Arrays.fill(count, 1);
    int max = Integer.MIN_VALUE;
    for (int i = 1; i < n; i++) {
      if (nums[i] > nums[i - 1]) {
        count[i] += count[i - 1];
        max = Math.max(max, count[i]);
      }
    }
    return max == Integer.MIN_VALUE ? 1 : max;
  }
}

public class _674_Longest_Continuous_Increasing_Subsequence {

  public static void main(String[] args) {
    System.out.println(
      new Solution().findLengthOfLCIS(new int[] { 1, 3, 5, 4, 7 })
    );
  }
}
