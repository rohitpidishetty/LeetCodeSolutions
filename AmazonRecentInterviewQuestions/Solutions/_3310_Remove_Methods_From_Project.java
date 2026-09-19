import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class Solution {

  private int[] inDeg;

  public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
    inDeg = new int[n];
    Map<Integer, List<Integer>> graph = new HashMap<>();
    for (int i = 0; i < n; i++) graph.put(i, new ArrayList<>());
    for (int[] edge : invocations) {
      graph.get(edge[0]).add(edge[1]);
      inDeg[edge[1]]++;
    }

    boolean[] processed = new boolean[n];
    Queue<Integer> q = new ArrayDeque<>();
    q.offer(k);
    processed[k] = true;

    while (!q.isEmpty()) {
      int curr = q.poll();
      List<Integer> neighbors = graph.get(curr);
      if (neighbors.size() == 0) continue;
      for (int neighbor : neighbors) {
        inDeg[neighbor]--;
        if (!processed[neighbor]) {
          q.offer(neighbor);
          processed[neighbor] = true;
        }
      }
    }

    List<Integer> res = new ArrayList<>();

    boolean breakable = true;
    for (int i = 0; i < n; i++) {
      if (!processed[i]) res.add(i);

      if (processed[i] && inDeg[i] > 0) {
        breakable = false;
        break;
      }
    }

    if (breakable) return res;

    res.clear();
    for (int i = 0; i < n; i++) res.add(i);

    return res;
  }
}

public class _3310_Remove_Methods_From_Project {

  public static void main(String[] args) {
    System.out.println(
      new Solution().remainingMethods(
        5,
        0,
        new int[][] { { 1, 2 }, { 0, 2 }, { 0, 1 }, { 3, 4 } }
      )
    );
  }
}
