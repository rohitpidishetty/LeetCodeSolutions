import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

class Solution {

  public int numBusesToDestination(int[][] routes, int source, int target) {
    if (source == target) return 0;
    Map<Integer, ArrayList<Integer>> directed_graph = new HashMap<>();

    for (int i = 0; i < routes.length; i++) {
      for (int stop : routes[i])
        directed_graph.computeIfAbsent(stop, e -> new ArrayList<>()).add(i);
    }

    // BFS
    boolean[] visited = new boolean[routes.length];
    Queue<Integer> bfsQ = new ArrayDeque<>();

    if (!directed_graph.containsKey(source)) return -1;
    for (int idx : directed_graph.get(source)) {
      bfsQ.add(idx);
      visited[idx] = true;
    }
    int busCount = 1;
    while (!bfsQ.isEmpty()) {
      int n = bfsQ.size();
      while (n > 0) {
        int bus = bfsQ.poll();
        for (int buses : routes[bus]) {
          if (buses == target) return busCount;
          for (int next : directed_graph.get(buses)) {
            if (!visited[next]) {
              bfsQ.add(next);
              visited[next] = true;
            }
          }
        }
        n--;
      }
      busCount++;
    }

    return -1;
  }
}

public class _815_Bus_Routes {

  public static void main(String[] args) {
    System.out.println(
      new Solution().numBusesToDestination(
        new int[][] { { 1, 2, 7 }, { 3, 6, 7 } },
        8,
        6
      )
    );
  }
}
