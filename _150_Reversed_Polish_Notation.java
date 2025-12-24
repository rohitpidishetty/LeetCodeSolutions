import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

class Solution {
  public int evalRPN(String[] tokens) {
    int i = 0;
    Stack<Integer> nums = new Stack<>();
    while (i < tokens.length) {
      String ch = tokens[i];
      if (ch.equals("+") || ch.equals("-") || ch.equals("*") || ch.equals("/")) {
        int lopr = nums.pop();
        int fopr = nums.pop();
        switch (ch) {
          case "+":
            nums.push(fopr + lopr);
            break;
          case "-":
            nums.push(fopr - lopr);
            break;
          case "/":
            nums.push(fopr / lopr);
            break;
          case "*":
            nums.push(fopr * lopr);
            break;
        }
      } else
        nums.push(Integer.parseInt(ch));
      i++;
    }
    return nums.pop();
  }
}

public class _150_Reversed_Polish_Notation {
  public static void main(String[] args) {
    System.out.println(
        new Solution().evalRPN(new String[] { "4", "13", "5", "/", "+" }));
  }
}
