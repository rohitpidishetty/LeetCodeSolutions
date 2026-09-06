import java.util.HashMap;
import java.util.Map;

class Solution {

  public int numberOfSubarrays(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    int n = nums.length;
    int ans = 0;
    map.put(0, 1);
    int oddCount = 0;
    for (int i = 0; i < n; i++) {
      oddCount += (nums[i] % 2);
      if (map.containsKey(oddCount - k)) ans += map.get(oddCount - k);
      map.put(oddCount, map.getOrDefault(oddCount, 0) + 1);
    }
    return ans;
  }
}

public class _1248_Count_Number_of_Nice_Subarrays {

  public static void main(String[] args) {
    System.out.println(
      new Solution().numberOfSubarrays(
        new int[] { 2, 2, 2, 1, 2, 2, 1, 2, 2, 2 },
        2
      )
    );
  }
}
