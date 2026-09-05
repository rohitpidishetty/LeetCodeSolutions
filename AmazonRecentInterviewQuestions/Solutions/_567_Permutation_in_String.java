import java.util.Arrays;

class Solution {

  public boolean checkInclusion(String s1, String s2) {
    int[] s1Map = new int[26];
    int[] freqMap = new int[26];
    int n = s1.length();
    for (int i = 0; i < n; i++) s1Map[s1.charAt(i) - 'a']++;
    int k = s2.length();
    for (int i = 0; i < k; i++) {
      freqMap[s2.charAt(i) - 'a']++;
      if (i >= n - 1) {
        if (Arrays.compare(freqMap, s1Map) == 0) return true;
        freqMap[s2.charAt(i - n + 1) - 'a']--;
      }
    }
    return false;
  }
}

public class _567_Permutation_in_String {

  public static void main(String[] args) {
    System.out.println(new Solution().checkInclusion("ab", "eidbaooo"));
  }
}
