import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

  public List<Integer> findAnagrams(String s, String p) {
    List<Integer> buffer = new ArrayList<>();
    int i = 0, j = 0, n = s.length() - 1, winSize = p.length() - 1;
    Map<Character, Integer> pMap = new HashMap<>();

    for (int k = 0; k <= winSize; k++) {
      char ch = p.charAt(k);
      pMap.put(ch, pMap.getOrDefault(ch, 0) + 1);
    }

    Map<Character, Integer> freq = new HashMap<>();
    while (j <= n) {
      char ch = s.charAt(j);
      freq.put(ch, freq.getOrDefault(ch, 0) + 1);

      if (j > winSize) {
        char subCh = s.charAt(i);
        int char_freq = freq.get(subCh);
        if (char_freq == 1) freq.remove(subCh);
        else freq.put(subCh, char_freq - 1);
        i++;
      }

      if (freq.equals(pMap)) buffer.add(i);

      j++;
    }

    return buffer;
  }
}

public class _438_Find_All_Anagrams_in_a_String {

  public static void main(String[] args) {
    System.out.println(new Solution().findAnagrams("abab", "ab"));
  }
}
