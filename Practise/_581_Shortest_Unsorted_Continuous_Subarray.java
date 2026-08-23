class Solution {

  // 120 / 307 testcases passed
  // public int findUnsortedSubarray(int[] nums) {
  //   int n = nums.length, start = 0, end = n - 1;
  //   if (n == 1) return 0;
  //   for (; start < end; start++) if (nums[start] > nums[start + 1]) break;
  //   if (start >= end) return 0;
  //   for (; end > 0; end--) if (nums[end] <= nums[end - 1]) break;
  //   int res = (end - start) + 1;
  //   return res < 0 ? 0 : res;
  // }

  public int findUnsortedSubarray(int[] nums) {
    int start = 0, end = 0;
    int max = nums[0], min = nums[nums.length - 1];
    for (int i = 1; i < nums.length; i++) {
      max = Math.max(max, nums[i]);
      if (nums[i] < max) start = i;
    }
    for (int i = nums.length - 2; i >= 0; i--) {
      min = Math.min(min, nums[i]);
      if (nums[i] > min) end = i;
    }
    return (start - end) != 0 ? (start - end) + 1 : 0;
  }
}

public class _581_Shortest_Unsorted_Continuous_Subarray {

  public static void main(String[] args) {
    int ans = new Solution().findUnsortedSubarray(new int[] { 1, 3, 3, 3 });
    System.out.println(ans);
  }
}
