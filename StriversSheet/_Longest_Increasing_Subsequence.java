import java.util.HashMap;
import java.util.Map;

class Solution {

  public int LIS(int[] nums) {
    Map<Integer, Integer> maxLis = new HashMap<>();
    // <index, LIS>
    int globalMax = 0;
    int n = nums.length;
    for (int i = 0; i < n; i++) {
      int max = 0;
      for (int j = 0; j < i; j++) {
        if (nums[j] < nums[i]) max = Math.max(max, maxLis.get(j));
      }
      maxLis.put(i, max + 1);
      globalMax = Math.max(globalMax, max + 1);
    }
    return globalMax;
  }
}

public class _Longest_Increasing_Subsequence {

  public static void main(String[] args) {
    System.out.println(new Solution().LIS(new int[] { 0, 1, 0, 3, 2, 3 }));
  }
}
