class Solution {

  private boolean solve(
    int p1s,
    int[] nums,
    int idx,
    int n,
    int sum,
    Boolean[][] memo
  ) {
    if (sum == p1s) return true;
    if (sum > p1s || idx >= n) return false;
    if (memo[idx][sum] != null) return memo[idx][sum];
    // skip
    boolean skip = solve(p1s, nums, idx + 1, n, sum, memo);

    // take
    boolean take = solve(p1s, nums, idx + 1, n, sum + nums[idx], memo);
    return memo[idx][sum] = skip || take;
  }

  public boolean canPartition(int[] nums) {
    int total = 0;
    for (int num : nums) total += num;
    if (total % 2 != 0) return false;
    int partition1 = total / 2;
    Boolean[][] memo = new Boolean[nums.length][partition1];
    // find another partition sum with sum that is equal to partition1.

    return solve(partition1, nums, 0, nums.length, 0, memo);
  }
}

public class _41_Partition_Equal_Subset_Sum {

  public static void main(String[] args) {
    System.out.println(new Solution().canPartition(new int[] { 1, 5, 11, 5 }));
  }
}
