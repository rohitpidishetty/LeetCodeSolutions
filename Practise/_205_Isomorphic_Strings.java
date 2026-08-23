import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {

  public boolean isIsomorphic(String s, String t) {
    int n = s.length();
    int m = t.length();
    if (n != m) return false;
    Map<Character, Character> m1 = new HashMap<>();
    Map<Character, Character> m2 = new HashMap<>();
    for (int i = 0; i < m; i++) {
      char s_ch = s.charAt(i);
      char t_ch = t.charAt(i);
      if (m1.containsKey(s_ch) && m1.get(s_ch) != t_ch) return false;
      else m1.put(s_ch, t_ch);
      if (m2.containsKey(t_ch) && m2.get(t_ch) != s_ch) return false;
      else m2.put(t_ch, s_ch);
    }
    return true;
  }
}

public class _205_Isomorphic_Strings {

  public static void main(String[] args) {
    System.out.println(new Solution().isIsomorphic("eff", "dgg"));
  }
}
