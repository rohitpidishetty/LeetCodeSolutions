import java.util.HashMap;
import java.util.Map;

class Solution {

  public int findMaxLength(int[] nums) {
    int currSum = 0;
    Map<Integer, Integer> map = new HashMap<>();
    map.put(0, -1);
    int max = 0;
    for (int i = 0; i < nums.length; i++) {
      currSum += (nums[i] == 0 ? -1 : 1);
      if (map.containsKey(currSum)) max = Math.max(max, i - map.get(currSum));
      else map.put(currSum, i);
    }
    return max;
  }
}

public class _525_Contiguous_Array {

  public static void main(String[] args) {
    System.out.println(
      new Solution().findMaxLength(new int[] { 0, 1, 1, 1, 1, 1, 0, 0, 0 })
    );
  }
}
