class Solution {

  public boolean isPowerOfThree(int n) {
    if (n <= 0) return false;
    while (n % 3 == 0) n /= 3;
    return n == 1;
  }
}

public class _326_Power_of_Three {

  public static void main(String[] args) {
    System.out.println(new Solution().isPowerOfThree(8));
  }
}
