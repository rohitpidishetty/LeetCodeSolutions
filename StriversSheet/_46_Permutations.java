import java.util.ArrayList;
import java.util.List;

class Solution {

  private void solve(
    int[] nums,
    boolean[] visited,
    ArrayList<Integer> buffer,
    int size,
    List<List<Integer>> res
  ) {
    if (size == nums.length) {
      res.add(new ArrayList<>(buffer));
      return;
    }
    for (int i = 0; i < nums.length; i++) {
      if (visited[i]) continue;
      buffer.add(nums[i]);
      visited[i] = true;
      solve(nums, visited, buffer, size + 1, res);
      buffer.remove(buffer.size() - 1);
      visited[i] = false;
    }
  }

  public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    solve(nums, new boolean[nums.length], new ArrayList<>(), 0, res);
    return res;
  }
}

public class _46_Permutations {

  public static void main(String[] args) {
    System.out.println(new Solution().permute(new int[] { 1, 2, 3 }));
  }
}
