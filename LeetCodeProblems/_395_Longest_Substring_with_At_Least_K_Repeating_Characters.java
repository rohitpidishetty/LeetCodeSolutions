import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {

  public int longestSubstring(String s, int k) {
    return helper(s, 0, s.length(), k);
  }

  private int helper(String s, int start, int end, int k) {
    if (end - start < k) return 0;

    int[] freq = new int[26];
    for (int i = start; i < end; i++) freq[s.charAt(i) - 'a']++;

    for (int i = start; i < end; i++) {
      if (freq[s.charAt(i) - 'a'] < k) {
        // split at this char, it can't be part of valid substring
        int left = helper(s, start, i, k);
        int right = helper(s, i + 1, end, k);
        return Math.max(left, right);
      }
    }
    return end - start;
  }
}

public class _395_Longest_Substring_with_At_Least_K_Repeating_Characters {

  public static void main(String[] args) {
    System.out.println(new Solution().longestSubstring("aaabb", 3));
  }
}
