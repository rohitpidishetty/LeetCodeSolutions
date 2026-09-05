import java.util.Arrays;

class Solution {

  public int[] searchRange(int[] nums, int target) {
    int left = -1;
    int l = 0;
    int h = nums.length - 1;
    int m;
    while (l <= h) {
      m = (l + h) / 2;
      if (target == nums[m]) {
        left = m;
        h = m - 1;
      } else if (target < nums[m]) h = m - 1;
      else l = m + 1;
    }
    int right = -1;
    l = 0;
    h = nums.length - 1;
    while (l <= h) {
      m = (l + h) / 2;
      if (target == nums[m]) {
        right = m;
        l = m + 1;
      } else if (target < nums[m]) h = m - 1;
      else l = m + 1;
    }
    return new int[] { left, right };
  }
}

public class _34_Find_First_and_Last_Position_of_Element_in_Sorted_Array {

  public static void main(String[] args) {
    System.out.println(
      Arrays.toString(new Solution().searchRange(new int[] { 1 }, 1))
    );
  }
}
