import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

class Solution {

  private void dfs(
    List<Character> tokens,
    int size,
    int lbc,
    int rbc,
    Set<String> buf
  ) {
    if (lbc == 0 && rbc == 0) {
      Stack<Character> stack = new Stack<>();
      for (char ch : tokens) {
        if (ch == '(') stack.push('(');
        else if (ch == ')') {
          if (!stack.isEmpty() && stack.peek() == '(') stack.pop();
          else stack.push(')');
        }
      }
      if (stack.isEmpty()) {
        StringBuilder sb = new StringBuilder();
        for (char ch : tokens) sb.append(ch);
        buf.add(sb.toString());
      }
      return;
    }
    for (int i = 0; i < size; i++) {
      if (lbc > 0 && tokens.get(i) == '(') {
        List<Character> copy = new ArrayList<>(tokens);
        copy.remove(i);
        dfs(copy, copy.size(), lbc - 1, rbc, buf);
      }
      if (rbc > 0 && tokens.get(i) == ')') {
        List<Character> copy = new ArrayList<>(tokens);
        copy.remove(i);
        dfs(copy, copy.size(), lbc, rbc - 1, buf);
      }
    }
  }

  public List<String> removeInvalidParentheses(String s) {
    char[] tokens = s.toCharArray();
    int lbc = 0;
    int rbc = 0;
    Stack<Character> stack = new Stack<>();
    for (char ch : tokens) {
      if (ch == '(') stack.push('(');
      else if (ch == ')') {
        if (!stack.isEmpty() && stack.peek() == '(') stack.pop();
        else stack.push(')');
      }
    }
    if (stack.isEmpty()) return new ArrayList<>(Arrays.asList(s));
    while (!stack.isEmpty()) {
      if (stack.pop() == ')') rbc++;
      else lbc++;
    }
    List<Character> buffer = new ArrayList<>();
    for (char ch : tokens) buffer.add(ch);
    Set<String> ret = new HashSet<>();
    dfs(buffer, buffer.size(), lbc, rbc, ret);
    return new ArrayList<>(ret);
  }
}

public class _301_Remove_Invalid_Parentheses {

  public static void main(String[] args) {
    System.out.println(new Solution().removeInvalidParentheses("(a)())(()"));
  }
}
