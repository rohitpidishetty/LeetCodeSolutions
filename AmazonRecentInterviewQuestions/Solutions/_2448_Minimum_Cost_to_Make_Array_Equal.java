class Solution {

  public long minCost(int[] nums, int[] cost) {
    long l = 0;
    long h = 0;
    long ans = 0;
    for (int i = 0; i < nums.length; i++) {
      l = Math.min(l, nums[i]);
      h = Math.max(h, nums[i]);
    }
    while (l <= h) {
      long m = (l + h) / 2;
      long currentCost = cost(m, nums, cost);
      long nextCost = cost(m + 1, nums, cost);
      ans = Math.min(currentCost, nextCost);
      if (currentCost < nextCost) h = m - 1;
      else l = m + 1;
    }
    return ans;
  }

  private long cost(long m, int[] nums, int[] cost) {
    long total = 0;
    for (int i = 0; i < nums.length; i++) {
      total += (Math.abs(nums[i] - m) * cost[i]);
    }
    return total;
  }
}

public class _2448_Minimum_Cost_to_Make_Array_Equal {

  public static void main(String[] args) {
    System.out.println(
      new Solution().minCost(
        new int[] { 1, 3, 5, 2 },
        new int[] { 2, 3, 1, 14 }
      )
    );
  }
}
