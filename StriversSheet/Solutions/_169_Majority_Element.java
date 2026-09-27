import java.util.Arrays;

class Solution {

  public int majorityElement(int[] nums) {
    Arrays.sort(nums);
    int n = nums.length;
    int threshold = n / 2;
    int count = 0;
    for (int i = 0; i < n; i++) {
      if (i > 0 && nums[i] != nums[i - 1]) count = 0;
      count++;
      if (count > threshold) return nums[i];
    }
    return -1;
  }
}

public class _169_Majority_Element {

  public static void main(String[] args) {
    System.out.println(
      new Solution().majorityElement(new int[] { 2, 2, 1, 1, 1, 2, 2 })
    );
  }
}
