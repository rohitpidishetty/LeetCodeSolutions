class Solution {

  public int repeatedStringMatch(String a, String b) {
    int counter = 0;
    StringBuilder sb = new StringBuilder();
    while (sb.length() < b.length()) {
      sb.append(a);
      counter++;
    }
    if (sb.indexOf(b) != -1) return counter;
    counter++;
    sb.append(a);
    if (sb.indexOf(b) != -1) return counter;
    return -1;
  }
}

public class _686_Repeated_String_Match {

  public static void main(String[] args) {
    System.out.println(new Solution().repeatedStringMatch("abcd", "cdabcdab"));
  }
}
