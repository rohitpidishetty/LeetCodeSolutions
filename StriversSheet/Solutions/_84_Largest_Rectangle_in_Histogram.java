import java.util.Arrays;
import java.util.Stack;

class Solution {

  public int largestRectangleArea(int[] heights) {
    int n = heights.length;
    int leftLimits[] = new int[n];
    int rightLimits[] = new int[n];
    Stack<Integer> mStack = new Stack<>();
    for (int i = 0; i < n; i++) {
      while (!mStack.isEmpty() && heights[i] <= heights[mStack.peek()]) {
        mStack.pop();
      }
      leftLimits[i] = mStack.isEmpty() ? -1 : mStack.peek();
      mStack.push(i);
    }
    mStack.clear();
    for (int i = n - 1; i > -1; i--) {
      while (!mStack.isEmpty() && heights[i] <= heights[mStack.peek()]) {
        mStack.pop();
      }
      rightLimits[i] = mStack.isEmpty() ? n : mStack.peek();
      mStack.push(i);
    }
    mStack.clear();

    int max = Integer.MIN_VALUE;
    for (int i = 0; i < n; i++) {
      max = Math.max(max, ((rightLimits[i] - leftLimits[i] - 1) * heights[i]));
    }
    return max;
  }
}

public class _84_Largest_Rectangle_in_Histogram {

  public static void main(String[] args) {
    System.out.println(
      new Solution().largestRectangleArea(new int[] { 2, 1, 5, 6, 2, 3 })
    );
  }
}
