import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

class Solution {

  class NodePayload {

    private int node;
    private int level;

    public NodePayload(int node, int level) {
      this.node = node;
      this.level = level;
    }
  }

  private int getHeight(int root, Map<Integer, List<Integer>> graph) {
    Queue<NodePayload> bfsQ = new ArrayDeque<>();
    Set<Integer> visited = new HashSet<>();
    int H = 0;
    int height = 0;
    bfsQ.offer(new NodePayload(root, height));
    visited.add(root);
    while (!bfsQ.isEmpty()) {
      NodePayload currentNode = bfsQ.poll();
      for (int neighbor : graph.get(currentNode.node)) {
        if (!visited.contains(neighbor)) {
          bfsQ.offer(new NodePayload(neighbor, currentNode.level + 1));
          H = Math.max(H, currentNode.level + 1);
          visited.add(neighbor);
        }
      }
    }
    return H + 1;
  }

  public List<Integer> findMinHeightTrees(int n, int[][] edges) {
    Map<Integer, List<Integer>> graph = new HashMap<>();
    for (int i = 0; i < n; i++) graph.put(i, new ArrayList<>());
    for (int[] edge : edges) {
      graph.get(edge[0]).add(edge[1]);
      graph.get(edge[1]).add(edge[0]);
    }
    int min = Integer.MAX_VALUE;
    Map<Integer, List<Integer>> heights = new LinkedHashMap<>();
    for (int i = 0; i < n; i++) {
      int height = getHeight(i, graph);
      if (!heights.containsKey(height)) heights.put(height, new ArrayList<>());
      heights.get(height).add(i);
      min = Math.min(min, height);
    }
    return heights.get(min);
  }
}

public class _310_Minimum_Height_Trees {

  public static void main(String[] args) {
    System.out.println(
      new Solution()
        .findMinHeightTrees(
          6,
          new int[][] { { 3, 0 }, { 3, 1 }, { 3, 2 }, { 3, 4 }, { 5, 4 } }
        )
    );
  }
}
