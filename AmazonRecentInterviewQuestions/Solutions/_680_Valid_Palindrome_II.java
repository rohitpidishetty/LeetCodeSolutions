class Solution {

  private boolean isPalindrom(int i, int j, String s, boolean deleted) {
    while (i < j) {
      if (s.charAt(i) != s.charAt(j)) {
        if (deleted) return false;
        return isPalindrom(i, j - 1, s, true) || isPalindrom(i + 1, j, s, true);
      }
      i++;
      j--;
    }
    return true;
  }

  public boolean validPalindrome(String s) {
    return isPalindrom(0, s.length() - 1, s, false);
  }
}

public class _680_Valid_Palindrome_II {

  public static void main(String[] args) {
    System.out.println(new Solution().validPalindrome("abca"));
  }
}
