import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {

  private List<List<Integer>> collection;

  private void solve(
    int i,
    int[] candidates,
    int target,
    int summation,
    ArrayList<Integer> buffer
  ) {
    if (summation == target) 
      collection.add(new ArrayList<>(buffer));
    
    if (summation > target) return;
    for (int n = i; n < candidates.length; n++) {
      buffer.add(candidates[n]);
      solve(n, candidates, target, summation + candidates[n], buffer);
      buffer.remove(buffer.size() - 1);
    }
  }

  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    collection = new ArrayList<>();
    solve(0, candidates, target, 0, new ArrayList<>());
    return collection;
  }
}

public class _39 {

  public static void main(String[] args) {
    System.out.println(new Solution().combinationSum(new int[] { 2, 3, 5 }, 8));
  }
}
