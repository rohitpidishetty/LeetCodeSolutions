class Solution {

  private boolean isPalindrome(int i, int j, String s, Boolean[][] memo) {
    if (i >= j) return true;
    if (memo[i][j] != null) return memo[i][j];
    if (s.charAt(i) == s.charAt(j)) return memo[i][j] = isPalindrome(
      i + 1,
      j - 1,
      s,
      memo
    );
    return false;
  }

  private String solve(String s, int n, Boolean[][] memo) {
    int max = 0;
    String str = new String();
    for (int i = 0; i < n; i++) {
      for (int j = i; j < n; j++) {
        if (isPalindrome(i, j, s, memo)) {
          if ((j - i + 1) > max) {
            max = (j - i + 1);
            str = s.substring(i, j + 1);
          }
        }
      }
    }
    return str;
  }

  public String longestPalindrome(String s) {
    int n = s.length();
    Boolean[][] memo = new Boolean[n][n];
    return solve(s, n, memo);
  }
}

public class _5_Longest_Palindromic_Substring {

  public static void main(String[] args) {
    System.out.println(new Solution().longestPalindrome("babad"));
  }
}
