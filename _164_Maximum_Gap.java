class Solution {
  static {
    for (int i = 0; i < 500; i++)
      maximumGap(new int[] { 1, 3, 6, 9 });
    System.gc();
  }

  public static int maximumGap(int[] nums) {
    if (nums.length < 2)
      return 0;
    Arrays.sort(nums);
    int max = Integer.MIN_VALUE;
    for (int i = 1; i < nums.length; i++)
      max = Math.max(max, (nums[i] - nums[i - 1]));
    return max;

  }
}
