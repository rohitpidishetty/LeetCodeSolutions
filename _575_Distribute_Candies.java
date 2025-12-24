
import java.util.Arrays;

class Solution {
  public int distributeCandies(int[] candyType) {
    Arrays.sort(candyType);
    int unq = 0;
    for (int i = 0; i < candyType.length; i++) {
      if (i > 0 && candyType[i] == candyType[i - 1])
        continue;
      unq++;
    }
    return Math.min(unq, candyType.length / 2);
  }
}

public class _575_Distribute_Candies {
  public static void main(String[] args) {
    System.out.println(new Solution().distributeCandies(new int[] { 1, 1, 2, 2, 3, 3 }));
  }
}