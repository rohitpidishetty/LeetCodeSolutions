class Solution {

  public int minSubArrayLen(int target, int[] nums) {
    int i = 0;
    int j = 0;
    int sum = 0;
    int min = Integer.MAX_VALUE;
    while (j < nums.length) {
      sum += nums[j];
      while (sum >= target && i <= j) {
        min = Math.min(min, j - i + 1);
        sum -= nums[i];
        i++;
      }
      j++;
    }
    return min == Integer.MAX_VALUE ? 0 : min;
  }
}

public class _209_Minimum_Size_Subarray_Sum {

  public static void main(String[] args) {
    System.out.println(
      new Solution().minSubArrayLen(7, new int[] { 2, 3, 1, 2, 4, 3 })
    );
  }
}
