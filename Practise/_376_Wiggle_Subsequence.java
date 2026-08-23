import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// class Solution {

//   private static int max;

//   private static Map<String, Integer> memo;

//   static {
//     for (int i = 0; i < 200; i++) wiggleMaxLength(
//       new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 }
//     );
//     System.gc();
//   }

//   private static int solve(int index, int nums[], boolean direction, int prev) {
//     String key = new StringBuilder()
//       .append(index)
//       .append("|")
//       .append(direction)
//       .append("|")
//       .append(prev)
//       .toString();
//     if (memo.containsKey(key)) return memo.get(key);

//     if (prev != Integer.MIN_VALUE) {
//       if (direction && nums[index] <= prev) return 0;
//       if (!direction && nums[index] >= prev) return 0;
//     }

//     int ans = 1;
//     int best = 0;
//     for (int i = index + 1; i < nums.length; i++) {
//       best = Math.max(best, solve(i, nums, !direction, nums[index]));
//     }
//     ans += best;
//     memo.put(key, ans);
//     return ans;
//   }

//   public static int wiggleMaxLength(int[] nums) {
//     max = 0;
//     memo = new HashMap<>();
//     for (int i = 0; i < nums.length; i++) {
//       max = Math.max(solve(i, nums, true, Integer.MIN_VALUE), max);
//       max = Math.max(solve(i, nums, false, Integer.MIN_VALUE), max);
//     }

//     return max;
//   }
// }

class Solution {

  private int max;

  public int wiggleMaxLength(int[] nums) {
    max = 1;
    int prev1 = 1;
    int prev2 = 1;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] > nums[i - 1]) prev1 = prev2 + 1;
      else if (nums[i] < nums[i - 1]) prev2 = prev1 + 1;
    }
    return Math.max(prev1, prev2);
  }
}

public class _376_Wiggle_Subsequence {

  public static void main(String[] args) {
    System.out.println(
      new Solution()
        .wiggleMaxLength(new int[] { 1, 17, 5, 10, 13, 15, 10, 5, 16, 8 })
    );
  }
}
