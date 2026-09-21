import java.util.Arrays;

class Solution {

  public int maxVowels(String s, int k) {
    int[] freq = new int[26];
    int n = s.length();
    int max = 0;
    for (int i = 0; i < n; i++) {
      char ch = s.charAt(i);

      if (i >= k) {
        char prev = s.charAt(i - k);
        if (
          prev == 'a' ||
          prev == 'e' ||
          prev == 'i' ||
          prev == 'o' ||
          prev == 'u'
        ) {
          freq[prev - 'a']--;
        }
      }

      if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
        freq[ch - 'a']++;
      }

      int count = 0;
      for (int j = 0; j < 26; j++) if (freq[j] > 0) count += freq[j];
      max = Math.max(max, count);
    }
    return max;
  }
}

public class _1456_Maximum_Number_of_Vowels_in_a_Substring_of_Given_Length {

  public static void main(String[] args) {
    System.out.println(new Solution().maxVowels("abciiidef", 3));
  }
}
