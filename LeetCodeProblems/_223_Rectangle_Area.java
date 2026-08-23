class Solution {

  public int computeArea(
    int ax1,
    int ay1,
    int ax2,
    int ay2,
    int bx1,
    int by1,
    int bx2,
    int by2
  ) {
    int fx1 = ax1;
    int fy1 = ay1;
    int fx2 = ax2;
    int fy2 = ay2;
    int sx1 = bx1;
    int sy1 = by1;
    int sx2 = bx2;
    int sy2 = by2;

    int r1b = fx2 - fx1; // Rectangle 1 base
    int r1h = fy2 - fy1; // Rectangle 1 height
    int r2b = sx2 - sx1; // Rectangle 2 base
    int r2h = sy2 - sy1; // Rectangle 2 height

    // Finding over-lap
    int discX1 = Math.max(fx1, sx1);
    int discX2 = Math.min(fx2, sx2);
    int discY1 = Math.max(fy1, sy1);
    int discY2 = Math.min(fy2, sy2);

    int discB = discX2 - discX1; // Overlapped rectangle base
    int discH = discY2 - discY1; // Overlapped rectangle height

    // If over-lapping then obviously it will have base and height, thus (> 0).
    int discard = 0;
    if (discB > 0 && discH > 0) discard = discB * discH;

    return (r1h * r1b) + (r2h * r2b) - discard;
  }
}

public class _223_Rectangle_Area {

  public static void main(String[] args) {
    System.out.println(new Solution().computeArea(-3, 0, 3, 4, 0, -1, 9, 2));
  }
}
