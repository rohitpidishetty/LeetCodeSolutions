import java.util.ArrayDeque;
import java.util.Queue;

class Solution {

  public boolean isBipartite(int[][] graph) {
    Queue<Integer> q = new ArrayDeque<>();
    boolean processed[] = new boolean[graph.length];
    byte color[] = new byte[graph.length];

    for (int i = 0; i < graph.length; i++) {
      if (processed[i]) continue;
      color[i] = 1;
      q.offer(i);
      processed[i] = true;

      while (!q.isEmpty()) {
        int curr = q.poll();
        for (int neighbor : graph[curr]) {
          if (!processed[neighbor]) {
            processed[neighbor] = true;
            q.offer(neighbor);
            color[neighbor] = (byte) (1 - color[curr]);
          } else {
            if (color[curr] == color[neighbor]) return false;
          }
        }
      }
    }
    return true;
  }
}

public class _785_Is_Graph_Bipartite {

  public static void main(String[] args) {
    System.out.println(
      new Solution().isBipartite(
        new int[][] { { 1, 2, 3 }, { 0, 2 }, { 0, 1, 3 }, { 0, 2 } }
      )
    );
  }
}
