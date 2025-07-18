import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

  private List<List<Integer>> collection;

  private void solve(
    int i,
    int[] candidates,
    int target,
    int summation,
    ArrayList<Integer> buffer
  ) {
    if (summation == target) collection.add(new ArrayList<>(buffer));

    if (summation > target) return;
    for (int n = i; n < candidates.length; n++) {
      // Skip duplicates
      if (n > i && candidates[n] == candidates[n - 1]) continue;
      buffer.add(candidates[n]);
      solve(n + 1, candidates, target, summation + candidates[n], buffer);
      buffer.remove(buffer.size() - 1);
    }
  }

  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    collection = new ArrayList<>();
    Arrays.sort(candidates);
    solve(0, candidates, target, 0, new ArrayList<>());
    return collection;
  }
}

public class _40 {

  public static void main(String[] args) {
    System.out.println(
      new Solution().combinationSum2(new int[] { 10, 1, 2, 7, 6, 1, 5 }, 8)
    );
  }
}
