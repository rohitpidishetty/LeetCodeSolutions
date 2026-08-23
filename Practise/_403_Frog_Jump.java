import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {

  private Map<Integer, Integer> positionalMap;
  private Set<String> visited;

  private boolean solve(int ci, int cs, int final_Idx, int lj) {
    String path = ci + "" + cs + "" + lj;
    if (visited.contains(path)) return false;
    if (ci == final_Idx) {
      return true;
    }
    for (int i = lj - 1; i <= lj + 1; i++) {
      if (i > 0) {
        int ns = (cs + i); // Next stone
        if ((ns > cs) && positionalMap.containsKey(ns)) {
          if (solve(positionalMap.get(ns), ns, final_Idx, i)) return true;
        }
      }
    }
    visited.add(path);
    return false;
  }

  public boolean canCross(int[] stones) {
    positionalMap = new HashMap<>();
    visited = new HashSet<>();
    for (int i = 0; i < stones.length; i++) positionalMap.put(stones[i], i);

    if (stones.length > 1 && stones[1] != 1) return false;
    int current_index = 1, current_stone = 1;
    int i = 1;
    return solve(current_index, current_stone, stones.length - 1, i);
  }
}

public class _403_Frog_Jump {

  public static void main(String[] args) {
    System.out.println(
      new Solution().canCross(new int[] { 0, 1, 2, 3, 4, 5, 6, 12 })
    );
  }
}
