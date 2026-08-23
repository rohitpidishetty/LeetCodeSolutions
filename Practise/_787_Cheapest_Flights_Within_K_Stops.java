import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Solution {

  private int min = Integer.MAX_VALUE;
  private Map<String, Integer> best = new HashMap<>();

  private void solve(
    Map<Integer, Map<Integer, Integer>> graph,
    int src,
    int dst,
    int k,
    int sum
  ) {
    String key = src + "-" + k;
    if (this.best.containsKey(key) && this.best.get(key) <= sum) return;
    best.put(key, sum);
    if (src == dst) {
      this.min = Math.min(this.min, sum);
      return;
    }
    if (k < 0) return;
    for (Map.Entry<Integer, Integer> map : graph.get(src).entrySet()) {
      int m = map.getValue();
      if (sum + m < this.min) solve(graph, map.getKey(), dst, k - 1, sum + m);
    }
  }

  public int findCheapestPrice(
    int n,
    int[][] flights,
    int src,
    int dst,
    int k
  ) {
    Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
    for (int i = 0; i < n; i++) graph.put(i, new HashMap<>());
    for (int i = 0; i < flights.length; i++) {
      graph.get(flights[i][0]).put(flights[i][1], flights[i][2]);
    }
    int sum = 0;
    solve(graph, src, dst, k, sum);

    return this.min == Integer.MAX_VALUE ? -1 : this.min;
  }
}

public class _787_Cheapest_Flights_Within_K_Stops {

  public static void main(String[] args) {
    System.out.println(
      new Solution()
        .findCheapestPrice(
          4,
          new int[][] {
            { 0, 1, 100 },
            { 1, 2, 100 },
            { 2, 0, 100 },
            { 1, 3, 600 },
            { 2, 3, 200 },
          },
          0,
          3,
          1
        )
    );
  }
}
