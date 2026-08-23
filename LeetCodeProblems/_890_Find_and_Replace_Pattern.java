import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

  public List<String> findAndReplacePattern(String[] words, String pattern) {
    List<String> result = new ArrayList<>();
    int n = pattern.length();
    Map<Character, Character> map = new HashMap<>();
    Map<Character, Character> reverseMap = new HashMap<>();
    for (String word : words) {
      boolean status = true;
      for (int i = 0; i < n; i++) {
        char x1 = pattern.charAt(i);
        char x2 = word.charAt(i);
        if (map.containsKey(x1) && map.get(x1) != x2) {
          status = false;
          break;
        }
        if (reverseMap.containsKey(x2) && reverseMap.get(x2) != x1) {
          status = false;
          break;
        }
        map.put(x1, x2);
        reverseMap.put(x2, x1);
      }
      map.clear();
      reverseMap.clear();
      if (status) result.add(word);
    }
    return result;
  }
}

public class _890_Find_and_Replace_Pattern {

  public static void main(String[] args) {
    System.out.println(
      new Solution().findAndReplacePattern(
        new String[] { "abc", "deq", "mee", "aqq", "dkd", "ccc" },
        new String("abb")
      )
    );
    System.out.println(
      new Solution().findAndReplacePattern(
        new String[] { "a", "b", "c" },
        new String("a")
      )
    );
  }
}
