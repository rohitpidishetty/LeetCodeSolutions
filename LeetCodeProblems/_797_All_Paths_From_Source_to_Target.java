import java.util.ArrayList;
import java.util.List;

class Solution {

  private void dfs(
    int s,
    int d,
    int[][] graph,
    ArrayList<Integer> path,
    List<List<Integer>> routes
  ) {
    if (s == d) {
      List<Integer> _path_ = new ArrayList<>(path);
      _path_.add(d);
      routes.add(_path_);
      return;
    }
    path.add(s);
    for (int n : graph[s]) dfs(n, d, graph, path, routes);
    path.remove(path.size() - 1);
  }

  public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
    int source = 0,
      dest = graph.length - 1;
    List<List<Integer>> routes = new ArrayList<>();
    dfs(source, dest, graph, new ArrayList<>(), routes);
    return routes;
  }
}

public class _797_All_Paths_From_Source_to_Target {

  public static void main(String[] args) {
    System.out.println(
      new Solution().allPathsSourceTarget(
        new int[][] { { 4, 3, 1 }, { 3, 2, 4 }, { 3 }, { 4 }, {} }
      )
    );
  }
}
