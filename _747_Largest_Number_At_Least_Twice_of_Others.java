import java.util.Arrays;

class Solution {

  public int dominantIndex(int[] nums) {
    if (nums.length == 1) return 0;
    int maxIdx = 0, maxNum = 0, secondMax = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] > maxNum) {
        secondMax = maxNum;
        maxNum = nums[i];
        maxIdx = i;
      }
      if (nums[i] > secondMax && nums[i] < maxNum) secondMax = nums[i];
    }
    return maxNum >= (secondMax * 2) ? maxIdx : -1;
  }
}

public class _747_Largest_Number_At_Least_Twice_of_Others {

  public static void main(String[] args) {
    System.out.println(new Solution().dominantIndex(new int[] { 0, 0, 3, 2 }));
  }
}
