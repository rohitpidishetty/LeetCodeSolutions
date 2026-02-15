import java.util.Arrays;

class Solution {

  public int[] loudAndRich(int[][] richer, int[] quiet) {
    return null;
  }
}

public class _851_Loud_and_Rich {

  public static void main(String[] args) {
    System.out.println(
      Arrays.toString(
        new Solution().loudAndRich(
          new int[][] {
            { 1, 0 },
            { 2, 1 },
            { 3, 1 },
            { 3, 7 },
            { 4, 3 },
            { 5, 3 },
            { 6, 3 },
          },
          new int[] { 3, 2, 5, 4, 6, 1, 7, 0 }
        )
      )
    );
  }
}
