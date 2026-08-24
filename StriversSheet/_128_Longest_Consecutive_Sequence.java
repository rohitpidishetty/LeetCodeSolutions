import java.util.HashSet;
import java.util.Set;

class Solution {

  public int longestConsecutive(int[] nums) {
    if (nums.length == 0) return 0;
    Set<Integer> set = new HashSet<>();
    int max = 0;
    for (int num : nums) set.add(num);
    for (Integer num : set) {
      int current = num;
      if (!set.contains(current - 1)) {
        int count = 1;
        int next = current + 1;
        while (set.contains(next++)) count++;
        max = Math.max(max, count);
      }
    }
    return max;
  }
}

public class _128_Longest_Consecutive_Sequence {

  public static void main(String[] args) {
    System.out.println(
      new Solution().longestConsecutive(
        new int[] { 0, 3, 7, 2, 5, 8, 4, 6, 0, 1 }
      )
    );
  }
}
