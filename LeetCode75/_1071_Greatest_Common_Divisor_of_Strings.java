class Solution {

  private int gcd(int a, int b) {
    while (a % b != 0) {
      int t = b;
      b = a % b;
      a = t;
    }
    return b;
  }

  public String gcdOfStrings(String str1, String str2) {
    if (!(str1 + str2).equals(str2 + str1)) return "";
    int gcd = gcd(str1.length(), str2.length());
    return str1.substring(0, gcd);
  }
}

public class _1071_Greatest_Common_Divisor_of_Strings {

  public static void main(String[] args) {
    System.out.println(new Solution().gcdOfStrings("ABCABC", "ABC"));
  }
}
