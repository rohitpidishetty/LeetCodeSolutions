import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

  private boolean possible(
    int color,
    int source,
    Map<Integer, List<Integer>> graph,
    byte[] colors
  ) {
    for (int neighbor : graph.get(source))
      if (colors[neighbor] == color) return false;
    return true;
  }

  private boolean solve(
    Map<Integer, List<Integer>> graph,
    int source,
    byte color[],
    int m,
    int n
  ) {
    if (source == n - 1) return true;
    for (int col = 1; col <= m; col++) {
      if (possible(col, source, graph, color)) {
        color[source] = (byte) col;
        if (solve(graph, source + 1, color, m, n)) return true;
        color[source] = 0;
      }
    }
    return false;
  }

  public boolean graphColoring(int[][] edges, int m, int n) {
    Map<Integer, List<Integer>> graph = new HashMap<>();
    byte[] color = new byte[n];
    for (int i = 0; i < n; i++) graph.put(i, new ArrayList<>());
    for (int[] edge : edges) {
      graph.get(edge[0]).add(edge[1]);
      graph.get(edge[1]).add(edge[0]);
    }
    return solve(graph, 0, color, m, n);
  }
}

public class _M_Coloring_Problem {

  public static void main(String[] args) {
    System.out.println(
      new Solution().graphColoring(
        new int[][] { { 0, 1 }, { 1, 2 }, { 2, 3 }, { 3, 0 }, { 0, 2 } },
        3,
        4
      )
    );
  }
}
