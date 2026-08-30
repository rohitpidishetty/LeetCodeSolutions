import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {

  public int[] JobScheduling(int[][] Jobs) {
    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) ->
      a[2] == b[2] ? a[1] - b[1] : b[2] - a[2]
    );
    for (int[] job : Jobs) pq.offer(job);
    int time = 0;
    int num = 0;
    int profit = 0;
    while (!pq.isEmpty()) {
      int[] job = pq.poll();
      if (job[1] >= time) {
        time += job[1];
        num++;
        profit += job[2];
      }
    }
    return new int[] { num, profit };
  }
}

public class _Job_sequencing_Problem {

  public static void main(String[] args) {
    System.out.println(
      Arrays.toString(
        new Solution().JobScheduling(
          new int[][] {
            { 1, 2, 100 },
            { 2, 1, 19 },
            { 3, 2, 27 },
            { 4, 1, 25 },
            { 5, 1, 15 },
          }
        )
      )
    );
  }
}
