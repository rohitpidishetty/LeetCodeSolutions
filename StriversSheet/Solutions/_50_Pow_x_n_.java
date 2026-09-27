class Solution {

  private double pow(double x, long n) {
    if (n == 0) return 1;
    if (n < 0) return pow(1 / x, -n);
    return (n % 2) == 0 ? pow(x * x, n / 2) : x * pow(x * x, (n - 1) / 2);
  }

  public double myPow(double x, int n) {
    return pow(x, (long) n);
  }
}

public class _50_Pow_x_n_ {

  public static void main(String[] args) {
    System.out.println(new Solution().myPow(2, 5));
  }
}
