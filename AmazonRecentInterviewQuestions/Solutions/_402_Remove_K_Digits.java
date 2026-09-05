import java.util.Stack;

class Solution {

  public String removeKdigits(String num, int k) {
    int n = num.length();
    if (n == k) return "0";
    Stack<Integer> s = new Stack<>();
    for (int i = 0; i < n; i++) {
      int e = num.charAt(i) - '0';
      while (!s.isEmpty() && k > 0 && s.peek() > e) {
        s.pop();
        k--;
      }
      s.push(e);
    }
    while (k > 0) {
      s.pop();
      k--;
    }
    StringBuilder sb = new StringBuilder();
    while (!s.isEmpty()) sb.append(s.pop());
    num = sb.reverse().toString();
    int i = 0;
    n = num.length();

    while (i < n && num.charAt(i) == '0') i++;
    return i >= n ? "0" : num.substring(i);
  }
}

public class _402_Remove_K_Digits {

  public static void main(String[] args) {
    System.out.println(new Solution().removeKdigits("10", 2));
  }
}
