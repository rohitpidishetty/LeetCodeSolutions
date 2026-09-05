class Solution {

  public int mySqrt(int x) {
    if (x < 2) return x;
    int l = 1;
    int h = x / 2;
    while (l <= h) {
      double m = (l + h) / 2;
      double sub = m * m;
      if (sub == x) return (int) m;
      else if (sub < x) l = (int) m + 1;
      else h = (int) m - 1;
    }
    return h;
  }
}

public class _69_Sqrt_x_ {

  public static void main(String[] args) {
    System.out.println(new Solution().mySqrt(8));
  }
}
