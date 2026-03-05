class Solution {

  private long gcd(long a, long b) {
    if (a < b) return gcd(b, a);
    else if (b == 0) return a;
    else return gcd(b, a % b);
  }

  public int nthMagicalNumber(int n, int a, int b) {
    long mod = 1_000_000_007;

    long lcm = ((long) a * b) / gcd(a, b);

    long left = 1;
    long right = (long) n * Math.min(a, b);

    while (left < right) {
      long mid = (left + right) / 2;
      long count = (mid / a) + (mid / b) - (mid / lcm);
      if (count < n) left = mid + 1;
      else right = mid;
    }

    return (int) (left % mod);
  }
}

public class _878_Nth_Magical_Number {

  public static void main(String[] args) {
    System.out.println(new Solution().nthMagicalNumber(4, 2, 3));
  }
}
