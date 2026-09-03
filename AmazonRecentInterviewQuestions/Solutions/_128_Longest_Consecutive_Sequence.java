import java.util.HashSet;
import java.util.Set;

class Solution {

  public int longestConsecutive(int[] nums) {
    Set<Integer> s = new HashSet<>();
    for (int num : nums) s.add(num);
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < nums.length; i++) {
      if (!s.contains(nums[i] - 1)) {
        int n = nums[i];
        int len = 0;
        while (!s.isEmpty() && s.contains(n)) {
          s.remove(n);
          len++;
          n++;
        }
        max = Math.max(len, max);
      }
    }
    return max;
  }
}

public class _128_Longest_Consecutive_Sequence {

  public static void main(String[] args) {
    System.out.println(
      new Solution().longestConsecutive(new int[] { 100, 4, 200, 1, 3, 2 })
    );
  }
}
