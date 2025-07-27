class Solution {

  public boolean isUgly(int n) {
    if (n <= 0) return false;
    int factors[] = new int[] { 2, 3, 5 };
    for (int factor : factors) {
      while (n % factor == 0) {
        n /= factor;
      }
    }

    return n == 1;
  }
}

public class _263_Ugly_Number {

  public static void main(String[] args) {
    // An ugly number is a positive integer which does not have a prime factor other than 2, 3, and 5.
    // A number that has only 2,3,5 as prime factors are ugly
    System.out.println(new Solution().isUgly(6));
  }
}
