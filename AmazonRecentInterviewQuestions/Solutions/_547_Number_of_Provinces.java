import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class Solution {

  public int findCircleNum(int[][] isConnected) {
    List<List<Integer>> graph = new ArrayList<>();
    int n = isConnected.length;
    int m = isConnected[0].length;
    for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (isConnected[i][j] == 1 && i != j) {
          graph.get(i).add(j);
          graph.get(j).add(i);
        }
      }
    }
    boolean[] visited = new boolean[n];
    Queue<Integer> q = new ArrayDeque<>();
    int total = 0;
    for (int i = 0; i < n; i++) {
      if (visited[i]) continue;
      q.offer(i);
      visited[i] = true;
      while (!q.isEmpty()) {
        List<Integer> neighbors = graph.get(q.poll());
        if (neighbors == null) continue;
        for (int neighbor : neighbors) {
          if (!visited[neighbor]) {
            q.offer(neighbor);
            visited[neighbor] = true;
          }
        }
      }
      total++;
    }
    return total;
  }
}

public class _547_Number_of_Provinces {

  public static void main(String[] args) {
    System.out.println(
      new Solution().findCircleNum(
        new int[][] { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } }
      )
    );
  }
}
