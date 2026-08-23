import java.util.Arrays;
import java.util.Stack;

class Solution {
  public int largestRectangleArea(int[] heights) {
    int[] leftLimits = new int[heights.length];
    Stack<Integer> lls = new Stack<>();

    for (int i = 0; i < heights.length; i++) {
      int current = heights[i];
      while (!lls.isEmpty() && heights[lls.peek()] >= current)
        lls.pop();
      int limit = (lls.isEmpty() ? -1 : lls.peek()) + 1;
      leftLimits[i] = limit;
      lls.push(i);
    }

    int[] rightLimits = new int[heights.length];
    Stack<Integer> rls = new Stack<>();

    for (int i = heights.length - 1; i > -1; i--) {
      int current = heights[i];
      while (!rls.isEmpty() && heights[rls.peek()] >= current)
        rls.pop();
      int limit = (rls.isEmpty() ? heights.length : rls.peek()) - 1;
      rightLimits[i] = limit;
      rls.push(i);
    }
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < heights.length; i++)
      max = Math.max(
          heights[i] * (rightLimits[i] - leftLimits[i] + 1),
          max);
    return max;
  }
}

public class _84_Largest_Rectangle_in_Histogram {
  public static void main(String[] args) {
    System.out.println(new Solution().largestRectangleArea(new int[] { 2, 1, 5, 6, 2, 3 }));
  }
}
