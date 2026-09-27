import java.util.HashMap;
import java.util.Map;

class Solution {

  private int subArrays(int[] nums, int k) {
    if (k < 0) return 0;
    int n = nums.length;
    int ans = 0;

    int oddCount = 0;

    int j = 0;
    for (int i = 0; i < n; i++) {
      if (nums[i] % 2 == 1) oddCount++;
      while (oddCount > k) {
        if (nums[j] % 2 == 1) {
          oddCount--;
        }
        j++;
      }
      ans += (i - j + 1);
    }

    return ans;
  }

  public int numberOfSubarrays(int[] nums, int k) {
    return subArrays(nums, k) - subArrays(nums, k - 1);
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
