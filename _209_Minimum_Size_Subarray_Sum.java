import java.util.HashMap;
import java.util.Map;

class Solution {

  // public int minSubArrayLen(int target, int[] nums) {
  //   int i = 0;
  //   int j = 0;
  //   int sum = 0;
  //   int min = Integer.MAX_VALUE;
  //   while (j < nums.length) {
  //     sum += nums[j];
  //     while (sum >= target && i <= j) {
  //       min = Math.min(min, j - i + 1);
  //       sum -= nums[i];
  //       i++;
  //     }
  //     j++;
  //   }
  //   return min == Integer.MAX_VALUE ? 0 : min;
  // }

  public int minSubArrayLen(int target, int[] nums) {
    int i = 0;
    int sum = 0;
    int min = Integer.MAX_VALUE;
    Map<Integer, Integer> m = new HashMap<>();
    for (; i < nums.length; i++) {
      sum += nums[i];
      m.put(sum, i);
      if (m.containsKey(sum - target)) {
        min = Math.min(min, i - m.get(sum - target));
      }
    }
    return min;
  }
}

public class _209_Minimum_Size_Subarray_Sum {

  public static void main(String[] args) {
    System.out.println(
      new Solution().minSubArrayLen(7, new int[] { 2, 3, 1, 2, 4, 3 })
    );
  }
}
