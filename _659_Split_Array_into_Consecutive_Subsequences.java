import java.util.HashMap;
import java.util.Map;

class Solution {

  public boolean isPossible(int[] nums) {
    Map<Integer, Integer> freq = new HashMap<>();
    Map<Integer, Integer> next = new HashMap<>();

    for (int num : nums) freq.put(num, freq.getOrDefault(num, 0) + 1);

    for (int i = 0; i < nums.length; i++) {
      int num = nums[i];

      if (freq.getOrDefault(num, 0) == 0) continue;

      if (next.getOrDefault(num, 0) > 0) {
        int n = next.get(num) - 1;
        if (n > 0) next.put(num, n);
        else next.remove(num);
        next.put(num + 1, next.getOrDefault(num + 1, 0) + 1);
      }
      // num, num + 1, num + 2
      else if (
        freq.getOrDefault(num + 1, 0) > 0 && freq.getOrDefault(num + 2, 0) > 0
      ) {
        freq.put(num + 1, freq.get(num + 1) - 1);
        freq.put(num + 2, freq.get(num + 2) - 1);

        next.put(num + 3, next.getOrDefault(num + 3, 0) + 1);
      } else return false;

      freq.put(num, freq.get(num) - 1);
    }

    return true;
  }
}

public class _659_Split_Array_into_Consecutive_Subsequences {

  public static void main(String[] args) {
    System.out.println(
      new Solution().isPossible(new int[] { 1, 2, 3, 3, 4, 4, 5, 5 })
    );
  }
}
