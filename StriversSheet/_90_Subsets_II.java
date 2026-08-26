import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {

  private Set<List<Integer>> result;

  private void solve(int[] nums, int start, ArrayList<Integer> buff) {
    result.add(new ArrayList<>(buff));

    for (int i = start; i < nums.length; i++) {
      if (i > start && nums[i] == nums[i - 1]) continue;
      buff.add(nums[i]);
      solve(nums, i + 1, buff);
      buff.remove(buff.size() - 1);
    }
  }

  public List<List<Integer>> subsetsWithDup(int[] nums) {
    result = new HashSet<>();
    Arrays.sort(nums);
    solve(nums, 0, new ArrayList<>());
    return new ArrayList<>(result);
  }
}

public class _90_Subsets_II {

  public static void main(String[] args) {
    System.out.println(
      new Solution().subsetsWithDup(new int[] { 4, 4, 4, 1, 4 })
    );
  }
}
