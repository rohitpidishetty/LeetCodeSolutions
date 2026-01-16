import java.util.Arrays;

class Solution {

  Double[][] memo;

  private double solve(int p, int qr, int qg) {
    if (qr < qg || qr < 0 || qg < 0) return 0d;
    if (qr == 0 && qg == 0) return p;

    if (this.memo[qr][qg] != null) return this.memo[qr][qg];

    return this.memo[qr][qg] =
      Math.max(0d, ((solve(p, qr - 1, qg - 1) - 1) / 2.0)) +
      Math.max(0d, (((solve(p, qr - 1, qg)) - 1) / 2.0));
  }

  public double champagneTower(int poured, int query_row, int query_glass) {
    this.memo = new Double[101][101];
    return Math.min(1.0, solve(poured, query_row, query_glass));
  }
}

public class _799_Champagne_Tower {

  public static void main(String[] args) {
    System.out.println(new Solution().champagneTower(2, 1, 1));
    System.out.println(new Solution().champagneTower(1, 1, 1));
    System.out.println(new Solution().champagneTower(5, 2, 2));
    System.out.println(new Solution().champagneTower(100000009, 33, 17));
  }
}
