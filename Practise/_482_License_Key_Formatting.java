class Solution {
  public String licenseKeyFormatting(String s, int k) {
    int counter = 0;
    StringBuilder sb = new StringBuilder();
    int n = s.length() - 1;
    for (int i = n; i >= 0; i--) {
      char ch = s.charAt(i);
      if (ch >= 'a' && ch <= 'z')
        ch = (char) ((int) ch - 32);
      if (ch != '-') {
        sb.append(ch);
        counter++;
      }
      if (counter == k && i > 0) {
        counter = 0;
        sb.append('-');
      }
    }
    int idx = sb.length() - 1;
    while (idx > 0 && sb.charAt(idx) == '-')
      sb.deleteCharAt(idx--);
    return sb.reverse().toString();
  }
}

public class _482_License_Key_Formatting {
  public static void main(String[] args) {
    System.out.println(new Solution().licenseKeyFormatting("5F3Z-2e-9-w", 4));
  }
}
