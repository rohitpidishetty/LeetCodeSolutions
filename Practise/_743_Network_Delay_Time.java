import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {

  class Neighbor {

    protected int neighbor;
    protected int weight;

    Neighbor(int neighbor, int weight) {
      this.neighbor = neighbor;
      this.weight = weight;
    }

    @Override
    public String toString() {
      return "{" + this.neighbor + ":" + this.weight + "}";
    }
  }

  public int networkDelayTime(int[][] times, int n, int k) {
    int[] nodes = new int[n + 1];

    Map<Integer, List<Neighbor>> graph = new HashMap<>();
    for (int i = 1; i <= n; i++) graph.put(i, new ArrayList<>());
    for (int[] time : times) {
      graph.get(time[0]).add(new Neighbor(time[1], time[2]));
    }
    // BFS

    Arrays.fill(nodes, Integer.MAX_VALUE);
    PriorityQueue<Neighbor> bfsQ = new PriorityQueue<>((a, b) ->
      Integer.compare(a.weight, b.weight)
    );
    nodes[k] = 0;
    bfsQ.offer(new Neighbor(k, 0));
    while (!bfsQ.isEmpty()) {
      Neighbor currNode = bfsQ.poll();
      int node = currNode.neighbor, weight = currNode.weight;
      if (weight > nodes[node]) continue;

      for (Neighbor neighbor : graph.get(node)) {
        int d = weight + neighbor.weight;
        if (d < nodes[neighbor.neighbor]) {
          nodes[neighbor.neighbor] = d;
          bfsQ.offer(new Neighbor(neighbor.neighbor, d));
        }
      }
    }
    int max = 0;
    for (int i = 1; i < nodes.length; i++) {
      if (nodes[i] == Integer.MAX_VALUE) return -1;
      max = Math.max(max, nodes[i]);
    }

    return max;
  }
}

public class _743_Network_Delay_Time {

  public static void main(String[] args) {
    System.out.println(
      new Solution().networkDelayTime(new int[][] { { 1, 2, 1 } }, 2, 2)
    );
  }
}
