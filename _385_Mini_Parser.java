import java.util.*;

class Solution {

  public NestedInteger deserialize(String s) {
    // Edge case: if the string represents a single number (no brackets)
    if (s.charAt(0) != '[') {
      return new NestedInteger(Integer.parseInt(s));
    }

    Deque<NestedInteger> stack = new ArrayDeque<>();
    int num = 0;
    boolean negative = false;
    boolean hasNumber = false;

    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c == '-') {
        negative = true;
      } else if (Character.isDigit(c)) {
        hasNumber = true;
        num = num * 10 + (c - '0');
      } else if (c == '[') {
        stack.push(new NestedInteger());
      } else if (c == ',' || c == ']') {
        if (hasNumber) {
          int value = negative ? -num : num;
          stack.peek().add(new NestedInteger(value));
          num = 0;
          negative = false;
          hasNumber = false;
        }
        if (c == ']' && stack.size() > 1) {
          NestedInteger top = stack.pop();
          stack.peek().add(top);
        }
      }
    }
    return stack.isEmpty() ? new NestedInteger() : stack.pop();
  }
}
