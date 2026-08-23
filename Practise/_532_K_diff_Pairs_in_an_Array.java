import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
  public int findPairs(int[] nums, int k) {
    Arrays.sort(nums);
    Map<Integer, Integer> map = new HashMap<>();
    int count = 0;
    for (int i = 0; i < nums.length; i++) {
      if (k == 0 && i > 0 && nums[i] == nums[i - 1]) {
        count++;
        while (i < nums.length && nums[i] == nums[i - 1])
          i++;
        if (i >= nums.length)
          break;
      }
      if (k != 0 && i > 0 && nums[i] == nums[i - 1])
        continue;
      int key = nums[i] - k;
      boolean flag = map.containsKey(key);
      if (!map.containsKey(nums[i]))
        map.put(nums[i], i);
      if (flag && map.get(key) != i)
        count++;
    }
    return count;
  }
}

public class _532_K_diff_Pairs_in_an_Array {
  public static void main(String[] args) {
    System.out.println(new Solution().findPairs(new int[] { 1, 1, 1, 2, 2 }, 0));
  }
}
