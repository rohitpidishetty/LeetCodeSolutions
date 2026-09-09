class Solution {

  public boolean isIsomorphic(String s, String t) {
    char[] map = new char[128];
    char[] map2 = new char[128];
    int n = s.length();
    for (int i = 0; i < n; i++) {
      char s_ch = s.charAt(i);
      char t_ch = t.charAt(i);
      if (
        (map[s_ch] != '\0' && map[s_ch] != t_ch) ||
        (map2[t_ch] != '\0' && map2[t_ch] != s_ch)
      ) return false;
      map[s_ch] = t_ch;
      map2[t_ch] = s_ch;
    }
    return true;
  }
}

public class _205_Isomorphic_Strings {

  public static void main(String[] args) {
    System.out.println(new Solution().isIsomorphic("egg", "add"));
  }
}
