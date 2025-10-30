import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

class Solution {
  public int findCircleNum(int[][] isConnected) {

    int n = isConnected.length, m = isConnected[0].length;
    List<List<Integer>> graph = new ArrayList<>();
    int[] union_find_lookup = new int[n];

    for (int i = 0; i < n; i++)
      graph.add(new ArrayList<>());

    for (int i = 0; i < n; i++) {
      union_find_lookup[i] = i;
      for (int j = 0; j < m; j++) {
        if (isConnected[i][j] == 1 && i != j) {

          graph.get(i).add(j);
        }
      }
    }

    boolean[] visited = new boolean[m];

    int count = 0;
    for (int i = 0; i < n; i++) {
      if (!visited[i]) {
        Queue<Integer> bfsQ = new ArrayDeque<>();
        bfsQ.offer(i);
        visited[i] = true;
        count++;
        while (!bfsQ.isEmpty()) {
          int x = bfsQ.poll();
          for (int neighbor : graph.get(x)) {
            if (!visited[neighbor]) {
              visited[neighbor] = true;
              bfsQ.offer(neighbor);
            }
          }
        }
      }
    }
    return count;
  }
}

public class _547_Number_of_Provinces {
  public static void main(String[] args) {
    System.out.println(new Solution()
        .findCircleNum(
            new int[][] {
                { 1, 1, 0 },
                { 1, 1, 0 },
                { 0, 0, 1 }
            }));
  }
}