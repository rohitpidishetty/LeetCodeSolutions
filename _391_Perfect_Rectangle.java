import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

class Solution {

  class point {

    private int x_coord;
    private int y_coord;

    point(int x, int y) {
      x_coord = x;
      y_coord = y;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (!(o instanceof point)) return false;
      point p = (point) o;
      return x_coord == p.x_coord && y_coord == p.y_coord;
    }

    @Override
    public int hashCode() {
      return Objects.hash(x_coord, y_coord);
    }

    @Override
    public String toString() {
      return "(" + x_coord + "," + y_coord + ")";
    }
  }

  public boolean isRectangleCover(int[][] rectangles) {
    Set<point> final_rectangle_points = new HashSet<>();
    int minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE;
    int maxX = Integer.MIN_VALUE, maxY = Integer.MIN_VALUE;
    int totalArea = 0;

    for (int[] rect : rectangles) {
      int x_i = rect[0], y_i = rect[1], a_i = rect[2], b_i = rect[3];
      totalArea += (a_i - x_i) * (b_i - y_i);

      minX = Math.min(minX, x_i);
      minY = Math.min(minY, y_i);
      maxX = Math.max(maxX, a_i);
      maxY = Math.max(maxY, b_i);
      point points[] = {
        new point(x_i, y_i),
        new point(a_i, b_i),
        new point(x_i, b_i),
        new point(a_i, y_i),
      };

      for (point p : points) {
        if (final_rectangle_points.contains(p)) {
          final_rectangle_points.remove(p); // removing over-lap
        } else final_rectangle_points.add(p);
      }
    }

    int expectedArea = (maxX - minX) * (maxY - minY);

    if (
      totalArea != expectedArea || final_rectangle_points.size() != 4
    ) return false;

    if (
      !final_rectangle_points.contains(new point(minX, minY)) ||
      !final_rectangle_points.contains(new point(minX, maxY)) ||
      !final_rectangle_points.contains(new point(maxX, minY)) ||
      !final_rectangle_points.contains(new point(maxX, maxY))
    ) return false;
    return true;
  }
}

public class _391_Perfect_Rectangle {

  public static void main(String[] args) {
    System.out.println(
      new Solution()
        .isRectangleCover(
          new int[][] {
            { 1, 1, 3, 3 },
            { 3, 1, 4, 2 },
            { 3, 2, 4, 4 },
            { 1, 3, 2, 4 },
            { 2, 3, 3, 4 },
          }
        )
    );
  }
}
