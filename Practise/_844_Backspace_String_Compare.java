import java.util.Stack;

class Solution {

  public boolean backspaceCompare(String s, String t) {
    StringBuilder t1 = new StringBuilder();
    StringBuilder t2 = new StringBuilder();
    int len = s.length();
    for (int i = 0; i < len; i++) {
      char ch = s.charAt(i);
      if (!t1.isEmpty() && ch == '#') t1.deleteCharAt(t1.length() - 1);
      else if (ch != '#') t1.append(s.charAt(i));
    }

    len = t.length();
    for (int i = 0; i < len; i++) {
      char ch = t.charAt(i);
      if (!t2.isEmpty() && ch == '#') t2.deleteCharAt(t2.length() - 1);
      else if (ch != '#') t2.append(t.charAt(i));
    }
    return t1.toString().equals(t2.toString());
  }
}

public class _844_Backspace_String_Compare {

  public static void main(String[] args) {
    System.out.println(
      new Solution().backspaceCompare(new String("ab#c"), new String("ad#c"))
    );
    System.out.println(
      new Solution().backspaceCompare(
        new String("y#fo##f"),
        new String("y#f#o##f")
      )
    );
  }
}
