import java.util.HashMap;
import java.util.Map;

class Solution {

  private int solve(int s, int e, String str, int k) {
    int[] freq = new int[26];

    for (int i = s; i < e; i++) freq[str.charAt(i) - 'a']++;

    for (int i = s; i < e; i++) {
      if (freq[str.charAt(i) - 'a'] < k) {
        int left = solve(s, i, str, k);
        int right = solve(i + 1, e, str, k);
        return Math.max(left, right);
      }
    }

    return e - s;
  }

  public int longestSubstring(String s, int k) {
    return solve(0, s.length(), s, k);
  }
}

public class _395_Longest_Substring_with_At_Least_K_Repeating_Characters {

  public static void main(String[] args) {
    System.out.println(new Solution().longestSubstring("bbaaacbd", 3));
  }
}
