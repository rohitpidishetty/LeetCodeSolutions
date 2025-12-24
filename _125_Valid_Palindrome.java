class Solution {
  public boolean isPalindrome(String s) {
    int i = 0;
    char[] tokens = s.toCharArray();
    StringBuilder final_string = new StringBuilder();
    int j = -1;
    while (i < tokens.length) {
      char ch = tokens[i];
      if (ch >= 65 && ch <= 90) {
        final_string.append((char) (ch + 32));
        j++;
      } else if (ch >= 97 && ch <= 122 || ch >= 48 && ch <= 57) {
        final_string.append(ch);
        j++;
      }
      i++;
    }
    tokens = final_string.toString().toCharArray();
    i = 0;
    while (i < j) {
      if (tokens[i] != tokens[j])
        return false;
      i++;
      j--;
    }
    return true;
  }
}

public class _125_Valid_Palindrome {
  public static void main(String[] args) {
    System.out.println(new Solution().isPalindrome("0P"));
  }
}