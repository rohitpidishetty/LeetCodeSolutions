import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
  private void rec(int[] nums, int idx, ArrayList<Integer> subList, List<List<Integer>> ll) {
    // System.out.println(subList);
    ll.add(new ArrayList<>(subList));
    if (subList.size() > nums.length - 1)
      return;
    for (int i = idx; i < nums.length; i++) {
      if (i != idx && nums[i] == nums[i - 1])
        continue;
      subList.add(nums[i]);
      rec(nums, i + 1, subList, ll);
      subList.removeLast();
    }
  }

  public List<List<Integer>> subsetsWithDup(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> ll = new ArrayList<>();
    rec(nums, 0, new ArrayList<>(), ll);
    return ll;
  }
}

public class _90_Subsets_2 {
  public static void main(String[] args) {
    System.out.println(new Solution().subsetsWithDup(new int[] { 1, 2, 2 }));
  }
}
