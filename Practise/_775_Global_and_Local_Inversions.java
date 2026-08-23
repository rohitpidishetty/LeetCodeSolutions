class Solution {

  public boolean isIdealPermutation(int[] nums) {
    for (int i = 0; i < nums.length; i++) {
      if (Math.abs(nums[i] - i) > 1) return false;
    }
    return true;
  }
}

public class _775_Global_and_Local_Inversions {

  public static void main(String[] args) {
    System.out.println(
      new Solution().isIdealPermutation(new int[] { 1, 0, 2 })
    );
  }
}
