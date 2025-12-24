class Solution {

  public String toLowerCase(String s) {
    StringBuilder buffer = new StringBuilder();
    for (char ch : s.toCharArray()) buffer.append(
      (ch >= 'A' && ch <= 'Z') ? (char) ((int) ch + 32) : ch
    );
    return buffer.toString();
  }
}

public class _709_To_Lower_Case {

  public static void main(String[] args) {
    System.out.println(new Solution().toLowerCase("Hello"));
  }
}
