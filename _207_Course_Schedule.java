import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

class Solution {

  private boolean dfs(
    int start,
    Map<Integer, List<Integer>> graph,
    Set<Integer> introducer
  ) {
    if (introducer.contains(start)) return true;
    introducer.add(start);
    if (graph.get(start).isEmpty()) return false;
    for (int neighbor : graph.get(start)) {
      if (dfs(neighbor, graph, introducer)) return true;
    }
    introducer.remove(start);
    return false;
  }

  public boolean canFinish(int numCourses, int[][] prerequisites) {
    Map<Integer, List<Integer>> graph = new HashMap<>();
    // Initializing nodes
    for (int i = 0; i < numCourses; i++) graph.put(i, new ArrayList<>());

    // Connecting nodes with edges
    for (int[] edge : prerequisites) {
      int from = edge[1];
      int to = edge[0];
      graph.get(from).add(to);
    }
    // System.out.println(graph);

    for (int i = 0; i < numCourses; i++) if (
      dfs(i, graph, new HashSet<>())
    ) return true;

    return false;
  }
}

public class _207_Course_Schedule {

  public static void main(String[] args) {
    System.out.println(
      new Solution()
        .canFinish(
          4,
          new int[][] { { 1, 0 }, { 2, 1 }, { 2, 0 }, { 0, 2 }, { 3, 2 } }
        )
    );
    // System.out.println(
    //   new Solution().canFinish(2, new int[][] { { 1, 0 }, { 0, 1 } })
    // );
  }
}
