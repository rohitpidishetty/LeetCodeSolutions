import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class Solution {

  public boolean isValid(String s) {
    System.out.println(s);
    Map<Character, Character> counterParts = new HashMap<>();
    counterParts.put('{', '}');
    counterParts.put('[', ']');
    counterParts.put('(', ')');
    Stack<Character> stack = new Stack<>();
    for (char ch : s.toCharArray()) {
      if (counterParts.containsKey(ch)) stack.push(counterParts.get(ch));
      else {
        if (stack.isEmpty() || stack.peek() != ch) return false;
        else stack.pop();
      }
    }
    return stack.isEmpty();
  }
}

/**
 *
 *
 */

public class _20_Valid_Parentheses {

  public static void main(String[] args) {
    System.out.println(new Solution().isValid("()"));
    // System.out.println(new Solution().isValid("([)]"));
  }
}
