class Solution {

  public int maxCount(int m, int n, int[][] ops) {
    if (ops.length == 0) return m * n;
    int min_x = Integer.MAX_VALUE, min_y = min_x;
    for (int[] op : ops) {
      min_x = Math.min(min_x, op[0]);
      min_y = Math.min(min_y, op[1]);
    }

    return min_x * min_y;
  }
}

public class _598_Range_Addition_II {

  public static void main(String[] args) {
    System.out.println(
      new Solution().maxCount(3, 3, new int[][] { { 2, 2 }, { 3, 3 } })
    );
  }
}
