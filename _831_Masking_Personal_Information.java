class Solution {

  public String maskPII(String s) {
    if (s.contains("@")) {
      // Email
      s = s.toLowerCase();
      int at = s.indexOf("@");
      String name = s.substring(0, at);
      return (
        name.charAt(0) +
        "*****" +
        name.charAt(name.length() - 1) +
        s.substring(at)
      );
    }
    // Phone
    int len = s.length();
    int phone_len = 0;
    int bar = 0;
    StringBuilder ph = new StringBuilder();
    for (int i = len - 1; i >= 0; i--) {
      char ch = s.charAt(i);
      if (Character.isSpace(ch) || !Character.isDigit(ch)) continue;
      if (phone_len < 4) ph.insert(0, ch);
      else {
        if (bar % 3 == 0) ph.insert(0, "-");
        ph.insert(0, "*");
        bar++;
      }
      phone_len++;
    }
    if (phone_len > 10) ph.insert(0, "+");
    return ph.toString();
  }
}

public class _831_Masking_Personal_Information {

  public static void main(String[] args) {
    System.out.println(new Solution().maskPII("LeetCode@LeetCode.com"));
    System.out.println(new Solution().maskPII("AB@qq.com"));
    System.out.println(new Solution().maskPII("+121(234)567-890"));
  }
}
