import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

class Solution {

  public boolean canVisitAllRooms(List<List<Integer>> rooms) {
    int n = rooms.size();
    boolean[] visited = new boolean[n];
    int[] parents = new int[n];

    for (int i = 0; i < n; i++) parents[i] = i;

    Queue<Integer> q = new ArrayDeque<>();
    q.offer(0);
    visited[0] = true;
    int processed = 0;
    while (!q.isEmpty()) {
      int curr = q.poll();
      processed++;
      List<Integer> neighbors = rooms.get(curr);
      if (neighbors == null || neighbors.size() == 0) continue;
      for (int neighbor : neighbors) {
        if (neighbor == curr || visited[neighbor]) continue;
        visited[neighbor] = true;
        parents[neighbor] = parents[curr];
        q.offer(neighbor);
      }
    }

    return processed == n;
  }
}

public class _841_Keys_and_Rooms {

  public static void main(String[] args) {
    System.out.println(
      new Solution().canVisitAllRooms(
        Arrays.asList(
          Arrays.asList(1, 3),
          Arrays.asList(3, 0, 1),
          Arrays.asList(2),
          Arrays.asList(0)
        )
      )
    );
    System.out.println(
      new Solution().canVisitAllRooms(
        Arrays.asList(
          Arrays.asList(1),
          Arrays.asList(2),
          Arrays.asList(3),
          null
        )
      )
    );
  }
}
