class Solution {

  public boolean isPowerOfThree(int n) {
    if (n < 0) return false;
    int first_bit = ((n & (1 << 0)) == 0) ? 0 : 1;
    int second_bit = ((n & (1 << 1)) == 0) ? 0 : 1;
    int third_bit = ((n & (1 << 2)) == 0) ? 0 : 1;
    if (
      first_bit == 1 && (second_bit == 0 || second_bit == 1) && third_bit == 0
    ) return true;
    return false;
  }
}

public class _326_Power_of_Three {

  public static void main(String[] args) {
    System.out.println(new Solution().isPowerOfThree(8));
  }
}
