import java.util.Arrays;

class Solution {

  public boolean isAnagram(String s, String t) {
    int x = s.length();
    int y = t.length();
    if (x != y) return false;
    int[] map = new int[26];

    for (int i = 0; i < x; i++) {
      map[s.charAt(i) - 'a']++;
      map[t.charAt(i) - 'a']--;
    }
    for (int i = 0; i < map.length; i++) if (map[i] != 0) return false;
    return true;
  }
}

public class _242_Valid_Anagram {

  public static void main(String[] args) {
    System.out.println(new Solution().isAnagram("anagram", "nagaram"));
  }
}
