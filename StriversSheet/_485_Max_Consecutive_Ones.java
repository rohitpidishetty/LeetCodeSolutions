class Solution {

  public int findMaxConsecutiveOnes(int[] nums) {
    int max = 0;
    int sum = 0;
    for (int i = 0; i < nums.length; i++) {
      sum = nums[i] == 0 ? 0 : sum + 1;
      max = Math.max(max, sum);
    }
    return max;
  }
}

public class _485_Max_Consecutive_Ones {

  public static void main(String[] args) {
    System.out.println(
      new Solution().findMaxConsecutiveOnes(new int[] { 1, 1, 0, 1, 1, 1 })
    );
  }
}
