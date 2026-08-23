import java.util.HashMap;
import java.util.Map;

class Solution {
  public String minWindow_v0(String s, String t) {
    char[] tokens = t.toCharArray();
    int min = Integer.MAX_VALUE;
    String subStr = new String();
    boolean firstMovement = false;
    Map<Character, Integer> map = new HashMap<>();
    for (char ch : tokens)
      map.put(ch, map.getOrDefault(ch, 0) + 1);
    Map<Character, Integer> saved = new HashMap<>(map);
    int left = 0, right = 0, occ = -1;
    tokens = s.toCharArray();
    char pointer = tokens[right];
    while (right < tokens.length) {
      pointer = tokens[right];
      if (map.get(pointer) != null) {
        if (!firstMovement)
          left = right;
        firstMovement = true;
        occ = map.get(pointer);
        if (occ > 0) {
          map.put(pointer, --occ);
          Object[] obj = map.values().toArray();
          int state = (int) obj[0];
          for (int i = 1; i < obj.length; i++)
            state |= (int) obj[i];
          System.out.println(state);
          if (state == 0) {
            if (((right - left) + 1) < min) {
              subStr = s.substring(left, right + 1);
              min = (right - left) + 1;
            }
            left = right + 1;
            map = new HashMap<>(saved);
            firstMovement = false;
          }
        }
      }
      right++;
    }
    return subStr;
  }

  public String minWindow(String s, String t) {
    char[] s_tokens = s.toCharArray();
    char[] t_tokens = t.toCharArray();
    int lowerIndex = -1, upperIndex = -1;
    int min = Integer.MAX_VALUE;
    int mag = 0;
    Map<Character, Integer> lookUp = new HashMap<>();
    for (char ch : t_tokens)
      lookUp.put(ch, lookUp.getOrDefault(ch, 0) + 1);
    int left = 0, right = 0, charCounter = 0;
    char character = '\0';
    while (right < s_tokens.length) {
      character = s_tokens[right];
      if (lookUp.containsKey(character)) {
        if (lookUp.get(character) > 0)
          charCounter++;
        lookUp.put(character, lookUp.get(character) - 1);
      }
      while (charCounter == t_tokens.length) {
        mag = (right - left) + 1;
        if (mag < min) {
          min = mag;
          lowerIndex = left;
          upperIndex = right;
        }
        if (lookUp.containsKey(s_tokens[left])) {
          lookUp.put(s_tokens[left], lookUp.get(s_tokens[left]) + 1);
          if (lookUp.get(s_tokens[left]) > 0)
            charCounter--;
        }
        left++;
      }
      right++;
    }
    return (lowerIndex == -1) ? "" : s.substring(lowerIndex, upperIndex + 1);
  }
}

public class MinWinWord {
  public static void main(String[] args) {
    System.out.println(new Solution().minWindow("bdaab", "ab"));
  }
}
