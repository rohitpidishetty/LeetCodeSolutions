import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {

  private Map<String, Integer> memo;

  // private int solve(int i, int[] nums, int T) {
  // String key = i + "#" + Arrays.toString(nums);
  // if (this.memo.containsKey(key))
  // return this.memo.get(key);

  // if (i == nums.length && Arrays.stream(nums).sum() == T)
  // return 1;

  // if (i >= nums.length)
  // return 0;

  // int xa = solve(i + 1, nums, T);
  // nums[i] *= -1;
  // int xb = solve(i + 1, nums, T);
  // nums[i] *= -1;
  // this.memo.put(key, (xa + xb));
  // return xa + xb;
  // }

  // public int findTargetSumWays(int[] nums, int target) {
  // this.memo = new HashMap<>();
  // int i = 0;
  // return solve(i, nums, target);
  // }

  private int solve(int i, int sum, int[] nums, int T) {
    if (i == nums.length)
      return sum == T ? 1 : 0;

    String key = i + "," + sum;
    if (memo.containsKey(key))
      return memo.get(key);

    int plus = solve(i + 1, sum + nums[i], nums, T);
    int minus = solve(i + 1, sum - nums[i], nums, T);

    memo.put(key, plus + minus);
    return plus + minus;
  }

  public int findTargetSumWays(int[] nums, int target) {
    this.memo = new HashMap<>();
    return solve(0, 0, nums, target);
  }
}

public class _494_Target_Sum {
  public static void main(String[] args) {
    System.out.println(new Solution().findTargetSumWays(
        new int[] { 6, 20, 22, 38, 11, 15, 22, 30, 0, 17, 34, 29, 7, 42, 46, 49, 30, 7, 14, 5 }, 28));
  }
}
