import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

  private void solve(
    int[] nums,
    int start,
    List<Integer> buff,
    int currentSum,
    int target,
    List<List<Integer>> res
  ) {
    if (currentSum == target) {
      res.add(new ArrayList<>(buff));
      return;
    }
    if (currentSum > target) return;

    for (int i = start; i < nums.length; i++) {
      if (i > start && nums[i] == nums[i - 1]) continue;
      buff.add(nums[i]);
      solve(nums, i + 1, buff, currentSum + nums[i], target, res);
      buff.remove(buff.size() - 1);
    }
  }

  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    List<List<Integer>> buff = new ArrayList<>();
    Arrays.sort(candidates);
    solve(candidates, 0, new ArrayList<>(), 0, target, buff);
    return buff;
  }
}

public class _40_Combination_Sum_II {

  public static void main(String[] args) {
    System.out.println(
      new Solution().combinationSum2(new int[] { 10, 1, 2, 7, 6, 1, 5 }, 8)
    );
  }
}
