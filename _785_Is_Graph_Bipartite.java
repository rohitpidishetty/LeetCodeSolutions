import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

class Solution {

  public boolean isBipartite(int[][] graph) {
    int n = graph.length;
    int[] root = new int[n];
    boolean[] visited = new boolean[n];

    Arrays.fill(root, -1);

    Queue<int[]> q = new ArrayDeque<>();

    for (int start = 0; start < n; start++) {
      if (root[start] != -1) continue;
      // {introducer, node}
      root[start] = 0;

      q.offer(new int[] { 0, start });
      while (!q.isEmpty()) {
        int[] data = q.poll();
        int introducer = data[0];
        int node = data[1];
        if (root[node] != introducer) return false;

        for (int neighbor : graph[node]) {
          if (root[neighbor] == -1) {
            root[neighbor] = 1 - introducer;
            q.offer(new int[] { root[neighbor], neighbor });
          } else if (root[neighbor] == introducer) return false;
        }
      }
    }
    return true;
  }
}

public class _785_Is_Graph_Bipartite {

  public static void main(String[] args) {
    System.out.println(
      new Solution()
        .isBipartite(
          new int[][] { { 1, 2, 3 }, { 0, 2 }, { 0, 1, 3 }, { 0, 2 } }
        )
    );

    System.out.println(
      new Solution()
        .isBipartite(new int[][] { { 1, 3 }, { 0, 2 }, { 1, 3 }, { 0, 2 } })
    );

    System.out.println(
      new Solution()
        .isBipartite(new int[][] { { 4 }, {}, { 4 }, { 4 }, { 0, 2, 3 } })
    );

    System.out.println(
      new Solution()
        .isBipartite(
          new int[][] {
            {},
            { 2, 4, 6 },
            { 1, 4, 8, 9 },
            { 7, 8 },
            { 1, 2, 8, 9 },
            { 6, 9 },
            { 1, 5, 7, 8, 9 },
            { 3, 6, 9 },
            { 2, 3, 4, 6, 9 },
            { 2, 4, 5, 6, 7, 8 },
          }
        )
    );
  }
}
