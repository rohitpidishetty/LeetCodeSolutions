class Solution {

  public String longestPalindrome(String s) {
    int n = s.length();
    int max = 0;
    String res = new String();
    Boolean[][] memo = new Boolean[n + 1][n + 1];
    for (int i = 0; i < n; i++) {
      for (int j = i; j < n; j++) {
        if (isPalindrome(i, j, s, memo)) {
          if (j - i + 1 >= max) {
            res = s.substring(i, j + 1);
            max = j - i + 1;
          }
        }
      }
    }
    return res;
  }

  private boolean isPalindrome(int i, int j, String s, Boolean[][] memo) {
    if (memo[i][j] != null) return memo[i][j];
    if (i >= j) return true;
    if (s.charAt(i) == s.charAt(j)) return memo[i][j] = isPalindrome(
      i + 1,
      j - 1,
      s,
      memo
    );
    return false;
  }
}

public class _5_Longest_Palindromic_Substring {

  public static void main(String[] args) {
    System.out.println(new Solution().longestPalindrome("babad"));
  }
}
