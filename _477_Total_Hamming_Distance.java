import java.util.HashMap;
import java.util.Map;

class Solution {

  /**
   * 
   * 35 / 46 testcases passed
   * private Map<String, Integer> memo;
   * 
   * private int hammingDistance(long a, long b) {
   * String key1 = (a + "," + b), key2 = (b + "," + a);
   * if (memo.containsKey(key1))
   * return memo.get(key1);
   * if (memo.containsKey(key2))
   * return memo.get(key2);
   * int diff = 0;
   * for (int i = 0; i < 31; i++)
   * if ((((1 << i) & a) == 0 ? 0 : 1) != (((1 << i) & b) == 0 ? 0 : 1))
   * diff++;
   * memo.put(key1, diff);
   * memo.put(key2, diff);
   * return diff;
   * }
   * 
   * public int totalHammingDistance(int[] nums) {
   * this.memo = new HashMap<>();
   * int sum = 0;
   * for (int i = 0; i < nums.length - 1; i++) {
   * for (int j = i + 1; j < nums.length; j++)
   * sum += hammingDistance((long) nums[i], (long) nums[j]);
   * }
   * return sum;
   * }
   */

  public int totalHammingDistance(int[] nums) {
    int bit = 0, count = 0;
    for (int i = 0; i < 31; i++) {
      int pos = (1 << i), zeros = 0;
      for (int n : nums)
        if (((n & pos) == 0 ? 0 : 1) == 0)
          zeros++;
      count += (zeros * (nums.length - zeros));
    }
    return count;
  }
}

public class _477_Total_Hamming_Distance {
  public static void main(String[] args) {
    System.out.println(new Solution().totalHammingDistance(new int[] { 4, 14, 4 }));
  }
}
