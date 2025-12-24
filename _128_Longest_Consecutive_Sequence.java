import java.util.Map.Entry;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
  public int longestConsecutive(int[] nums) {
    if (nums.length == 0)
      return 0;
    Set<Integer> s = new HashSet<>();
    for (int i = 0; i < nums.length; i++)
      s.add(nums[i]);
    int ret_count = 0;
    for (int s_val : s) {
      if (!s.contains(s_val - 1)) {
        int j = 1;
        int count = 0;
        while (s.contains(s_val + (j++)))
          count++;
        ret_count = Math.max(ret_count, count);
      }
    }

    return ret_count;
  }
}

public class _128_Longest_Consecutive_Sequence {
  public static void main(String[] args) {
    System.out.println(new Solution().longestConsecutive(new int[] { 0, 3, 7, 2, 5, 8, 4, 6, 0, 1 }));
  }
}