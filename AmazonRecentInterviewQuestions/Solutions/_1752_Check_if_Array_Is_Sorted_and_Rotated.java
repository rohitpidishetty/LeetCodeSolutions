class Solution {

  public boolean check(int[] nums) {
    int n = nums.length;

    int segARight = 1;

    while (segARight < n && nums[segARight] >= nums[segARight - 1]) {
      segARight++;
    }

    if (segARight == n) return true;

    int segBRight = segARight + 1;

    while (segBRight < n && nums[segBRight] >= nums[segBRight - 1]) {
      segBRight++;
    }

    if (segBRight != n) return false;

    return nums[n - 1] <= nums[0];
  }
}

public class _1752_Check_if_Array_Is_Sorted_and_Rotated {

  public static void main(String[] args) {
    System.out.println(new Solution().check(new int[] { 2, 1, 3, 4 }));
  }
}
