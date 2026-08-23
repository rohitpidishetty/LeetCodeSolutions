import java.util.Arrays;
import java.util.Stack;

class Solution {

  public int[][] merge(int[][] intervals) {
    Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
    Stack<int[]> stack = new Stack<>();
    stack.push(intervals[0]);

    for (int i = 1; i < intervals.length; i++) {
      int x = intervals[i][0];
      int y = intervals[i][1];
      int X = -1;

      while (!stack.isEmpty() && x <= stack.peek()[1]) {
        int[] top = stack.pop();
        X = top[0];
        y = Math.max(y, top[1]);
      }

      if (X == -1) stack.push(intervals[i]);
      else stack.push(new int[] { X, y });
    }

    return stack.toArray(new int[stack.size()][]);
  }
}

public class _56_Merge_Intervals {

  public static void main(String[] args) {
    int[][] res1 = new Solution().merge(
      new int[][] { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } }
    );
    System.out.println(Arrays.deepToString(res1));
    int[][] res2 = new Solution().merge(new int[][] { { 1, 4 }, { 4, 5 } });
    System.out.println(Arrays.deepToString(res2));
    int[][] res3 = new Solution().merge(new int[][] { { 1, 4 }, { 2, 3 } });
    System.out.println(Arrays.deepToString(res3));
  }
}
