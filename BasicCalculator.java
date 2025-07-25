import java.util.Stack;

class Solution {

  public int calculate(String s) {
    int n = s.length();
    char previousOperation = '+';
    Stack<Integer> stack = new Stack<>();
    stack.push(0);
    int sign = 1;
    int result = 0;
    int number = 0;
    for (int i = 0; i < n; i++) {
      char ch = s.charAt(i);
      if (Character.isDigit(ch)) number = (number * 10) + (ch - '0');

      if (
        (!Character.isDigit(ch) && !Character.isWhitespace(ch)) || i == n - 1
      ) {
        if (ch == '+') {
          result += (sign * number);
          number = 0;
          sign = 1;
        } else if (ch == '-') {
          result += (sign * number);
          sign = -1;
          number = 0;
        } else if (ch == '(') {
          stack.push(result);
          stack.push(sign);
          // Resetting for inner expression
          result = 0;
          sign = 1;
        } else if (ch == ')') {
          result += (sign * number);
          result *= stack.pop();
          result += stack.pop();
          number = 0;
          sign = 1;
        }
      }
    }
    result += (sign * number);
    return result;
  }
}

public class BasicCalculator {

  public static void main(String[] args) {
    System.out.println(new Solution().calculate("-10+(3-2)-2"));
  }
}
