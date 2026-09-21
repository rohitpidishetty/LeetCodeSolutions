import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {

  public int[] getOrder(int[][] tasks) {
    int n = tasks.length;
    int[][] computableTasks = new int[n][3];
    for (int i = 0; i < n; i++) {
      computableTasks[i] = new int[] { tasks[i][0], tasks[i][1], i };
    }
    Arrays.sort(computableTasks, (a, b) -> a[0] - b[0]);
    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) ->
      a[1] == b[1] ? a[2] - b[2] : a[1] - b[1]
    );
    int[] order = new int[n];
    int index = 0;
    int time = 0;
    int i = 0;

    while (i < n || !pq.isEmpty()) {
      // CPU initially idle.
      if (pq.isEmpty() && time < computableTasks[i][0]) {
        time = computableTasks[i][0];
      }

      while (i < n && computableTasks[i][0] <= time) {
        pq.offer(computableTasks[i]);
        i++;
      }

      int[] task = pq.poll();
      order[index++] = task[2];

      time += task[1];
    }
    return order;
  }
}

public class _1834_Single_Threaded_CPU {

  public static void main(String[] args) {
    System.out.println(
      Arrays.toString(
        new Solution().getOrder(
          new int[][] { { 1, 2 }, { 2, 4 }, { 3, 2 }, { 4, 1 } }
        )
      )
    );
  }
}
