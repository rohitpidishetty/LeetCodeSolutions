import java.util.Arrays;

class Solution {

  public String toGoatLatin(String sentence) {
    String[] tokens = sentence.split("\\s");
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < tokens.length; i++) {
      char first = tokens[i].charAt(0);
      char ch = (first >= 'A' && first <= 'Z')
        ? (char) ((((int) first) + 32))
        : first;
      if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') sb
        .append(tokens[i])
        .append("ma")
        .append("a".repeat(i + 1))
        .append(i < tokens.length - 1 ? " " : "");
      else sb
        .append(tokens[i].substring(1))
        .append(first)
        .append("ma")
        .append("a".repeat(i + 1))
        .append(i < tokens.length - 1 ? " " : "");
    }
    return sb.toString();
  }
}

public class _824_Goat_Latin {

  public static void main(String[] args) {
    System.out.println(new Solution().toGoatLatin("I speak Goat Latin"));
  }
}
