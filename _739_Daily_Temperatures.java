import java.util.Arrays;
import java.util.Stack;

class Solution {

  public int[] dailyTemperatures(int[] temperatures) {
    Stack<Integer> s = new Stack<>();
    int n = temperatures.length - 1;
    int[] ans = new int[n + 1];
    s.push(n);
    ans[n] = 0;
    for (int i = n - 1; i >= 0; i--) {
      while (!s.isEmpty() && temperatures[s.peek()] <= temperatures[i]) s.pop();
      ans[i] = s.size() == 0 ? 0 : (s.peek() - i);
      s.push(i);
    }
    return ans;
  }
}

public class _739_Daily_Temperatures {

  public static void main(String[] args) {
    System.out.println(
      Arrays.toString(
        new Solution()
          .dailyTemperatures(new int[] { 73, 74, 75, 71, 69, 72, 76, 73 })
      )
    );
  }
}
