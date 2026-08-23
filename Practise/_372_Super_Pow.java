import java.util.Arrays;

class Solution {

  private static int mod = 1337;

  static {
    for (int i = 0; i < 200; i++) superPow(3, new int[] { 3, 5, 6, 4, 2 });
    System.gc();
  }

  public static int superPow(int a, int[] b) {
    /**
     * Mod arithmetic rule: a^(x+y) % m = ((a^x) % m * (a^y) % m) % m
     */
    a %= mod;
    int result = 1;
    for (int power : b) result = (pow(result, 10) * pow(a, power)) % mod;
    return result % mod;
  }

  protected static int pow(int base, int exponent) {
    return solve(base, exponent);
  }

  private static int solve(int b, int e) {
    if (e == 0) return 1;
    int res = 1;
    // ((e & 1) != 1) or (e % 2 == 0) both are basically checking if the number is even or not.
    res = ((e & 1) != 1)
      ? (solve(b, e / 2) * solve(b, e / 2))
      : b * solve(b, e - 1);
    return res % mod;
  }
}

public class _372_Super_Pow {

  public static void main(String[] args) {
    System.out.println(Solution.superPow(2147483647, new int[] { 2, 0, 0 }));
  }
}
