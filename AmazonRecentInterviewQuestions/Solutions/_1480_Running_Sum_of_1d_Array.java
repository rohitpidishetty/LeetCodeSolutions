class Solution {

  public int[] runningSum(int[] nums) {
    for (int i = 1; i < nums.length; i++) nums[i] += nums[i - 1];
    return nums;
  }
}

public class _1480_Running_Sum_of_1d_Array {

  public static void main(String[] args) {
    System.out.println(new Solution().runningSum(new int[] { 1, 2, 3, 4 }));
  }
}
