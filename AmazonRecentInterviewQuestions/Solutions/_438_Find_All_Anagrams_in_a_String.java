import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

  public List<Integer> findAnagrams(String s, String p) {
    int[] pFreqMap = new int[26];
    int[] sFreqMap = new int[26];
    List<Integer> res = new ArrayList<>();
    int i = 0;
    int n = p.length();
    for (; i < n; i++) pFreqMap[p.charAt(i) - 'a']++;
    int m = s.length();
    for (i = 0; i < m; i++) {
      sFreqMap[s.charAt(i) - 'a']++;
      if (i >= n - 1) {
        if (Arrays.compare(pFreqMap, sFreqMap) == 0) res.add(i - n + 1);
        sFreqMap[s.charAt(i - n + 1) - 'a']--;
      }
    }
    return res;
  }
}

public class _438_Find_All_Anagrams_in_a_String {

  public static void main(String[] args) {
    System.out.println(new Solution().findAnagrams("cbaebabacd", "abc"));
  }
}
