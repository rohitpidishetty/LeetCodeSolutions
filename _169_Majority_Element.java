import java.util.Arrays;

class Solution {
  public int majorityElement(int[] nums) {
    Arrays.sort(nums);
    int i = 0;
    int j = 0;
    int max = Integer.MIN_VALUE;
    int maxEle = max;
    while (i < nums.length) {
      while (j < nums.length && nums[j] == nums[i])
        j++;
      if (j - i > max) {
        maxEle = nums[i];
        max = (j - i);
      }
      i = j;
    }
    return maxEle;
  }
}

public class _169_Majority_Element {
  public static void main(String[] args) {
    System.out.println(new Solution().majorityElement(new int[] { 2, 2, 1, 1, 1 }));
  }
}
