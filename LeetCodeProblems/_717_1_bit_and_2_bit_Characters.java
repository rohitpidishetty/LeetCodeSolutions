class Solution {

  public boolean isOneBitCharacter(int[] bits) {
    int n = bits.length;
    if (n == 1 && bits[0] == 0) return true;
    int i = 0;
    while (i < n) {
      if (bits[i] == 1) i += 2;
      else i += 1;
      if (i == n - 1) return true;
    }
    return false;
  }
}

public class _717_1_bit_and_2_bit_Characters {

  public static void main(String[] args) {
    System.out.println(new Solution().isOneBitCharacter(new int[] { 1, 0, 0 }));
  }
}
