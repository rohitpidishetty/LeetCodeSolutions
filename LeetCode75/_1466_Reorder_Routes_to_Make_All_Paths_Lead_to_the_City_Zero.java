import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

class Solution {

  public int minReorder(int n, int[][] connections) {
    Map<Integer, List<Integer>> graph = new HashMap<>();
    for (int i = 0; i < n; i++) graph.put(i, new ArrayList<>());

    Set<String> connected = new HashSet<>();
    for (int connection[] : connections) {
      int u = connection[0];
      int v = connection[1];
      connected.add(u + "-" + v); // original connection
      graph.get(u).add(v);
      graph.get(v).add(u);
    }
    boolean[] visited = new boolean[n];
    Queue<Integer> q = new ArrayDeque<>();
    q.offer(0);
    int count = 0;
    visited[0] = true;
    while (!q.isEmpty()) {
      int curr = q.poll();
      List<Integer> neighbors = graph.get(curr);
      if (neighbors == null) continue;
      for (int neighbor : neighbors) {
        if (visited[neighbor]) continue;
        visited[neighbor] = true;
        q.offer(neighbor);
        if (connected.contains(curr + "-" + neighbor)) count++;
      }
    }
    return count;
  }
}

public class _1466_Reorder_Routes_to_Make_All_Paths_Lead_to_the_City_Zero {

  public static void main(String[] args) {
    System.out.println(
      new Solution().minReorder(
        6,
        new int[][] { { 0, 1 }, { 1, 3 }, { 2, 3 }, { 4, 0 }, { 4, 5 } }
      )
    );
  }
}
