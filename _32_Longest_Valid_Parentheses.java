import java.util.Stack;

class Solution {
  public int longestValidParentheses(String s) {
    char[] tokens = s.toCharArray();
    Stack<Integer> S = new Stack<>();
    S.push(-1);
    int ret = 0;
    for (int i = 0; i < tokens.length; i++) {
      char ch = tokens[i];
      if (ch == '(') {
        S.push(i);
      } else {

        S.pop();
        if (S.isEmpty())
          S.push(i);
        else
          ret = Math.max(ret, i - S.peek());

      }
    }

    return ret;
  }
}

public class _32_Longest_Valid_Parentheses {
  public static void main(String[] args) {
    System.out.println(new Solution().longestValidParentheses(")()())"));
  }
}
