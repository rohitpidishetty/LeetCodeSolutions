import java.util.Stack;

class Solution {

  public int calPoints(String[] operations) {
    Stack<Integer> stack = new Stack<>();
    for (String op : operations) {
      if (op.equals("D")) stack.push(stack.peek() * 2);
      else if (op.equals("C")) stack.pop();
      else if (op.equals("+")) {
        int s1 = stack.pop();
        int s2 = stack.pop();
        stack.push(s2);
        stack.push(s1);
        stack.push(s2 + s1);
      } else stack.push(Integer.parseInt(op));
    }
    int ans = 0;
    while (!stack.isEmpty()) ans += stack.pop();

    return ans;
  }
}

public class _682_Baseball_Game {

  public static void main(String[] args) {
    System.out.println(
      new Solution()
        .calPoints(new String[] { "5", "-2", "4", "C", "D", "9", "+", "+" })
    );
  }
}
