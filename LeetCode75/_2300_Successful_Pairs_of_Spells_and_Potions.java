import java.util.Arrays;

class Solution {

  public int[] successfulPairs(int[] spells, int[] potions, long success) {
    Arrays.sort(potions);
    int n = spells.length;
    int size = potions.length - 1;
    int res[] = new int[n];
    for (int i = 0; i < n; i++) {
      int l = 0;
      int h = size;
      while (l <= h) {
        int mid = (l + (h - l) / 2);
        if ((long) potions[mid] * spells[i] >= success) h = mid - 1;
        else l = mid + 1;
      }
      res[i] = size - h;
    }
    return res;
  }
}

public class _2300_Successful_Pairs_of_Spells_and_Potions {

  public static void main(String[] args) {
    System.out.println(
      Arrays.toString(
        new Solution().successfulPairs(
          new int[] { 5, 1, 3 },
          new int[] { 1, 2, 3, 4, 5 },
          7
        )
      )
    );
  }
}
