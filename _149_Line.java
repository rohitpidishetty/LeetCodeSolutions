import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {

  private String getPointName(int[] point_config) {
    String point_name = "(" + point_config[0] + "," + point_config[1] + ")";
    return point_name;
  }

  public int maxPoints(int[][] points) {
    Map<String, Integer> cord_dist = new HashMap<>();
    int MAX = Integer.MIN_VALUE;
    for (int[] point : points)
      cord_dist.put(getPointName(point), 0);

    for (int i = 0; i < points.length; i++) {
      Map<Double, Integer> count = new HashMap<>();
      int max = Integer.MIN_VALUE;
      for (int j = 0; j < points.length; j++) {
        if (i != j) {
          /**
           * m = (y2 - y1) / (x2 - x1)
           */
          int dY = (points[j][1] - points[i][1]);
          int dX = (points[j][0] - points[i][0]);
          double slope = (dX == 0 || dY == 0) ? (dX == 0 ? -0.0d : 0.0d) : ((double) dY / (double) dX);
          count.put(slope, count.getOrDefault(slope, 0) + 1);
          max = Math.max(max, count.get(slope));
        }
      }
      MAX = Math.max(MAX, max);
    }

    return (MAX != Integer.MIN_VALUE ? MAX : 0) + 1;
  }
}

public class _149_Line {
  public static void main(String[] args) {
    System.out
        .println(new Solution().maxPoints(new int[][] { { 1, 1 }, { 3, 2 }, { 5, 3 }, { 4, 1 }, { 2, 3 }, { 1, 4 } }));
  }
}
