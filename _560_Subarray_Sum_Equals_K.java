import java.util.HashMap;
import java.util.Map;

class Solution {
  public int subarraySum(int[] nums, int k) {

    Map<Integer, Integer> map = new HashMap<>();
    int prefix_sum = 0, count = 0, idx = 0;
    map.put(0, 1);
    for (int n : nums) {
      prefix_sum += n;
      if (map.containsKey(prefix_sum - k))
        count += map.get(prefix_sum - k);
      map.put(prefix_sum, map.getOrDefault(prefix_sum, 0) + 1);
      idx++;
    }
    return count;
  }
}

public class _560_Subarray_Sum_Equals_K {
  public static void main(String[] args) {
    int k;
    System.out.println(new Solution().subarraySum(new int[] { 1 }, k = 0));
  }
}
