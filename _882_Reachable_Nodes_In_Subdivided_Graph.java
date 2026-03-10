import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {

  public int reachableNodes(int[][] edges, int maxMoves, int n) {
    Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
    int distance[] = new int[n];
    for (int i = 0; i < n; i++) {
      graph.put(i, new HashMap<>());
      distance[i] = Integer.MAX_VALUE;
    }
    distance[0] = 0;
    for (int[] edge : edges) {
      int s = edge[0];
      int d = edge[1];
      int w = edge[2];
      graph.get(s).put(d, w);
      graph.get(d).put(s, w);
    }

    PriorityQueue<int[]> pQ = new PriorityQueue<>((a, b) -> a[1] - b[1]);
    // new int[] {node(x), min distance to reach this node(x)}
    pQ.offer(new int[] { 0, 0 });
    while (!pQ.isEmpty()) {
      int node[] = pQ.poll();
      int s = node[0];
      int currDistance = node[1];

      for (int neighbor : graph.get(s).keySet()) {
        int newDistance = currDistance + graph.get(s).get(neighbor) + 1;
        if (newDistance < distance[neighbor] && newDistance <= maxMoves) {
          distance[neighbor] = newDistance;
          pQ.offer(new int[] { neighbor, newDistance });
        }
      }
    }
    int ans = 0;
    for (int i = 0; i < n; i++) if (distance[i] <= maxMoves) ans++;

    for (int[] edge : edges) {
      int s = edge[0],
        d = edge[1],
        w = edge[2];

      int usedFromS = Math.max(0, Math.min(w, maxMoves - distance[s]));
      int usedFromD = Math.max(0, Math.min(w, maxMoves - distance[d]));

      ans += Math.min(w, usedFromS + usedFromD);
    }

    return ans;
  }
}

public class _882_Reachable_Nodes_In_Subdivided_Graph {

  public static void main(String[] args) {
    System.out.println(
      new Solution().reachableNodes(
        new int[][] { { 0, 1, 10 }, { 0, 2, 1 }, { 1, 2, 2 } },
        6,
        3
      )
    );
  }
}
