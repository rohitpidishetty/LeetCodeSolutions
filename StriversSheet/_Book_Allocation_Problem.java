class Solution {

  private boolean isPossible(int pages, int[] nums, int m) {
    int total = pages;
    int allocs = 1;
    for (int num : nums) {
      if (total >= num) total -= num;
      else {
        allocs++;
        total = pages - num;
      }
    }
    return allocs <= m;
  }

  public int findPages(int[] nums, int m) {
    int l = 0;
    int h = 0;
    for (int num : nums) {
      l = Math.max(l, num);
      h += num;
    }
    while (l <= h) {
      int mid = (l + (h - l) / 2);
      if (isPossible(mid, nums, m)) h = mid - 1;
      else l = mid + 1;
    }
    return l;
  }
}

public class _Book_Allocation_Problem {

  public static void main(String[] args) {
    System.out.println(
      new Solution().findPages(new int[] { 12, 34, 67, 90 }, 2)
    );
  }
}
