import java.util.Stack;

class Solution {

  public int calculate(String s) {
    int i = 0;
    int n = s.length();
    char previousOperation = '+';
    Stack<Integer> stack = new Stack<>();
    int number = 0;
    while (i < n) {
      char ch = s.charAt(i);
      if (Character.isDigit(ch)) number = (number * 10) + (ch - '0');
      if (
        (!Character.isDigit(ch) && !Character.isWhitespace(ch)) || i == n - 1
      ) {
        // Number has been collected.
        // Now we have to store the number in the stack.
        // We can directly store the number into stack if and only if the previousOperation is '+' | '-' else we need to compute and store.
        if (previousOperation == '+') stack.push(number);
        else if (previousOperation == '-') stack.push(-number);
        else if (previousOperation == '/') {
          // While we are dealing with the number '2' the previous operation will be '/' and the stacks top will be 15.
          // We need to compute 15 / 2 and store the result back into the stack.
          stack.push(stack.pop() / number);
        } else if (previousOperation == '*') {
          stack.push(stack.pop() * number);
        }
        previousOperation = ch;
        number = 0;
      }
      i++;
    }
    int result = 0;
    while (!stack.isEmpty()) result += stack.pop();
    return result;
  }
}

public class _227_Basic_Calculator_II {

  public static void main(String[] args) {
    // 32+15/2*9-2
    // (32) + ((15/2)*9) + (-2)
    //  x         y          z
    // Ans: x+y+z
    System.out.println(new Solution().calculate("32+15/2*9-2"));
  }
}
