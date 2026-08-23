import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

  private Integer[] memo;

  private int solve(int[] buffer, int T) {
    if (T < 0) return 0;
    if (T == 0) return 1;
    if (memo[T] != null) return memo[T];

    int ans = 0;
    for (int num : buffer) ans = ans + solve(buffer, T - num);
    memo[T] = ans;
    return ans;
  }

  public int combinationSum4(int[] nums, int target) {
    Arrays.sort(nums);
    memo = new Integer[target + 1];
    return solve(nums, target);
  }
}

public class _377_Combination_Sum_IV {

  public static void main(String[] args) {
    System.out.println(
      new Solution().combinationSum4(new int[] { 1, 2, 3 }, 4)
    );
  }
}
