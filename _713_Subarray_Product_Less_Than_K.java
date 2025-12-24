import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {

  public int numSubarrayProductLessThanK(int[] nums, int k) {
    if (k <= 1) return 0;
    int ans = 0;
    int prod = 1;
    int i = 0, j = 0, n = nums.length;

    for (j = 0; j < n; j++) {
      prod *= nums[j];
      while (i <= j && prod >= k) prod /= nums[i++];
      ans += j - i + 1;
    }
    return ans;
  }
}

public class _713_Subarray_Product_Less_Than_K {

  public static void main(String[] args) {
    System.out.println(
      new Solution().numSubarrayProductLessThanK(new int[] { 10, 5, 2, 6 }, 100)
    );
  }
}
