import java.util.Stack;

class Solution {

  public int longestValidParentheses(String s) {
    int n = s.length();
    Stack<Integer> stack = new Stack<>();

    stack.push(-1);
    int max = 0;
    for (int i = 0; i < n; i++) {
      char curr = s.charAt(i);
      if (curr == '(') stack.push(i);
      else {
        stack.pop();
        if (stack.isEmpty()) stack.push(i);
        else max = Math.max(max, i - stack.peek());
        // stack.peek() points to last unmatched index
      }
    }
    return max;
  }
}

public class _32_Longest_Valid_Parentheses {

  public static void main(String[] args) {
    System.out.println(new Solution().longestValidParentheses(")())(()()())"));
  }
}
