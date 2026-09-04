import java.util.Arrays;

class Solution {

  public void moveZeroes(int[] nums) {
    int za = -1;
    for (int i = 0; i < nums.length; i++) {
      System.out.println(Arrays.toString(nums) + " za " + za);
      if (nums[i] != 0 && za == -1) continue;
      if (nums[i] == 0 && za == -1) za = i;
      if (nums[i] != 0) {
        nums[za] = nums[i];
        nums[i] = 0;
        za++;
      }
    }
  }
}

public class _283_Move_Zeroes {

  public static void main(String[] args) {
    int[] arr = { 0, 1, 0, 3, 12 };
    new Solution().moveZeroes(arr);
    System.out.println(Arrays.toString(arr));
  }
}
