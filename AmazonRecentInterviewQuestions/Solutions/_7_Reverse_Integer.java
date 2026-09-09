class Solution {

  public int reverse(int x) {
    int num = 0;
    byte sign = 1;
    if (x < 0) sign = -1;
    x = Math.abs(x);

    while (x > 0) {
      int digit = x % 10;
      if (
        num > Integer.MAX_VALUE / 10 ||
        (num == Integer.MAX_VALUE / 10 && digit > 7)
      ) return 0;

      num *= 10;
      num += (x % 10);
      x /= 10;
    }

    return sign * num;
  }
}

public class _7_Reverse_Integer {

  public static void main(String[] args) {
    System.out.println(new Solution().reverse(-1232));
  }
}
