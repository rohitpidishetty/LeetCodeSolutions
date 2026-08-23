import java.util.Arrays;

class Solution {

  public boolean isAnagram(String s, String t) {
    int n = s.length();
    int m = t.length();
    if (m != n) return false;
    char[] _s = s.toCharArray();
    char[] _t = t.toCharArray();
    Arrays.sort(_s);
    Arrays.sort(_t);
    int i = 0;
    while (i < n) {
      if (_s[i] != _t[i]) return false;
      i++;
    }
    return true;
  }
}

public class _242_Valid_Anagram {

  public static void main(String[] args) {
    System.out.println(new Solution().isAnagram("rat", "art"));
  }
}
