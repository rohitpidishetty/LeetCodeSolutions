class Solution {

  public int searchInsert(int[] nums, int target) {
    int l = 0;
    int h = nums.length - 1;

    while (l <= h) {
      int m = (l + h) / 2;
      if (nums[m] == target) return m;
      else if (target < nums[m]) h = m - 1;
      else l = m + 1;
    }
    return h + 1;
  }
}

public class _35_Search_Insert_Position {

  public static void main(String[] args) {
    System.out.println(
      new Solution().searchInsert(new int[] { 1, 3, 5, 6 }, 5)
    );
  }
}
