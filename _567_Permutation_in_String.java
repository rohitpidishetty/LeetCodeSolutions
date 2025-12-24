import java.util.Arrays;

class Solution {
  public boolean checkInclusion(String s1, String s2) {
    int win = s1.length();
    int[] s1_map = new int[26], s2_map = new int[26];
    for (int i = 0; i < win; i++)
      s1_map[s1.charAt(i) - 'a']++;
    int s2_lim = s2.length();
    int j = 0;
    int i = 0;
    while (j < s2_lim) {
      if (j > win - 1)
        s2_map[s2.charAt(i++) - 'a']--;
      s2_map[s2.charAt(j) - 'a']++;
      if (Arrays.compare(s1_map, s2_map) == 0)
        return true;
      j++;
    }

    return false;
  }
}

public class _567_Permutation_in_String {
  public static void main(String[] args) {
    System.out.println(new Solution().checkInclusion("abcba", "pmkikk"));
  }
}
