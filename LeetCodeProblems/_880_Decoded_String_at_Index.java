class Solution {

  // public String decodeAtIndex(String s, int k) {
  //   int n = s.length();
  //   int m;
  //   StringBuilder sb = new StringBuilder();
  //   for (int i = 0; i < n; i++) {
  //     char ch = s.charAt(i);
  //     if (sb.length() >= k) {
  //       m = sb.length();

  //       return String.valueOf(sb.charAt(m - 1 - (m - k)));
  //     }
  //     if (!Character.isDigit(ch)) sb.append(ch);
  //     else sb.append(new StringBuilder().repeat(sb, (ch - '0') - 1));
  //   }
  //   m = sb.length();
  //   return String.valueOf(sb.charAt(m - 1 - (m - k)));
  // }

  public String decodeAtIndex(String s, int k) {
    int n = s.length();
    long m = 0;

    for (int i = 0; i < n; i++) {
      char ch = s.charAt(i);
      if (!Character.isDigit(ch)) m++;
      else m *= (ch - '0');
    }
    long K = k;
    for (int i = n - 1; i > -1; i--) {
      K = K % m;
      char ch = s.charAt(i);
      if (K == 0 && Character.isAlphabetic(ch)) return String.valueOf(ch);
      if (Character.isDigit(ch)) m /= (ch - '0');
      else m--;
    }
    return null;
  }
}

public class _880_Decoded_String_at_Index {

  public static void main(String[] args) {
    System.out.println(new Solution().decodeAtIndex("leet2code3", 10));
  }
}
