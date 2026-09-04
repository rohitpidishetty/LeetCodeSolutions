class Solution {

  public int findMin(int[] nums) {
    int l = 0;
    int h = nums.length - 1;
    while (l < h) {
      int m = (l + h) / 2;
      if (nums[l] <= nums[m] && nums[h] < nums[m]) l = m + 1;
      else h = m;
    }
    return nums[l];
  }
}

public class _153_Find_Minimum_in_Rotated_Sorted_Array {

  public static void main(String[] args) {
    System.out.println(new Solution().findMin(new int[] { 3, 1, 2 }));
  }
}
