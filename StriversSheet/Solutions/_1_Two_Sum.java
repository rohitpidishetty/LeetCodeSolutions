import java.util.HashMap;
import java.util.Map;

class Solution {

  public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> counterParts = new HashMap<>();
    for (int i = 0; i < nums.length; i++) counterParts.put(nums[i], i);

    for (int i = 0; i < nums.length; i++) {
      int n = target - nums[i];
      if (counterParts.containsKey(n)) {
        int m = counterParts.get(n);
        if (i != m) return new int[] { i, m };
      }
    }
    return null;
  }
}

public class _1_Two_Sum {

  public static void main(String[] args) {
    System.out.println(new Solution().twoSum(new int[] { 2, 7, 11, 15 }, 9));
  }
}
