class Solution {

  public int maxRotateFunction(int[] nums) {
    int sum = 0;
    int prev = 0;
    int max = Integer.MIN_VALUE;
    int i = 0;
    for (int n : nums) {
      prev += (i++ * n);
      sum += n;
    }
    i = nums.length - 1;
    for (; i >= 0; i--) {
      prev = prev + sum - ((nums[i] * (nums.length - 1)) + nums[i]);
      max = Math.max(prev, max);
    }
    return max;
  }
}

public class _396_Rotate_Function {

  public static void main(String[] args) {
    System.out.println(
      "ans:" + new Solution().maxRotateFunction(new int[] { 4, 3, 2, 6 })
    );
  }
}
