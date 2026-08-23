class Solution {

  private boolean dfs(
    int as,
    int bs,
    int l,
    int r,
    int piles[],
    boolean alicesTurn
  ) {
    if (r < l) {
      System.out.println(as + " " + bs);
      return as > bs;
    }
    if (alicesTurn) {
      if (piles[l] >= piles[r]) {
        if (dfs(as + piles[l], bs, l + 1, r, piles, false)) return true;
      } else if (dfs(as + piles[r], bs, l, r - 1, piles, false)) return true;
    } else {
      if (piles[l] >= piles[r]) {
        if (dfs(as, bs + piles[l], l + 1, r, piles, true)) return true;
      } else if (dfs(as, bs + piles[r], l, r - 1, piles, true)) return true;
    }
    return false;
  }

  public boolean stoneGame(int[] piles) {
    int aliceScore = 0;
    int bobScore = 0;
    return (
      dfs(aliceScore, bobScore, 0, piles.length - 1, piles, true) ||
      dfs(aliceScore, bobScore, 0, piles.length - 1, piles, false)
    );
  }
}

public class _877_Stone_Game {

  public static void main(String[] args) {
    System.out.println(new Solution().stoneGame(new int[] { 5, 3, 4, 5 }));
    System.out.println(new Solution().stoneGame(new int[] { 3, 7, 2, 3 }));
  }
}
