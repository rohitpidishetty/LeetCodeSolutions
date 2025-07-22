import java.util.Arrays;

class Solution {

  private int[] getLPSArray(String pattern) {
    int n = pattern.length();
    int[] lps_array = new int[n];
    lps_array[0] = 0;
    int position = 1;
    int length = 0;
    while (position < n) {
      if (pattern.charAt(length) == pattern.charAt(position)) {
        length++; // Increment by 1
        lps_array[position] = length;
        position++;
      } else {
        if (length == 0) {
          lps_array[position] = 0;
          position++;
        } else length = lps_array[length - 1]; // Doing this to compare the char with all the previously calculated lengths of chars.
      }
    }
    return lps_array;
  }

  public String shortestPalindrome(String s) {
    int lps_array[] = getLPSArray(
      s + "-" + new StringBuilder(s).reverse().toString()
    );
    int pointer = lps_array[lps_array.length - 1];
    return new StringBuilder(s.substring(pointer, s.length())).reverse() + s;
  }
}

public class _214_Shortest_Palindrome {

  public static void main(String[] args) {
    System.out.println(new Solution().shortestPalindrome("abcd"));
  }
}
