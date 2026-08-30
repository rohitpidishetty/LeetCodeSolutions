import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {

  public int subarraySum(int[] nums, int k) {
    int prefixSum[] = new int[nums.length];

    prefixSum[0] = nums[0];

    for (int i = 1; i < nums.length; i++) {
      prefixSum[i] = nums[i] + prefixSum[i - 1];
    }

    Map<Integer, Integer> m = new HashMap<>();
    m.put(0, 1);

    int count = 0;
    for (int i = 0; i < prefixSum.length; i++) {
      System.out.println(prefixSum[i]);
      if (m.containsKey(prefixSum[i] - k)) count += m.get(prefixSum[i] - k);
      m.put(prefixSum[i], m.getOrDefault(prefixSum[i], 0) + 1);
    }

    return count;
  }
}

public class _560_Subarray_Sum_Equals_K {

  public static void main(String[] args) {
    System.out.println(
      new Solution().subarraySum(new int[] { 1, 5, 7, 1, 2, 2, 1 }, 6)
    );
    System.out.println(new Solution().subarraySum(new int[] { 1, 1, 1 }, 2));
  }
}
