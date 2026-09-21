import java.util.Stack;
import java.util.Stack;

class Solution {

  public String decodeString(String s) {
    Stack<String> stack = new Stack<>();

    for (char ch : s.toCharArray()) {
      if (ch != ']') {
        stack.push(String.valueOf(ch));
        continue;
      }

      String sub = "";

      while (!stack.peek().equals("[")) sub = stack.pop() + sub;

      stack.pop(); // remove [

      String num = "";

      while (
        !stack.isEmpty() &&
        stack.peek().length() == 1 &&
        Character.isDigit(stack.peek().charAt(0))
      ) num = stack.pop() + num;

      int count = Integer.parseInt(num);

      StringBuilder decoded = new StringBuilder();

      while (count-- > 0) decoded.append(sub);

      stack.push(decoded.toString());
    }

    String result = "";

    while (!stack.isEmpty()) {
      result = stack.pop() + result;
    }

    return result;
  }
}

public class _394_Decode_String {

  public static void main(String[] args) {
    System.out.println(new Solution().decodeString("3[a]2[bc]"));
  }
}
