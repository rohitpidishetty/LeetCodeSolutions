import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {

  // public int scoreOfParentheses(String s) {
  //   int n = s.length();
  //   Stack<String> stack = new Stack<>();
  //   for (int i = 0; i < n; i++) {
  //     char ch = s.charAt(i);
  //     if (ch == '(') stack.push("(");
  //     else {
  //       if (!stack.isEmpty() && stack.peek().equals("(")) {
  //         stack.pop();
  //         stack.push("1");
  //       } else {
  //         List<Integer> al = new ArrayList<>();
  //         while (!stack.isEmpty() && !stack.peek().equals("(")) {
  //           al.add(Integer.parseInt(stack.pop()));
  //         }
  //         if (!stack.isEmpty()) stack.pop();
  //         if (al.size() == 1) stack.push(String.valueOf(al.get(0) * 2));
  //         else {
  //           int j = 0;
  //           int m = al.size();
  //           int sum = 0;
  //           while (j < m) sum += al.get(j++);
  //           stack.push(String.valueOf(sum * 2));
  //         }
  //       }
  //     }
  //   }

  //   if (stack.size() == 1) return Integer.valueOf(stack.pop());

  //   return stack
  //     .stream()
  //     .mapToInt(e -> Integer.parseInt(e))
  //     .sum();
  // }

  public int scoreOfParentheses(String s) {
    int n = s.length();
    int boundary = Integer.MIN_VALUE;
    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < n; i++) {
      char ch = s.charAt(i);
      if (ch == '(') stack.push(boundary);
      else {
        if (!stack.isEmpty() && stack.peek().equals(boundary)) {
          stack.pop();
          stack.push(1);
        } else {
          List<Integer> al = new ArrayList<>();
          while (!stack.isEmpty() && !stack.peek().equals(boundary)) {
            al.add(stack.pop());
          }
          if (!stack.isEmpty()) stack.pop();
          if (al.size() == 1) stack.push(al.get(0) * 2);
          else {
            int j = 0;
            int m = al.size();
            int sum = 0;
            while (j < m) sum += al.get(j++);
            stack.push(sum * 2);
          }
        }
      }
    }

    if (stack.size() == 1) return stack.pop();
    n = 0;
    while (!stack.isEmpty()) n += stack.pop();

    return n;
  }
}

public class _856_Score_of_Parentheses {

  public static void main(String[] args) {
    // System.out.println(new Solution().scoreOfParentheses("(()(()))"));
    // System.out.println(new Solution().scoreOfParentheses("()()"));
    System.out.println(new Solution().scoreOfParentheses("(()()())"));
  }
}
