import java.util.Stack;

class Solution {

  public int evalRPN(String[] tokens) {
    Stack<Integer> s = new Stack<>();
    int a, b;
    for (String token : tokens) {
      switch (token) {
        case "+":
          a = s.pop();
          b = s.pop();
          s.push(b + a);
          break;
        case "-":
          a = s.pop();
          b = s.pop();
          s.push(b - a);
          break;
        case "/":
          a = s.pop();
          b = s.pop();
          s.push(b / a);
          break;
        case "%":
          a = s.pop();
          b = s.pop();
          s.push(b % a);
          break;
        case "*":
          a = s.pop();
          b = s.pop();
          s.push(b * a);
          break;
        default:
          s.push(Integer.parseInt(token));
          break;
      }
    }
    return s.pop();
  }
}

public class _150_Evaluate_Reverse_Polish_Notation {

  public static void main(String[] args) {
    System.out.println(
      new Solution().evalRPN(new String[] { "2", "1", "+", "3", "*" })
    );
  }
}
