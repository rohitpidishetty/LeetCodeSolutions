class Solution {

  public boolean reachingPoints(int sx, int sy, int tx, int ty) {
    if (tx < sx || ty < sy) return false;
    if (sx == tx && sy == ty) return true;
    return tx > ty
      ? (ty > sy ? reachingPoints(sx, sy, tx % ty, ty) : (tx - sx) % ty == 0)
      : (tx > sx ? reachingPoints(sx, sy, tx, ty % tx) : (ty - sy) % tx == 0);
  }
}

public class _780_Reaching_Points {

  public static void main(String[] args) {
    System.out.println(new Solution().reachingPoints(1, 1, 3, 5));
  }
}
