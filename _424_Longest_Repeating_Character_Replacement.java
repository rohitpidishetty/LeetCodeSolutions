import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {

  private int highFreq(int[] map) {
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < map.length; i++) max = Math.max(max, map[i]);
    return max;
  }

  public int characterReplacement(String s, int k) {
    int[] hMap = new int[26];
    int i = 0, j = 0, n = s.length(), max = Integer.MIN_VALUE;
    while (j < n) {
      char ch = s.charAt(j);
      hMap[ch - 'A']++;
      while (((j - i) + 1) - highFreq(hMap) > k) {
        char c = s.charAt(i);
        hMap[c - 'A']--;
        i++;
      }
      max = Math.max(max, (j - i) + 1);
      j++;
    }
    return max;
  }
}

public class _424_Longest_Repeating_Character_Replacement {

  public static void main(String[] args) {
    System.out.println(new Solution().characterReplacement("AABABBA", 1));
  }
}
