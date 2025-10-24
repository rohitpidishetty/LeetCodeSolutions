import java.util.HashMap;
import java.util.Map;

class Solution {

  // 95 / 102 testcases passed
  // public boolean checkSubarraySum(int[] nums, int k) {
  // int n = nums.length;
  // for (int i = 0; i < n; i++) {
  // int sum = nums[i];
  // for (int j = i + 1; j < n; j++) {
  // sum += nums[j];
  // if (sum % k == 0)
  // return true;
  // }
  // }
  // return false;
  // }

  public boolean checkSubarraySum(int[] nums, int k) {
    int n = nums.length;
    Map<Integer, Integer> map = new HashMap<>();
    int sum = 0;
    for (int i = 0; i < n; i++) {
      sum += nums[i];
      int rem = ((sum % k) + k) % k;
      if (rem == 0 && i > 0)
        return true;
      if (!map.containsKey(rem))
        map.put(rem, i);
      else if (i - map.get(rem) > 1)
        return true;
    }
    return false;
  }
}

public class _523_Continuous_Subarray_Sum {
  public static void main(String[] args) {
    System.out.println(new Solution().checkSubarraySum(new int[] { 1, 0 }, 2));
  }
}
