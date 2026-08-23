import java.util.ArrayList;
import java.util.List;

class Solution {

  private boolean dfs(int i, int[][] graph, int[] state) {
    if (state[i] == 1) return false;
    if (state[i] == 2) return true;
    state[i] = 1; // Marking visited
    for (int n : graph[i]) if (!dfs(n, graph, state)) return false;
    state[i] = 2; // Marking safe
    return true;
  }

  public List<Integer> eventualSafeNodes(int[][] graph) {
    int[] state = new int[graph.length];
    List<Integer> safeNodes = new ArrayList<>();
    for (int i = 0; i < state.length; i++) {
      if (dfs(i, graph, state)) safeNodes.add(i);
    }
    return safeNodes;
  }
}

public class _802_Find_Eventual_Safe_States {

  public static void main(String[] args) {
    System.out.println(
      new Solution().eventualSafeNodes(
        new int[][] { { 1, 2 }, { 2, 3 }, { 5 }, { 0 }, { 5 }, {}, {} }
      )
    );
  }
}
