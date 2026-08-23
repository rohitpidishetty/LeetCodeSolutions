import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {

  public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
    int idx = 0;
    int aliceTotal = 0;
    int bobTotal = 0;
    for (int as : aliceSizes) aliceTotal += as;
    Map<Integer, Integer> map = new HashMap<>();
    for (int bs : bobSizes) {
      bobTotal += bs;
      map.put(bs, idx++);
    }
    int each = (aliceTotal + bobTotal) / 2;
    for (int i = 0; i < aliceSizes.length; i++) {
      int findThisInBob = each - (aliceTotal - aliceSizes[i]);
      if (map.containsKey(findThisInBob)) return new int[] {
        aliceSizes[i],
        bobSizes[map.get(findThisInBob)],
      };
    }

    return null;
  }
}

public class _888_Fair_Candy_Swap {

  public static void main(String[] args) {
    System.out.println(
      Arrays.toString(
        new Solution().fairCandySwap(new int[] { 1, 2 }, new int[] { 2, 3 })
      )
    );
  }
}
