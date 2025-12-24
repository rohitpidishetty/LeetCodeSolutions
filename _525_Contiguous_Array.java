import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
  public int findMaxLength(int[] nums) {
    int n = nums.length;
    Map<Integer, Integer> m = new HashMap<>();
    m.put(0, -1);
    for (int i = 0; i < n; i++)
      if (nums[i] == 0)
        nums[i] = -1;

    int prefix_sum = 0;
    int max = 0;
    for (int i = 0; i < n; i++) {
      prefix_sum += nums[i];

      if (m.containsKey(prefix_sum))
        max = Math.max(max, i - m.get(prefix_sum));
      else
        m.put(prefix_sum, i);
    }
    return max;
  }
}

public class _525_Contiguous_Array {
  public static void main(String[] args) {
    System.out.println(new Solution().findMaxLength(new int[] { 0, 1, 1, 1, 1, 1, 0, 0, 0 }));
  }
}
