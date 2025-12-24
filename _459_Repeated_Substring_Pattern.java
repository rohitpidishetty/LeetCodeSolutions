class Solution {

  public boolean repeatedSubstringPattern(String s) {
    int n = s.length();
    int mid = n / 2;
    int j = 0;
    while (j < mid) {
      String ss = s.substring(0, (j + 1));
      int m = ss.length();

      if ((n % m) == 0) {
        StringBuilder sb = new StringBuilder().append(ss);
        for (int i = 0; i < ((n - m) / m); i++) sb.append(ss);
        if (sb.toString().equals(s)) return true;
      }
      j++;
    }
    return false;
  }
}

public class _459_Repeated_Substring_Pattern {

  public static void main(String[] args) {
    System.out.println(new Solution().repeatedSubstringPattern("abcabcabcabc"));
  }
}
