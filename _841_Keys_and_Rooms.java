import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

class Solution {

  public boolean canVisitAllRooms(List<List<Integer>> rooms) {
    int n = rooms.size();
    boolean[] visited = new boolean[n];
    Queue<Integer> bfsQ = new ArrayDeque<>();
    bfsQ.offer(0);
    int visit = n - 1;
    visited[0] = true;
    while (!bfsQ.isEmpty()) {
      int current = bfsQ.poll();
      List<Integer> neighbors = rooms.get(current);
      if (neighbors == null) continue;
      for (int neighbor : neighbors) {
        if (!visited[neighbor]) {
          bfsQ.offer(neighbor);
          visit--;
          visited[neighbor] = true;
        }
      }
    }

    return visit == 0;
  }
}

public class _841_Keys_and_Rooms {

  public static void main(String[] args) {
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
  }
}
