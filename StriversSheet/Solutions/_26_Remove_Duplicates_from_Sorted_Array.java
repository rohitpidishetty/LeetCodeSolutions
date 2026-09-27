import java.util.Arrays;

class Solution {

  public int removeDuplicates(int[] nums) {
    int lazy = 0;
    int curr = -101;

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != curr) {
        curr = nums[i];
        nums[lazy] = curr;
        lazy++;
      }
    }

    return lazy;
  }
}

public class _26_Remove_Duplicates_from_Sorted_Array {

  public static void main(String[] args) {
    System.out.println(
      new Solution().removeDuplicates(
        new int[] { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 }
      )
    );
  }
}
