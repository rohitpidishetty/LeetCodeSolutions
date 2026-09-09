import java.util.Arrays;

class Solution {

  public long minOperations(int[] nums) {
    long ans = 0l;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i - 1] > nums[i]) {
        ans += (nums[i - 1] - nums[i]);
        nums[i] += (nums[i - 1] - nums[i]);
      }
    }
    System.out.println(Arrays.toString(nums));
    return ans;
  }
}

public class _3914_Minimum_Operations_to_Make_Array_Non_Decreasing {

  public static void main(String[] args) {
    System.out.println(new Solution().minOperations(new int[] { 3, 3, 2, 1 }));
  }
}
