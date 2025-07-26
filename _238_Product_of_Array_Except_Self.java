import java.util.Arrays;

class Solution {

  public int[] productExceptSelf(int[] nums) {
    if (nums == null) return new int[0];
    int n = nums.length;
    int[] leftProducts = new int[n];
    int[] rightProducts = new int[n];
    leftProducts[0] = nums[0];
    for (int i = 1; i < n; i++) leftProducts[i] = leftProducts[i - 1] * nums[i];
    rightProducts[n - 1] = nums[n - 1];
    for (int i = n - 2; i >= 0; i--) rightProducts[i] =
      rightProducts[i + 1] * nums[i];

    int[] ret = new int[n];
    int idx = 0;
    ret[idx++] = rightProducts[1];
    for (int i = 0; i < n - 2; i++) ret[idx++] =
      leftProducts[i] * rightProducts[i + 2];
    ret[idx++] = leftProducts[n - 2];
    return ret;
  }
}

public class _238_Product_of_Array_Except_Self {

  public static void main(String[] args) {
    System.out.println(
      new Solution().productExceptSelf(new int[] { 1, 2, 3, 4 })
    );
  }
}
