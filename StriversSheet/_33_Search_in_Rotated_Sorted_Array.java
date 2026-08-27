class Solution {

  public int search(int[] nums, int target) {
    int l = 0;
    int r = nums.length - 1;
    if (r == 0) return nums[0] == target ? 0 : -1;
    while (l <= r) {
      int m = (l + r) / 2;
      if (nums[m] == target) return m;
      else if (nums[l] <= nums[m]) {
        if (target >= nums[l] && target <= nums[m]) r = m - 1;
        else l = m + 1;
      } else {
        if (target >= nums[m] && target <= nums[r]) l = m + 1;
        else r = m - 1;
      }
    }
    return -1;
  }
}

public class _33_Search_in_Rotated_Sorted_Array {

  public static void main(String[] args) {
    System.out.println(
      new Solution().search(new int[] { 4, 5, 6, 7, 0, 1, 2 }, 0)
    );
  }
}
