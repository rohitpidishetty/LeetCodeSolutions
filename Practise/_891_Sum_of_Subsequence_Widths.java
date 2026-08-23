import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

  private int MOD = (int) 1e9 + 7;
  private Map<String, Long> cache;

  public long solve(int index, int[] nums, int min, int max) {
    String key = index + ";" + min + ";" + max;
    if (cache.containsKey(key)) return cache.get(key);
    if (index == nums.length) {
      if (min > max) return 0;
      long res = (Math.abs(nums[min] - nums[max]) % MOD);
      cache.put(key, res);
      return res;
    }
    long skip = solve(index + 1, nums, min, max); // skip
    long take = solve(
      index + 1,
      nums,
      nums[index] < nums[min] ? index : min,
      nums[index] > nums[max] ? index : max
    ); // take
    long result = ((skip + take) % MOD);
    cache.put(key, result);
    return result;
  }

  public int sumSubseqWidths(int[] nums) {
    int index;
    Arrays.sort(nums);
    int n = nums.length;
    cache = new HashMap<>();

    int ans = (int) (solve(index = 0, nums, nums.length - 1, 0) % MOD);
    return ans;
  }
}

public class _891_Sum_of_Subsequence_Widths {

  public static void main(String[] args) {
    System.out.println(new Solution().sumSubseqWidths(new int[] { 1, 2, 4 }));
    System.out.println(new Solution().sumSubseqWidths(new int[] { 1, 2, 3 }));
  }
}
