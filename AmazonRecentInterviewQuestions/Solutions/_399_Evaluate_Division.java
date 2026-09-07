import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Solution {

  private class Node {

    protected String id;
    protected double weight;

    public Node(String id, double weight) {
      this.id = id;
      this.weight = weight;
    }

    @Override
    public String toString() {
      return "(" + this.id + ", " + this.weight + ")";
    }
  }

  public double[] calcEquation(
    List<List<String>> equations,
    double[] values,
    List<List<String>> queries
  ) {
    Map<String, List<Node>> graph = new HashMap<>();
    int n = equations.size();
    for (int i = 0; i < n; i++) {
      String s = equations.get(i).get(0);
      String d = equations.get(i).get(1);
      graph
        .computeIfAbsent(s, key -> new ArrayList<>())
        .add(new Node(d, values[i]));
      graph
        .computeIfAbsent(d, key -> new ArrayList<>())
        .add(new Node(s, 1d / values[i]));
    }
    n = queries.size();
    double[] res = new double[n];
    for (int i = 0; i < n; i++) res[i] = solve(queries.get(i), graph);
    return res;
  }

  private double dfs(
    String s,
    String d,
    double result,
    Map<String, List<Node>> graph,
    Set<String> visited
  ) {
    if (!graph.containsKey(s)) return -1.0d;
    if (s.equals(d)) return result;

    for (Node neighbor : graph.get(s)) {
      if (!visited.contains(neighbor.id)) {
        visited.add(neighbor.id);
        double ans = dfs(
          neighbor.id,
          d,
          result * neighbor.weight,
          graph,
          visited
        );

        if (ans != -1.0d) return ans;
      }
    }

    return -1.0d;
  }

  private double solve(List<String> equ, Map<String, List<Node>> graph) {
    double result = 1d;
    Set<String> visited = new HashSet<>();
    String s = equ.get(0);
    visited.add(s);

    return dfs(s, equ.get(1), result, graph, visited);
  }
}

public class _399_Evaluate_Division {

  public static void main(String[] args) {
    System.out.println(
      Arrays.toString(
        new Solution().calcEquation(
          List.of(List.of("a", "b"), List.of("b", "c")),
          new double[] { 2.0, 3.0 },
          List.of(
            List.of("a", "c"),
            List.of("b", "a"),
            List.of("a", "e"),
            List.of("a", "a"),
            List.of("x", "x")
          )
        )
      )
    );
  }
}
