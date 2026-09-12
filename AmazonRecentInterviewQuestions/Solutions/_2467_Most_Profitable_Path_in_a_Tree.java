import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

  public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
    Map<Integer, List<int[]>> graph = new HashMap<>();
    int n = edges.length;
    boolean[] vis = new boolean[n + 1];
    int[] time = new int[n + 1];
    for (int i = 0; i <= n; i++) graph.put(i, new ArrayList<>());
    for (int edge[] : edges) {
      graph.get(edge[0]).add(new int[] { edge[1], amount[edge[1]] });
      graph.get(edge[1]).add(new int[] { edge[0], amount[edge[0]] });
    }
    /**
     * node_a -> [(node_b, cost), (node_c, cost)]
     */
    // bob should reach to 0
    Arrays.fill(time, -1);
    time[bob] = 0;
    vis[bob] = true;
    int level = 0;
    dfs(bob, graph, 0, vis, time, level);
    // Lets make alice travel to the node from where bob started
    Arrays.fill(vis, false);
    vis[0] = true;
    int rootCost = time[0] == 0 ? amount[0] / 2 : amount[0];

    return aliceDfs(0, bob, time, 0, rootCost, graph, vis);
  }

  private int aliceDfs(
    int aliceAt,
    int dest,
    int[] time,
    int level,
    int totalCost,
    Map<Integer, List<int[]>> graph,
    boolean[] vis
  ) {
    List<int[]> children = graph.get(aliceAt);

    int res = Integer.MIN_VALUE;
    boolean isLeaf = true;
    for (int[] child : children) {
      if (vis[child[0]]) continue;
      isLeaf = false;
      vis[child[0]] = true;
      int cost = child[1];
      int newCost;
      int aliceTime = level + 1;
      int bobTime = time[child[0]];
      if (bobTime == aliceTime) newCost = totalCost + cost / 2;
      else if (bobTime == -1 || bobTime > aliceTime) newCost = totalCost + cost;
      else newCost = totalCost;

      res = Math.max(
        res,
        aliceDfs(child[0], dest, time, level + 1, newCost, graph, vis)
      );

      vis[child[0]] = false;
    }
    return isLeaf ? totalCost : res;
  }

  private boolean dfs(
    int bobAt,
    Map<Integer, List<int[]>> graph,
    int totalCost,
    boolean[] vis,
    int[] time,
    int level
  ) {
    if (bobAt == 0) {
      time[bobAt] = level;
      return true;
    }
    List<int[]> children = graph.get(bobAt);
    if (children == null) return false;

    for (int[] child : children) {
      if (vis[child[0]]) continue;

      vis[child[0]] = true;

      if (dfs(child[0], graph, totalCost + child[1], vis, time, level + 1)) {
        time[bobAt] = level;
        return true;
      }
      vis[child[0]] = false;
    }

    return false;
  }
}

public class _2467_Most_Profitable_Path_in_a_Tree {

  public static void main(String[] args) {
    System.out.println(
      new Solution().mostProfitablePath(
        new int[][] { { 0, 1 }, { 1, 2 }, { 1, 3 }, { 3, 4 } },
        3,
        new int[] { -2, 4, 2, -4, 6 }
      )
    );
  }
}
