class Solution {

  public int rotatedDigits(int n) {
    int count = 0;
    for (int i = 1; i <= n; i++) {
      if (isGood(i)) count++;
    }
    return count;
  }

  private boolean isGood(int number) {
    boolean status = false;
    while (number != 0) {
      int digit = number % 10;
      if (digit == 3 || digit == 4 || digit == 7) return false;
      if (digit == 2 || digit == 5 || digit == 6 || digit == 9) status = true;
      number /= 10;
    }
    return status;
  }
}

public class _788_Rotated_Digits {

  public static void main(String[] args) {
    System.out.println(new Solution().rotatedDigits(857));
  }
}
