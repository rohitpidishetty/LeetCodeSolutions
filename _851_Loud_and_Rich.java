import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

  private int[] ans;

  private Map<Integer, List<Integer>> buildGraph(
    int[][] arr,
    int n,
    int[] quietness
  ) {
    Map<Integer, List<Integer>> connections = new HashMap<>();
    for (int i = 0; i < n; i++) connections.put(i, new ArrayList<>());
    for (int[] ar : arr) connections.get(ar[1]).add(ar[0]);
    // DAG
    return connections;
  }

  private int dfs(int source, Map<Integer, List<Integer>> graph, int[] quiet) {
    if (this.ans[source] != Integer.MAX_VALUE) return this.ans[source];
    List<Integer> children = graph.get(source);
    if (children.size() == 0) {
      this.ans[source] = source;
      return source;
    }

    // Get children of current source node
    int best = source;
    for (Integer nm : children) {
      int current = dfs(nm, graph, quiet);
      if (quiet[current] < quiet[best]) best = current;
    }

    this.ans[source] = best;

    return best;
  }

  public int[] loudAndRich(int[][] richer, int[] quiet) {
    int n = quiet.length;
    Map<Integer, List<Integer>> graph = buildGraph(richer, n, quiet);
    this.ans = new int[n];
    Arrays.fill(this.ans, Integer.MAX_VALUE);
    for (int i = 0; i < n; i++) {
      dfs(i, graph, quiet);
    }

    return this.ans;
  }
}

public class _851_Loud_and_Rich {

  public static void main(String[] args) {
    System.out.println(
      Arrays.toString(
        new Solution().loudAndRich(
          new int[][] {
            { 1, 0 },
            { 2, 1 },
            { 3, 1 },
            { 3, 7 },
            { 4, 3 },
            { 5, 3 },
            { 6, 3 },
          },
          new int[] { 3, 2, 5, 4, 6, 1, 7, 0 }
        )
      )
    );
  }
}
