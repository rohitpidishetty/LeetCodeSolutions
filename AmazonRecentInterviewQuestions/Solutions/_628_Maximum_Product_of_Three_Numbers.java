import java.util.Arrays;

class Solution {

  public int maximumProduct(int[] nums) {
    Arrays.sort(nums);
    int n = nums.length;

    return Math.max(
      nums[n - 1] * nums[n - 2] * nums[n - 3],
      nums[0] * nums[1] * nums[n - 1]
    );
  }
}

public class _628_Maximum_Product_of_Three_Numbers {

  public static void main(String[] args) {
    System.out.println(new Solution().maximumProduct(new int[] { 1, 2, 3, 4 }));
  }
}
