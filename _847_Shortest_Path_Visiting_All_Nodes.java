import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

class Solution {

  public int shortestPathLength(int[][] graph) {
    int n = graph.length;
    if (n == 0 || graph[0].length == 0) return 0;
    Set<String> visited = new HashSet<>();
    Queue<int[]> bfsQ = new ArrayDeque<>();
    for (int i = 0; i < n; i++) {
      int b = (1 << i);
      bfsQ.add(new int[] { i, b });
      visited.add(i + "b" + b);
    }
    int goalState = (1 << n) - 1; // Math.pow(2, number of nodes in graph);
    int depth = 0;
    while (!bfsQ.isEmpty()) {
      n = bfsQ.size();
      depth++;
      for (int i = 0; i < n; i++) {
        int[] curr = bfsQ.poll();
        int currNode = curr[0];
        int currMask = curr[1];
        // Neighbors
        for (int neighbor : graph[currNode]) {
          int nextMask = currMask | (1 << neighbor);
          if (nextMask == goalState) return depth;
          String state = neighbor + "b" + nextMask;
          if (visited.contains(state)) continue;
          visited.add(state);
          bfsQ.add(new int[] { neighbor, nextMask });
        }
      }
    }
    return -1;
  }
}

public class _847_Shortest_Path_Visiting_All_Nodes {

  public static void main(String[] args) {
    System.out.println(
      new Solution().shortestPathLength(
        new int[][] { { 1 }, { 0, 2, 4 }, { 1, 3, 4 }, { 2 }, { 1, 2 } }
      )
    );
  }
}
