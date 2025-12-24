import java.util.*;

class Solution {

  public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
    int idx = 0;
    double[] prev = null;

    int[][] pts = new int[][] { p1, p2, p3, p4 };
    for (int[] pt : pts) {
      double[] buffer = new double[3];
      int id = 0;
      for (int i = 0; i < 4; i++) {
        if (i == idx) continue;
        double dist =
          Math.pow((pts[i][1] - pt[1]), 2) + Math.pow((pts[i][0] - pt[0]), 2);
        buffer[id++] = dist;
      }
      Arrays.sort(buffer);
      if (
        !(buffer[0] > 0 &&
          buffer[0] == buffer[1] &&
          Math.abs(buffer[2] - 2 * buffer[0]) < 1e-6)
      ) return false;
      if (prev == null) prev = buffer;
      else if (!Arrays.equals(prev, buffer)) return false;

      idx++;
    }
    return true;
  }
}

public class _593_Valid_Square {

  public static void main(String[] args) {
    System.out.println(
      new Solution()
        .validSquare(
          new int[] { 0, 0 },
          new int[] { 1, 1 },
          new int[] { 1, 0 },
          new int[] { 0, 1 }
        )
    );
  }
}
