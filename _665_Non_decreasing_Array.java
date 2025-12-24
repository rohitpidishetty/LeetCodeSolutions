class Solution {

  // 323 / 335 testcases passed
  // public boolean checkPossibility(int[] nums) {
  //   int n = nums.length - 1;
  //   int acceptable = nums[n] - 1;
  //   int miscellaneous = 1;
  //   for (int i = n - 1; i > -1; i--) {
  //     if (
  //       nums[i] <= acceptable || (nums[i] == nums[i + 1] && miscellaneous == 1)
  //     ) {
  //       acceptable = nums[i];
  //     } else {
  //       miscellaneous--;
  //       if (miscellaneous < 0) return false;
  //     }
  //   }
  //   return true;
  // }

  public boolean checkPossibility(int[] nums) {
    int n = nums.length;
    int count = 0;
    for (int i = 1; i < n; i++) {
      if (nums[i - 1] <= nums[i]) continue;
      if (count == 1) return false;
      //  Lets try to modify the element
      if (i - 2 >= 0 && nums[i] < nums[i - 2]) nums[i] = nums[i - 1];
      else nums[i - 1] = nums[i];
      count++;
    }
    return true;
  }
}

public class _665_Non_decreasing_Array {

  public static void main(String[] args) {
    System.out.println(
      new Solution().checkPossibility(new int[] { 3, 4, 2, 3 })
    );
    System.out.println(new Solution().checkPossibility(new int[] { 4, 2, 3 }));
    System.out.println(new Solution().checkPossibility(new int[] { 4, 2, 1 }));
  }
}
