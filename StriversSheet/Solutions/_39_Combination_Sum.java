import java.util.ArrayList;
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
      buff.add(nums[i]);
      solve(nums, i, buff, currentSum + nums[i], target, res);
      buff.remove(buff.size() - 1);
    }
  }

  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> buff = new ArrayList<>();
    solve(candidates, 0, new ArrayList<>(), 0, target, buff);
    return buff;
  }
}

public class _39_Combination_Sum {

  public static void main(String[] args) {
    System.out.println(
      new Solution().combinationSum(new int[] { 2, 3, 6, 7 }, 7)
    );
  }
}
