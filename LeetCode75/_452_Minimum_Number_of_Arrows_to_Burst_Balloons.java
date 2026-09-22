import java.util.Arrays;

class Solution {

  public int findMinArrowShots(int[][] points) {
    Arrays.sort(points, (a, b) -> a[0] - b[0]);
    int arrows = 1;
    int s = points[0][0];
    int e = points[0][1];
    for (int i = 1; i < points.length; i++) {
      int S = Math.max(s, points[i][0]);
      int E = Math.min(e, points[i][1]);
      if (S <= E) {
        // Over lapped
        s = S;
        e = E;
        continue;
      }
      arrows++;
      s = points[i][0];
      e = points[i][1];
    }
    return arrows;
  }
}

public class _452_Minimum_Number_of_Arrows_to_Burst_Balloons {

  public static void main(String[] args) {
    System.out.println(
      new Solution().findMinArrowShots(
        new int[][] { { 10, 16 }, { 2, 8 }, { 1, 6 }, { 7, 12 } }
      )
    );
  }
}
