import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
  public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
    int totalNumberOfProjects = profits.length;
    /**
     * lets see what can we choose for now with the initial capital that we have
     * currently.
     */
    PriorityQueue<int[]> projects = new PriorityQueue<>((a, b) -> a[0] - b[0]);
    for (int i = 0; i < totalNumberOfProjects; i++)
      projects.offer(new int[] { capital[i], profits[i] });

    PriorityQueue<Integer> _profits_ = new PriorityQueue<>(Collections.reverseOrder());
    while (k-- > 0) {
      while (!projects.isEmpty() && projects.peek()[0] <= w)
        _profits_.offer(projects.poll()[1]);
      if (_profits_.isEmpty())
        break;
      w += _profits_.poll();
    }
    return w;
  }
}

public class _502_IPO {
  public static void main(String[] args) {
    System.out.println(new Solution().findMaximizedCapital(3, 0, new int[] { 1, 2, 3 }, new int[] { 0, 1, 2 }));
  }
}
