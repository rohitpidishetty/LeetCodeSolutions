class Solution {
  public int findMin(int[] nums) {
    int i = 0;
    int j = nums.length - 1;
    while (i <= j) {
      // System.out.println(i + " -- " + j);
      if (j - i == 1 || i == j)
        return Math.min(nums[i], nums[j]);
      int m = (i + j) / 2;
      if (nums[i] <= nums[m]) {
        if (nums[i] >= nums[j]) {
          i = m + 1;
        } else
          j = m;
      } else {
        if (nums[i] <= nums[j]) {
          i = m + 1;
        } else
          j = m;
      }
    }
    return 0;
  }

  public int findMin_duplicates(int[] nums) {
    int i = 0;
    int j = nums.length - 1;
    while (i <= j) {
      if (j - i == 1 || i == j)
        return Math.min(nums[i], nums[j]);
      int m = (i + j) / 2;
      if (nums[i] < nums[m]) {
        if (nums[i] >= nums[j]) {
          i = m + 1;
        } else
          j = m;
      } else {
        if (nums[i] < nums[j]) {
          i = m + 1;
        } else
          j = m;
      }
    }
    return 0;
  }
}

public class _153_Find_Minimum_in_Rotated_Sorted_Array {
  public static void main(String[] args) {
    System.out.println(new Solution().findMin(new int[] { 3, 1, 2 }));
    System.out.println(new Solution().findMin_duplicates(new int[] { 3, 1, 3 }));
  }
}
