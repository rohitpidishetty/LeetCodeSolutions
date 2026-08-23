class Solution {

  public int[] countBits(int n) {
    /**
     * 0: 0000
     * 1: 0001
     * 2: 0010
     * 3: 0011
     * 4: 0100
     * 5: 0101
     * 6: 0110
     * 7: 0111
     */
    if (n == 0) return new int[] { 0 };
    int setBits[] = new int[n + 1];
    setBits[0] = 0;
    setBits[1] = 1;
    for (int i = 2; i <= n; i++) setBits[i] = (i % 2 != 0)
      ? setBits[i - 1] + 1
      : setBits[i / 2];
    return setBits;
  }
}

public class _338_Counting_Bits {

  public static void main(String[] args) {
    System.out.println(new Solution().countBits(5));
  }
}
