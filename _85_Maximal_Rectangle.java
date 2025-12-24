import java.util.Arrays;
import java.util.Stack;

class Solution {
  private static int largestRectangleArea(int[] heights) {
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

  public int maximalRectangle(char[][] matrix) {
    int[][] mat = new int[matrix.length][matrix[0].length];
    for (int i = 0; i < mat.length; i++)
      for (int j = 0; j < mat[i].length; j++)
        mat[i][j] = (i == 0) ? matrix[i][j] - '0' : (matrix[i][j] == '0') ? 0 : ((matrix[i][j] - '0') + mat[i - 1][j]);
    int max = Integer.MIN_VALUE;
    for (int[] heights : mat)
      max = Math.max(Solution.largestRectangleArea(heights), max);
    return max;
  }
}

public class _85_Maximal_Rectangle {
  public static void main(String[] args) {
    System.out.println(new Solution().maximalRectangle(new char[][] {
        { '1', '0', '1', '0', '0' },
        { '1', '0', '1', '1', '1' },
        { '1', '1', '1', '1', '1' },
        { '1', '0', '0', '1', '0' }
    }));
  }
}