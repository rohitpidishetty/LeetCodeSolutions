import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

// class Solution {

//   public boolean containsNearbyAlmostDuplicate(
//     int[] nums,
//     int indexDiff,
//     int valueDiff
//   ) {
//     Map<Integer, Integer> m = new HashMap<>();
//     for (int i = 0; i < nums.length; i++) {
//       if (m.containsKey(nums[i])) {
//         if (

//           Math.abs(i - m.get(nums[i])) <= indexDiff &&
//           Math.abs(nums[i] - nums[m.get(nums[i])]) <= valueDiff
//         ) return true;
//       }
//       m.put(nums[i], i);
//     }
//     return false;
//   }
// }

// class Solution {

//   public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
//     for (int i = 0; i < nums.length; i++) {
//       for (int j = Math.max(0, i - indexDiff); j < i; j++) {
//         if (Math.abs((long) nums[i] - nums[j]) <= valueDiff) {
//           return true;
//         }
//       }
//     }
//     return false;
//   }
// }

class Solution {

  public boolean containsNearbyAlmostDuplicate(
    int[] nums,
    int indexDiff,
    int valueDiff
  ) {
    TreeSet<Long> s = new TreeSet<>();
    for (int i = 0; i < nums.length; i++) {
      Long integer = (long) nums[i];
      Long upperBound = integer + valueDiff;
      Long lowerBound = integer - valueDiff;
      // System.out.println("[" + i + "] " + integer);
      // System.out.println(lowerBound + " - " + upperBound);
      Long res = s.floor(upperBound);
      // System.out.println(res);
      if (res != null && res >= lowerBound) return true;
      s.add(integer);
      if (i >= indexDiff) {
        s.remove((long) nums[i - indexDiff]);
      }
      // System.out.println();
    }
    return false;
  }
}

public class _220_Contains_Duplicate_III {

  public static void main(String[] args) {
    System.out.println(
      new Solution()
        .containsNearbyAlmostDuplicate(new int[] { 1, 2, 3, 1 }, 3, 0)
    );
  }
}
