class Solution {

  private int find(int l, int r, int[] nums, int t) {
    while (l <= r) {
      int m = (l + r) / 2;
      if (nums[m] == t) return m;
      else if (t < nums[m]) r = m - 1;
      else l = m + 1;
    }
    return -1;
  }

  public int search(int[] nums, int target) {
    return find(0, nums.length - 1, nums, target);
  }
}

public class _704_Binary_Search {

  public static void main(String[] args) {
    System.out.println(
      new Solution().search(new int[] { -1, 0, 3, 5, 9, 12 }, 9)
    );
  }
}
