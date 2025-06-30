public class IntegerReverse {
  private int i32Reverse(int n) {
    int unit = 0;
    int sign = n < 0 ? -1 : 1;
    n = Math.abs(n);
    int finalNumber = 0;
    while (n > 0) {
      unit = (n % 10);
      n /= 10;
      if (finalNumber > (Integer.MAX_VALUE / 5) && finalNumber < (Integer.MAX_VALUE / 5))
        return 0;
      finalNumber = (finalNumber * 10) + unit;
    }
    return sign * finalNumber;
  }

  public static void main(String[] args) {
    System.out.println(new IntegerReverse().i32Reverse(-2147483412));
  }
}