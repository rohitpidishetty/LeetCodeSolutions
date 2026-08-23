class Solution {

  // you need treat n as an unsigned value
  public int reverseBits(int n) {
    int i = 0;
    int number = 0;
    while (i < 32) {
      number += ((n & (1 << i)) > 0 ? 1 : 0) << (31 - i);
      i++;
    }
    return number;
  }
}

public class _190_Reverse_Bits {

  public static void main(String[] args) {
    System.out.println(new Solution().reverseBits(43261596));
  }
}
