import java.util.ArrayList;
import java.util.List;

class Solution {

  private Boolean[][] memo;

  private int sum(int[] buff) {
    int s = 0;
    for (int b : buff) s += b;
    return s;
  }

  private boolean find(int[] nums, int element, int index, int count) {
    if (count > element) return false;
    if (index > nums.length - 1) return false;
    if (count == element) return true;
    if (memo[index][count] != null) return memo[index][count];
    // skip
    boolean skip = find(nums, element, index + 1, count);
    // take
    boolean take = find(nums, element, index + 1, count + nums[index]);
    boolean ans = (skip || take);
    memo[index][count] = ans;
    return ans;
  }

  public boolean canPartition(int[] nums) {
    int sum = sum(nums);
    int count = 0;
    if (sum % 2 == 1) return false;
    int n = (sum / 2);
    memo = new Boolean[nums.length][n + 1];
    return find(nums, n, 0, count);
  }
}

public class _416_Partition_Equal_Subset_Sum {

  public static void main(String[] args) {
    System.out.println(new Solution().canPartition(new int[] { 1, 5, 11, 5 }));
  }
}
