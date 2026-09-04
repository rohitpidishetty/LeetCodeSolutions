class Solution {

  public int maxSubarraySumCircular(int[] nums) {
    int total = nums[0];

    int maxSum = nums[0];
    int currMaxSum = nums[0];

    int minSum = nums[0];
    int currMinSum = nums[0];

    for (int i = 1; i < nums.length; i++) {
      int num = nums[i];

      total += num;

      currMaxSum = Math.max(currMaxSum + num, num);
      maxSum = Math.max(maxSum, currMaxSum);

      currMinSum = Math.min(currMinSum + num, num);
      minSum = Math.min(minSum, currMinSum);
    }

    if (maxSum < 0) return maxSum;

    int circularMax = total - minSum;

    return Math.max(maxSum, circularMax);
  }
}

public class _918_Maximum_Sum_Circular_Subarray {

  public static void main(String[] args) {
    System.out.println(
      new Solution().maxSubarraySumCircular(new int[] { -1, -1, -1 })
    );
  }
}
