import java.util.Arrays;

class Solution {

  public int missingNumber(int[] nums) {
    Arrays.sort(nums);
    int i = nums[0];
    for (; i < i + nums.length; i++) {
      int searchIndex = nums[i];
      if (searchIndex > nums.length - 1) return i + nums[0];
      else nums[searchIndex] *= -1;
    }
    return i;
  }
}

public class _268_Missing_Number {

  public static void main(String[] args) {
    System.out.println(new Solution().missingNumber(new int[] { 1, 2 }));
  }
}
