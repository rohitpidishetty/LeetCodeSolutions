class Solution {

  private boolean solve(String s, int i, int j, boolean deleted) {
    while (i <= j) {
      if (s.charAt(i) != s.charAt(j)) {
        if (deleted) return false;
        return solve(s, i + 1, j, true) || solve(s, i, j - 1, true);
      }
      i++;
      j--;
    }
    return true;
  }

  public boolean validPalindrome(String s) {
    int i, j;
    boolean deleted;
    return solve(s, i = 0, j = s.length() - 1, deleted = false);
  }
}

public class _680_Valid_Palindrome_II {

  public static void main(String[] args) {
    System.out.println(new Solution().validPalindrome("abcb"));
  }
}
