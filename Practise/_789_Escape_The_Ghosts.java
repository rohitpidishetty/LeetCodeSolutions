class Solution {

  public boolean escapeGhosts(int[][] ghosts, int[] target) {
    //  Manhattan distance : |x2-x1| + |y2-y1|
    int playersMd = Math.abs(target[0] - 0) + Math.abs(target[1] - 0);
    for (int[] g : ghosts) {
      int gnMd = Math.abs(target[0] - g[0]) + Math.abs(target[1] - g[1]);
      if (gnMd < playersMd) return false;
    }
    return true;
  }
}

public class _789_Escape_The_Ghosts {

  public static void main(String[] args) {
    System.out.println(
      new Solution()
        .escapeGhosts(new int[] { { 1, 0 }, { 0, 3 } }, new int[] { 0, 1 })
    );
  }
}
