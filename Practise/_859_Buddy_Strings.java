import java.util.HashMap;
import java.util.Map;

class Solution {

  private boolean isPalindrome(String s) {
    int n = s.length() - 1;
    int i = 0;

    while (i < n) {
      if (s.charAt(i) != s.charAt(n)) return false;
      i++;
      n--;
    }
    return true;
  }

  // 34/39
  // public boolean buddyStrings(String s, String goal) {
  //   int n = s.length();
  //   int m = goal.length();
  //   if (n != m) return false;
  //   if (isPalindrome(s) || isPalindrome(goal)) return s.equals(goal);
  //   Map<Character, Integer> freqMap = new HashMap<>();
  //   // Check if the string is an anagram.
  //   for (int i = 0; i < n; i++) {
  //     char ch = s.charAt(i);
  //     freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
  //   }
  //   for (int i = 0; i < n; i++) {
  //     char ch = goal.charAt(i);
  //     int frq = freqMap.getOrDefault(ch, 0);
  //     freqMap.put(ch, frq - 1);
  //     if (freqMap.get(ch) <= 0) freqMap.remove(ch);
  //   }

  //   if (freqMap.size() > 0) return false;
  //   int diff = 0;
  //   for (int i = 0; i < n; i++) if (s.charAt(i) != goal.charAt(i)) diff++;

  //   return diff == 2;
  // }

  public boolean buddyStrings(String s, String goal) {
    if (s.length() != goal.length()) return false;

    if (s.equals(goal)) {
      Set<Character> seen = new HashSet<>();
      for (char c : s.toCharArray()) if (!seen.add(c)) return true;
      return false;
    }

    int first = -1,
      second = -1;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) != goal.charAt(i)) {
        if (first == -1) first = i;
        else if (second == -1) second = i;
        else return false;
      }
    }

    return (
      second != -1 &&
      s.charAt(first) == goal.charAt(second) &&
      s.charAt(second) == goal.charAt(first)
    );
  }
}

public class _859_Buddy_Strings {

  public static void main(String[] args) {
    System.out.println(new Solution().buddyStrings("ab", "ba"));
    System.out.println(new Solution().buddyStrings("ab", "ab"));
    System.out.println(new Solution().buddyStrings("aa", "aa"));
    System.out.println(new Solution().buddyStrings("abcaa", "abcbb"));
  }
}
