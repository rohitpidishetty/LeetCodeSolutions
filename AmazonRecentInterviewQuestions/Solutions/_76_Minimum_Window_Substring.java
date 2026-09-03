import java.util.HashMap;
import java.util.Map;

class Solution {

  public String minWindow(String s, String t) {
    int reqChars = t.length();
    Map<Character, Integer> freq = new HashMap<>();
    for (int i = 0; i < reqChars; i++) {
      freq.put(t.charAt(i), freq.getOrDefault(t.charAt(i), 0) + 1);
    }
    int n = s.length();
    int i = 0;
    int s1 = 0;
    int s2 = -1;
    int min = Integer.MAX_VALUE;
    for (int j = 0; j < n; j++) {
      char curr = s.charAt(j);
      int reduce = freq.getOrDefault(curr, 0) - 1;
      if (reduce >= 0) reqChars--;
      freq.put(curr, reduce);
      while (reqChars == 0) {
        // lets try to shrink.
        if ((j - i + 1) < min) {
          s1 = i;
          s2 = j + 1;
          min = j - i + 1;
        }
        curr = s.charAt(i);
        reduce = freq.get(curr) + 1;
        if (reduce > 0) reqChars++;
        freq.put(curr, reduce);
        i++;
      }
    }
    return s1 >= s2 ? "" : s.substring(s1, s2);
  }
}

public class _76_Minimum_Window_Substring {

  public static void main(String[] args) {
    System.out.println(new Solution().minWindow("ADOBECODEBANC", "ABC"));
  }
}
