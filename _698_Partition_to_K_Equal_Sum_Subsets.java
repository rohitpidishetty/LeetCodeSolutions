import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {

  public boolean canPartitionKSubsets(int[] nums, int k) {
    int sum, idx;
    int count = 0, target = 0;
    for (int n : nums) count += n;
    if (count % k != 0 || nums.length == 0) return false;
    target = count / k;
    boolean[] consumed = new boolean[nums.length];
    int start;
    return solve(nums, target, k, consumed, start = 0, sum = 0);
  }

  private boolean solve(
    int[] nums,
    int target,
    int k,
    boolean[] consumed,
    int start,
    int sum
  ) {
    if (sum > target) return false;
    if (k == 0) return true;
    if (sum == target) return solve(
      nums,
      target,
      k - 1,
      consumed,
      start = 0,
      sum = 0
    );

    for (int i = start; i < nums.length; i++) {
      if (consumed[i] || sum + nums[i] > target) continue;
      consumed[i] = true;
      if (solve(nums, target, k, consumed, i, sum + nums[i])) return true;
      consumed[i] = false;
    }
    return false;
  }
}

public class _698_Partition_to_K_Equal_Sum_Subsets {

  public static void main(String[] args) {
    System.out.println(
      new Solution().canPartitionKSubsets(new int[] { 4, 3, 2, 3, 5, 2, 1 }, 4)
    );
  }
}
