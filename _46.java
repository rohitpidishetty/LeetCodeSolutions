import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {

  private void solve(
    int start,
    int[] nums,
    Set<Integer> s,
    List<Integer> buffer,
    List<List<Integer>> bucket
  ) {
    if (start > nums.length) return;
    if (buffer.size() == nums.length) bucket.add(new ArrayList<>(buffer));

    for (int i = 0; i < nums.length; i++) {
      int number = nums[i];
      if (s.contains(number)) continue;
      s.add(number);
      buffer.add(number);
      solve(i + 1, nums, s, buffer, bucket);
      s.remove(number);
      buffer.remove(buffer.size() - 1);
    }
  }

  public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    solve(0, nums, new HashSet<>(), new ArrayList<>(), res);
    return res;
  }
}

public class _46 {

  public static void main(String[] args) {
    System.out.println(new Solution().permute(new int[] { 1, 2, 3 }));
  }
}
