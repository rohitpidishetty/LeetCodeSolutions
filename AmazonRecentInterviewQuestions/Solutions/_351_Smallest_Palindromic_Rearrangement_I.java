import java.util.Arrays;

class Solution {

  public String smallestPalindrome(String s) {
    int n = s.length();
    int m = n / 2;

    char[] half = s.substring(0, m).toCharArray();

    Arrays.sort(half);

    String firstHalf = new String(half);
    String secondHalf = new StringBuilder(firstHalf).reverse().toString();

    if (n % 2 == 1) return firstHalf + s.charAt(m) + secondHalf;

    return firstHalf + secondHalf;
  }
}

public class _351_Smallest_Palindromic_Rearrangement_I {

  public static void main(String[] args) {
    System.out.println(new Solution().smallestPalindrome("daccad"));
  }
}
