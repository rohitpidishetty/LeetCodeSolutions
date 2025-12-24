class Solution {

  public boolean isPowerOfFour(int n) {
    if (n == 1) return true;
    if (n < 4) return false;
    while (n % 4 == 0) n /= 4;
    return n == 1;
  }
}

public class _342_Power_of_Four {

  public static void main(String[] args) {
    System.out.println(new Solution().isPowerOfFour(17));
  }
}
