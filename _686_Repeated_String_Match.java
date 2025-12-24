class Solution {

  public int repeatedStringMatch(String a, String b) {
    StringBuilder sb = new StringBuilder();
    int count = 0;

    while (sb.length() < b.length()) {
      sb.append(a);
      count++;
    }

    if (sb.indexOf(b) != -1) return count;
    sb.append(a);
    if (sb.indexOf(b) != -1) return count + 1;

    return -1;
  }
}

public class _686_Repeated_String_Match {

  public static void main(String[] args) {
    System.out.println(
      new Solution().repeatedStringMatch("abcdecd", "cdabcdab")
    );
  }
}
