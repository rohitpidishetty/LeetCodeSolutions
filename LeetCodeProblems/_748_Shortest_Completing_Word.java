import java.util.Arrays;

class Solution {

  public String shortestCompletingWord(String licensePlate, String[] words) {
    int[] rootMap = new int[26];
    for (char ch : licensePlate.toCharArray()) {
      if (Character.isDigit(ch) || Character.isWhitespace(ch)) continue;
      rootMap[(ch >= 'A' && ch <= 'Z')
          ? ((char) ((int) ch + 32) - 'a')
          : (ch - 'a')]++;
    }
    int max_len = Integer.MAX_VALUE;
    String ans = new String();
    for (String word : words) {
      int len = word.length();
      int[] map = new int[26];
      for (char ch : word.toCharArray()) map[(ch - 'a')]++;
      boolean ok = true;
      for (int i = 0; i < 26; i++) if (rootMap[i] > map[i]) {
        ok = false;
        break;
      }
      if (ok && len < max_len) {
        max_len = len;
        ans = word;
      }
    }
    return ans;
  }
}

public class _748_Shortest_Completing_Word {

  public static void main(String[] args) {
    System.out.println(
      new Solution()
        .shortestCompletingWord(
          new String("GrC8950"),
          new String[] {
            "measure",
            "other",
            "every",
            "base",
            "according",
            "level",
            "meeting",
            "none",
            "marriage",
            "rest",
          }
        )
    );
  }
}
