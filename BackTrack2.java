import java.util.ArrayList;
import java.util.List;

class Solution {
  private static void rec(int i, int[] nums, ArrayList<Integer> sl, List<List<Integer>> l) {
    if (i >= nums.length) {
      l.add(new ArrayList<>(sl));
      return;
    }

    sl.add(nums[i]);
    rec(i + 1, nums, sl, l);
    sl.removeLast();
    rec(i + 1, nums, sl, l);
  }

  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> l = new ArrayList<>();
    rec(0, nums, new ArrayList<>(), l);
    return l;
  }
}

public class BackTrack2 {
  public static void main(String[] args) {
    System.out.println(new Solution().subsets(new int[] { 1, 2, 3 }));
  }
}
