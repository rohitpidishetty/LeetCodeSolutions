import java.util.HashSet;
import java.util.Set;

class Solution {
  private boolean travel(int index, int[] g, int[] c) {
    int start = index;
    int cg = g[start];
    Set<Integer> visitedIndex = new HashSet<>();
    while (true) {
      int idx = start % g.length;
      int next = g[(start + 1) % g.length];
      cg = cg - c[idx] + next;
      if (cg < 0 || cg < next)
        return false;
      if (visitedIndex.contains(idx))
        return true;
      visitedIndex.add(idx);
      start++;
    }
  }

  public int canCompleteCircuit(int[] gas, int[] cost) {
    int i = 0;
    while (i < gas.length) {
      if (cost[i] <= gas[i] && travel(i, gas, cost))
        return i;
      i++;
    }
    return -1;
  }
}

class Solution_OPTIMIZED {
  public int canCompleteCircuit(int[] gas, int[] cost) {
    int total = 0, curr = 0, start = 0;

    for (int i = 0; i < gas.length; i++) {
      int diff = gas[i] - cost[i];
      total += diff;
      curr += diff;

      if (curr < 0) {
        start = i + 1;
        curr = 0;
      }
    }

    return total >= 0 ? start : -1;
  }
}

public class _134_Gas_Station {
  public static void main(String[] args) {
    System.out.println(new Solution().canCompleteCircuit(new int[] { 2, 3, 4 }, new int[] { 3, 4, 3 }));
  }
}
