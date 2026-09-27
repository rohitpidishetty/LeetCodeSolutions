import java.util.HashSet;
import java.util.Set;

class Solution {

  public int lengthOfLongestSubstring(String s) {
    Set<Character> chars = new HashSet<>();
    int n = s.length();
    int j = 0;
    int max = 0;
    for (int i = 0; i < n; i++) {
      char ch = s.charAt(i);
      while (chars.contains(ch)) chars.remove(s.charAt(j++));
      chars.add(ch);
      max = Math.max(max, (i - j + 1));
    }
    return max;
  }
}

public class _3_Longest_Substring_Without_Repeating_Characters {

  public static void main(String[] args) {
    System.out.println(new Solution().lengthOfLongestSubstring("abcabcbb"));
  }
}
