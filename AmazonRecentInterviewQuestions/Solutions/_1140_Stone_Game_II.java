import java.util.Arrays;

class Solution {

  private int solve(
    int alice,
    int M,
    int[] piles,
    int idx,
    int n,
    int memo[][][]
  ) {
    if (idx >= n) return 0;
    if (memo[alice][idx][M] != -1) return memo[alice][idx][M];
    int stones = 0;
    int res = alice == 1 ? 0 : Integer.MAX_VALUE;
    for (int x = 1; x <= Math.min(2 * M, n - idx); x++) {
      stones += piles[idx + x - 1];
      if (alice == 1) {
        // solve for next turn, i.e., bob's turn
        res = Math.max(
          res,
          stones + solve(0, Math.max(M, x), piles, idx + x, n, memo)
        );
      } else {
        // solve for next turn, i.e., alice's turn
        res = Math.min(solve(1, Math.max(M, x), piles, idx + x, n, memo), res);
      }
    }
    return memo[alice][idx][M] = res;
  }

  public int stoneGameII(int[] piles) {
    // M = 1 (Initially)
    int memo[][][] = new int[2][101][101];
    for (int[][] mem : memo) for (int m[] : mem) Arrays.fill(m, -1);
    return solve(1, 1, piles, 0, piles.length, memo);
  }
}

public class _1140_Stone_Game_II {

  public static void main(String[] args) {
    System.out.println(new Solution().stoneGameII(new int[] { 2, 7, 9, 4, 4 }));
  }
}
