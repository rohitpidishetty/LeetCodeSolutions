class Solution {

  public int maximumLengthSubstring(String s) {
    int i = 0;
    int j = 0;
    int[] freq = new int[26];
    int n = s.length();

    int maxLen = 0;
    for (; i < n; i++) {
      int ch = s.charAt(i) - 'a';
      freq[ch]++;
      while (j < n && freq[ch] > 2) {
        freq[s.charAt(j) - 'a']--;
        j++;
      }
      maxLen = Math.max(maxLen, i - j + 1);
    }
    return maxLen;
  }
}

public class _3090_Maximum_Length_Substring_With_Two_Occurrences {

  public static void main(String[] args) {
    System.out.println(new Solution().maximumLengthSubstring("bcbbbcba"));
  }
}
