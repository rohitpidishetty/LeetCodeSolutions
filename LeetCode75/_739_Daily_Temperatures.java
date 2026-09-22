import java.util.Arrays;
import java.util.Stack;

class Solution {

  public int[] dailyTemperatures(int[] temperatures) {
    int n = temperatures.length;
    int[] result = new int[n];
    Stack<Integer> s = new Stack<>();
    for (int i = n - 1; i > -1; i--) {
      while (!s.isEmpty() && temperatures[s.peek()] <= temperatures[i]) s.pop();
      result[i] = (s.isEmpty()) ? 0 : s.peek() - i;
      s.push(i);
    }
    return result;
  }
}

public class _739_Daily_Temperatures {

  public static void main(String[] args) {
    System.out.println(
      Arrays.toString(
        new Solution().dailyTemperatures(
          new int[] { 73, 74, 75, 71, 69, 72, 76, 73 }
        )
      )
    );
  }
}
