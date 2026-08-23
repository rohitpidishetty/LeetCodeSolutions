class Solution {

  public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
    return (
      ((Math.max(rec1[0], rec2[0]) - Math.min(rec1[2], rec2[2])) < 0) &&
      ((Math.max(rec1[1], rec2[1]) - Math.min(rec1[3], rec2[3])) < 0)
    );
  }
}

public class _836_Rectangle_Overlap {

  public static void main(String[] args) {
    System.out.println(
      new Solution().isRectangleOverlap(
        new int[] { 0, 0, 2, 2 },
        new int[] { 1, 1, 3, 3 }
      )
    );
  }
}
