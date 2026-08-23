
import java.util.Arrays;

class Solution {
  public int arrayPairSum(int[] nums) {
    Arrays.sort(nums);
    int sum = 0;
    for (int i = 0; i < nums.length; i += 2)
      sum += nums[i];
    return sum;
  }
}

public class _561_Array_Partition {
  public static void main(String[] args) {
    System.out.println(new Solution().arrayPairSum(new int[] { 1, 4, 3, 2 }));
  }
}
