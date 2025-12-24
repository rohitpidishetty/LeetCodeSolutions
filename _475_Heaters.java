import java.util.Arrays;
import java.util.TreeSet;

class Solution {
  public int findRadius(int[] houses, int[] heaters) {
    Arrays.sort(houses);
    Arrays.sort(heaters);
    int n = houses.length, m = heaters.length;
    int[] leftHeaters = new int[n], rightHeaters = new int[n];
    TreeSet<Integer> limit = new TreeSet<>();
    for (int h : heaters)
      limit.add(h);
    int max = 0;
    for (int i = 0; i < n; i++) {
      Integer l = limit.floor(houses[i]), r = limit.ceiling(houses[i]);
      max = Math.max(max, Math.min(((l == null) ? Integer.MAX_VALUE : houses[i] - l),
          ((r == null) ? Integer.MAX_VALUE : r - houses[i])));
    }
    return max;
  }
}

public class _475_Heaters {
  public static void main(String[] args) {
    System.out
        .println(
            new Solution().findRadius(new int[] { 1, 5, 6, 7, 12, 13 }, new int[] { 3, 9 }));
  }
}
