import java.util.HashMap;
import java.util.Map;

class Solution {
  // 61/86
  // private Map<String, Integer> memo;
  // private int solve(StringBuilder sb, String s, int idx, int limit) {
  // if (idx == limit) {
  // if (isPalindrome(sb))
  // return sb.length();
  // return 0;
  // }
  // // skip
  // int skip = solve(sb, s, idx + 1, limit);
  // // take
  // sb.append(s.charAt(idx));
  // int take = solve(sb, s, idx + 1, limit);
  // sb.deleteCharAt(sb.length() - 1);
  // return Math.max(take, skip);
  // }
  // private boolean isPalindrome(StringBuilder sb) {
  // int i = 0, j = sb.length() - 1;
  // while (i <= j) {
  // if (sb.charAt(i) != sb.charAt(j))
  // return false;
  // i++;
  // j--;
  // }
  // return true;
  // }
  // public int longestPalindromeSubseq(String s) {
  // this.memo = new HashMap<>();
  // return solve(new StringBuilder(), s, 0, s.length());
  // }

  private Integer[][] memo;

  private int solve(String s, int i, int j) {

    if (i > j)
      return 0;
    if (this.memo[i][j] != null)
      return this.memo[i][j];
    if (i == j)
      return 1;
    return this.memo[i][j] = (s.charAt(i) == s.charAt(j)) ? 2 + solve(s, i + 1, j - 1)
        : Math.max(solve(s, i + 1, j), solve(s, i, j - 1));
  }

  public int longestPalindromeSubseq(String s) {
    int i = 0, j = s.length() - 1;
    this.memo = new Integer[1001][1001];
    return solve(s, i, j);
  }

}

public class _516_Longest_Palindromic_Subsequence {
  public static void main(String[] args) {
    System.out.println(new Solution().longestPalindromeSubseq(
        "euazbipzncptldue"));
  }
}
