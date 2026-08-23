import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

  // Version 0
  // private int min;

  // private void solve(
  //   int n,
  //   int[] pSqs,
  //   List<Integer> buffer,
  //   int x,
  //   int start
  // ) {
  //   if (n < 0) return;
  //   if (n == 0) min = Math.min(buffer.size(), min);f
  //   for (int i = start; i < pSqs.length; i++) {
  //     if (pSqs[i] > n) break;
  //     buffer.add(pSqs[i]);
  //     solve(n - pSqs[i], pSqs, buffer, x, i);
  //     buffer.remove(buffer.size() - 1);
  //   }
  // }

  // public int numSquares(int n) {
  //   int[] perfectSquares = {
  //     1,
  //     4,
  //     9,
  //     16,
  //     25,
  //     36,
  //     49,
  //     64,
  //     81,
  //     100,
  //     121,
  //     144,
  //     169,
  //     196,
  //     225,
  //     256,
  //     289,
  //     324,
  //     361,
  //     400,
  //     441,
  //     484,
  //     529,
  //     576,
  //     625,
  //     676,
  //     729,
  //     784,
  //     841,
  //     900,
  //     961,
  //     1024,
  //     1089,
  //     1156,
  //     1225,
  //     1296,
  //     1369,
  //     1444,
  //     1521,
  //     1600,
  //     1681,
  //     1764,
  //     1849,
  //     1936,
  //     2025,
  //     2116,
  //     2209,
  //     2304,
  //     2401,
  //     2500,
  //     2601,
  //     2704,
  //     2809,
  //     2916,
  //     3025,
  //     3136,
  //     3249,
  //     3364,
  //     3481,
  //     3600,
  //     3721,
  //     3844,
  //     3969,
  //     4096,
  //     4225,
  //     4356,
  //     4489,
  //     4624,
  //     4761,
  //     4900,
  //     5041,
  //     5184,
  //     5329,
  //     5476,
  //     5625,
  //     5776,
  //     5929,
  //     6084,
  //     6241,
  //     6400,
  //     6561,
  //     6724,
  //     6889,
  //     7056,
  //     7225,
  //     7396,
  //     7569,
  //     7744,
  //     7921,
  //     8100,
  //     8281,
  //     8464,
  //     8649,
  //     8836,
  //     9025,
  //     9216,
  //     9409,
  //     9604,
  //     9801,
  //     10000,
  //   };
  //   min = Integer.MAX_VALUE;
  //   solve(n, perfectSquares, new ArrayList<>(), n, 0);
  //   return min;
  // }

  // Version 1
  private int[] memo;

  private int solve(int n) {
    if (n == 0) return 0;

    if (memo[n] != -1) return memo[n];
    int min = Integer.MAX_VALUE;
    for (int i = 1; i * i <= n; i++) {
      int inRangePerfectSquare = i * i; // 1 < inRangePerfectSquare <= n
      int count = 1 + solve(n - inRangePerfectSquare);
      min = Math.min(count, min);
    }
    memo[n] = min;
    return min;
  }

  public int numSquares(int n) {
    memo = new int[10001];
    Arrays.fill(memo, -1);
    return solve(n);
  }
}

public class _279_Perfect_Squares {

  public static void main(String[] args) {
    System.out.println(new Solution().numSquares(12));
  }
}
