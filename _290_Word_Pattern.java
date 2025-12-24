import java.util.HashMap;
import java.util.Map;

class Solution {

  public boolean wordPattern(String pattern, String s) {
    String[] words = s.split(" ");
    Map<Character, String> map = new HashMap<>();
    Map<String, Character> map2 = new HashMap<>();
    int n = pattern.length();
    if (n != words.length) return false;
    for (int i = 0; i < n; i++) {
      if (
        (map.containsKey(pattern.charAt(i)) &&
          !map.get(pattern.charAt(i)).equals(words[i])) ||
        (map2.containsKey(words[i]) &&
          !map2.get(words[i]).equals(pattern.charAt(i)))
      ) return false;
      map.put(pattern.charAt(i), words[i]);
      map2.put(words[i], pattern.charAt(i));
    }
    return true;
  }
}

public class _290_Word_Pattern {

  public static void main(String[] args) {
    System.out.println(new Solution().wordPattern("aaa", "aa aa aa aa"));
    /**
     * a -> dog | dog -> a
     * b -> dog
     */
  }
}
