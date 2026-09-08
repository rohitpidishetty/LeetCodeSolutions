import java.util.Arrays;

class Solution {

  public int maxFrequency(int[] nums, int k) {
    Arrays.sort(nums);
    int l = 0;
    int r = 0;
    int n = nums.length;
    long sum = 0;
    int max = 0;
    for (; r < n; r++) {
      sum += nums[r];
      while ((long) nums[r] * (r - l + 1) - sum > k) sum -= nums[l++];
      max = Math.max(max, (r - l + 1));
    }
    return max;
  }
}

public class _1838_Frequency_of_the_Most_Frequent_Element {

  public static void main(String[] args) {
    System.out.println(new Solution().maxFrequency(new int[] { 1, 2, 4 }, 5));
  }
}
