import java.util.*;

class Solution {

  public int findLongestChain(int[][] pairs) {
    Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
    int count = 0;
    int[] previous = null;

    for (int i = 0; i < pairs.length; i++) {
      if (previous != null && pairs[i][0] <= previous[1]) continue;
      previous = pairs[i];
      count++;
    }
    return count;
  }
}

public class _646_Maximum_Length_of_Pair_Chain {

  public static void main(String[] args) {
    System.out.println(
      new Solution()
        .findLongestChain(new int[][] { { 1, 2 }, { 2, 3 }, { 3, 4 } })
    );
  }
}
