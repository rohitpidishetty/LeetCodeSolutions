import java.util.HashMap;
import java.util.Map;

class Solution {

  public int maxSubarrayLength(int[] nums, int k) {
    Map<Integer, Integer> freq = new HashMap<>();
    int max = 0;
    int j = 0;
    for (int i = 0; i < nums.length; i++) {
      freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
      while (freq.get(nums[i]) > k) {
        int frq = freq.get(nums[j]);
        if (frq > 1) freq.put(nums[j], frq - 1);
        else freq.remove(nums[j]);
        j++;
      }
      max = Math.max(max, i - j + 1);
    }
    return max;
  }
}

public class _2958_Length_of_Longest_Subarray_With_at_Most_K_Frequency {

  public static void main(String[] args) {
    System.out.println(
      new Solution().maxSubarrayLength(new int[] { 1, 2, 1, 2, 1, 2, 1, 2 }, 1)
    );
  }
}
