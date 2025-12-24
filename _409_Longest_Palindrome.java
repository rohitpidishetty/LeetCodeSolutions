import java.util.HashMap;
import java.util.Map;

class Solution {

  public int longestPalindrome(String s) {
    int n = s.length();
    Map<Character, Integer> freq = new HashMap<>();
    for (int i = 0; i < n; i++) {
      char ch = s.charAt(i);
      freq.put(ch, freq.getOrDefault(ch, 0) + 1);
    }
    int len = 0;
    int extra = 0;
    for (Map.Entry<Character, Integer> m : freq.entrySet()) {
      int x = m.getValue();
      Character k = m.getKey();
      if (x % 2 == 0) {
        len += x;
        freq.put(k, 0);
      } else {
        len += (x - 1);
        freq.put(k, 1);
        extra = 1;
      }
    }
    return len + extra;
  }
}

public class _409_Longest_Palindrome {

  public static void main(String[] args) {
    System.out.println(new Solution().longestPalindrome("abccccdd"));
  }
}
