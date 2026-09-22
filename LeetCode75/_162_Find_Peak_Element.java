class Solution {

  public int findPeakElement(int[] nums) {
    int l = 0;
    int h = nums.length - 1;
    while (l < h) {
      int m = (l + (h - l) / 2);
      if (nums[m] < nums[m + 1]) l = m + 1;
      else h = m;
    }
    return h;
  }
}

public class _162_Find_Peak_Element {

  public static void main(String[] args) {
    System.out.println(
      new Solution().findPeakElement(new int[] { 1, 2, 1, 3, 5, 6, 4 })
    );
  }
}
