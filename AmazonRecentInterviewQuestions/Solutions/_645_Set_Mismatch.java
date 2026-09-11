import java.util.Arrays;

class Solution {

  public int[] findErrorNums(int[] nums) {
    Arrays.sort(nums);

    int duplicate = -1;
    int missing = -1;
    int n = nums.length;

    if (nums[0] != 1) missing = 1;

    for (int i = 1; i < n; i++) {
      if (nums[i] == nums[i - 1]) duplicate = nums[i];
      else if (nums[i] > nums[i - 1] + 1) missing = nums[i - 1] + 1;
    }

    if (missing == -1) missing = n;

    return new int[] { duplicate, missing };
  }
}

public class _645_Set_Mismatch {

  public static void main(String[] args) {
    System.out.println(
      Arrays.toString(new Solution().findErrorNums(new int[] { 1, 2, 2, 4 }))
    );
  }
}
