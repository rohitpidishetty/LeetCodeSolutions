import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {

  public String mostCommonWord(String paragraph, String[] banned) {
    Set<String> ban = new HashSet<>();
    for (String banWords : banned) ban.add(banWords);
    int n = paragraph.length();
    StringBuilder word = new StringBuilder();
    Map<String, Integer> freq = new HashMap<>();
    String mostCommon = new String();
    int mostCommonFreq = 0;
    for (int i = 0; i < n; i++) {
      char ch = paragraph.charAt(i);
      if (ch == '\'' || ch == '?') continue;

      if (ch >= 'A' && ch <= 'Z') {
        word.append((char) (ch + 32));
      } else if (ch >= 'a' && ch <= 'z') {
        word.append(ch);
      } else if (
        ch == ' ' || ch == ';' || ch == '.' || ch == '!' || ch == ','
      ) {
        String temp = word.toString();
        if (!ban.contains(temp) && word.length() > 0) {
          int m = freq.getOrDefault(temp, 0) + 1;
          if (m > mostCommonFreq) {
            mostCommon = temp;
            mostCommonFreq = m;
          }
          freq.put(temp, m);
        }
        word.setLength(0);
      }
    }
    String temp = word.toString();
    if (!ban.contains(temp) && word.length() > 0) {
      int m = freq.getOrDefault(temp, 0) + 1;
      if (m > mostCommonFreq) {
        mostCommon = temp;
        mostCommonFreq = m;
      }
      freq.put(temp, m);
    }
    return mostCommon;
  }
}

public class _819_Most_Common_Word {

  public static void main(String[] args) {
    System.out.println(
      new Solution().mostCommonWord(
        "Bob hit a ball, the hi't BALL flew far after it was hi't.",
        new String[] { "hit" }
      )
    );
    System.out.println(new Solution().mostCommonWord("a.", new String[] {}));
    System.out.println(new Solution().mostCommonWord("a b.b", new String[] {}));
    System.out.println(
      new Solution().mostCommonWord(
        "Bob. hIt, baLl",
        new String[] { "bob", "hit" }
      )
    );
  }
}
