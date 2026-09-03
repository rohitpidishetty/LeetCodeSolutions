import java.util.ArrayList;
import java.util.List;

class Solution {

  private void solve(
    int idx,
    int[] nums,
    List<Integer> temp,
    List<List<Integer>> buff
  ) {
    if (idx == nums.length) {
      buff.add(new ArrayList<>(temp));
      return;
    }
    // skip
    solve(idx + 1, nums, temp, buff);

    // take

    temp.add(nums[idx]);
    solve(idx + 1, nums, temp, buff);
    temp.remove(temp.size() - 1);
  }

  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> buff = new ArrayList<>();
    solve(0, nums, new ArrayList<>(), buff);
    return buff;
  }
}

public class _78_Subsets {

  public static void main(String[] args) {
    System.out.println(new Solution().subsets(new int[] { 1, 2, 3 }));
  }
}
