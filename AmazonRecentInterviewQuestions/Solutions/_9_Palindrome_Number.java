class Solution {

  public boolean isPalindrome(int x) {
    if (x < 0) return false;
    int palindrome = 0;
    int num = x;
    while (x > 0) {
      palindrome *= 10;
      palindrome += (x % 10);
      x /= 10;
    }
    return palindrome == num;
  }
}

public class _9_Palindrome_Number {

  public static void main(String[] args) {
    System.out.println(new Solution().isPalindrome(101));
  }
}
