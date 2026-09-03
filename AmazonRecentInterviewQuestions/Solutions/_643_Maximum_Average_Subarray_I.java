class Solution {

  public double findMaxAverage(int[] nums, int k) {
    int sum = 0;
    if (nums.length == 1) return (double) nums[0];
    double maxAvg = Integer.MIN_VALUE;
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
      if (i >= k - 1) {
        maxAvg = Math.max(maxAvg, sum);
        sum -= nums[i - k + 1];
      }
    }
    return (double) maxAvg / k;
  }
}

public class _643_Maximum_Average_Subarray_I {

  public static void main(String[] args) {
    System.out.println(
      new Solution().findMaxAverage(new int[] { 1, 12, -5, -6, 50, 3 }, 4)
    );
  }
}
