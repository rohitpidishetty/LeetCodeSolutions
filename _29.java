import java.util.Arrays;

class Solution {
  private long[] findMaxima(long n, long d) {
    int divisors = 1;
    while ((d << 1) <= n) {
      d <<= 1;
      divisors <<= 1;
    }
    return new long[] { d, divisors };
  }

  public int divide(int dividend, int divisor) {
    if (Integer.MIN_VALUE == dividend && divisor == -1)
      return Integer.MAX_VALUE;
    long num = Math.abs((long) dividend);
    long den = Math.abs((long) divisor);
    boolean sign = (dividend < 0) ^ (divisor < 0);
    int result = 0;
    while (num >= den) {
      long[] res = findMaxima(num, den);
      num -= res[0];
      result += res[1];
    }
    return sign ? -1 * result : result;
  }
}

public class _29 {
  public static void main(String[] args) {
    System.out.println(new Solution().divide(10, 3));
  }
}