import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {

  // public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
  //   PriorityQueue<int[]> pQ = new PriorityQueue<>((a, b) ->
  //     Integer.compare(b[0], a[0])
  //   );
  //   for (int i = 0; i < difficulty.length; i++) {
  //     pQ.add(new int[] { profit[i], difficulty[i] });
  //   }
  //   int maxProfit = 0;
  //   for (int w : worker) {
  //     Queue<int[]> temp = new ArrayDeque<>();
  //     while (!pQ.isEmpty() && pQ.peek()[1] > w) temp.add(pQ.poll());
  //     if (!pQ.isEmpty()) maxProfit += (pQ.peek()[0]);
  //     while (!temp.isEmpty()) pQ.add(temp.poll());
  //   }
  //   return maxProfit;
  // }

  public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
    int[][] jobs = new int[difficulty.length][2];
    for (int i = 0; i < difficulty.length; i++) {
      jobs[i] = (new int[] { difficulty[i], profit[i] });
    }
    Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
    System.out.println(Arrays.deepToString(jobs));
    Arrays.sort(worker);
    int maxProfit = 0;
    int best = 0;
    int j = 0;
    for (int w : worker) {
      while (j < difficulty.length && jobs[j][0] <= w) {
        best = Math.max(best, jobs[j][1]);
        j++;
      }
      maxProfit += best;
    }
    return maxProfit;
  }
}

public class _826_Most_Profit_Assigning_Work {

  public static void main(String[] args) {
    System.out.println(
      new Solution().maxProfitAssignment(
        new int[] { 2, 4, 6, 8, 10 },
        new int[] { 10, 20, 30, 40, 50 },
        new int[] { 4, 5, 6, 7 }
      )
    );
  }
}
