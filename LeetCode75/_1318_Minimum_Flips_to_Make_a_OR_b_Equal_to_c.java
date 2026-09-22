class Solution {

  public int minFlips(int a, int b, int c) {
    int changes = 0;
    for (int i = 0; i < 32; i++) {
      int aBit = ((1 << i) & a) == 0 ? 0 : 1;
      int bBit = ((1 << i) & b) == 0 ? 0 : 1;
      int cBit = ((1 << i) & c) == 0 ? 0 : 1;

      if ((aBit | bBit) == cBit) continue;
      if (
        (((aBit == 0 ? 1 : 0) | bBit) == cBit) ||
        ((aBit) | (bBit == 0 ? 1 : 0)) == cBit
      ) changes++;
      else changes += 2;
    }
    return changes;
  }
}

public class _1318_Minimum_Flips_to_Make_a_OR_b_Equal_to_c {

  public static void main(String[] args) {
    System.out.println(new Solution().minFlips(2, 6, 5));
  }
}
