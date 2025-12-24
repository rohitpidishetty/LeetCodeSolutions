class Solution {

  public boolean isPowerOfTwo(int n) {
    int bitPosition = (int) (Math.log(n) / Math.log(2));
    int bit = 1 << bitPosition;
    return n == bit;
  }
}

public class _231_Power_of_Two {

  public static void main(String[] args) {
    System.out.println(new Solution().isPowerOfTwo(32));
  }
}
