class Solution {

  private int solve(int s, int n, int[] piles, int M) {
    if (s >= n) return 0;
    for (int i = s; i < Math.min(2 * M, n); i++) {
      solve(i + 1, n, piles, Math.max(i + 1, M));
    }
    return 0;
  }

  public int stoneGameII(int[] piles) {
    return solve(0, piles.length, piles, 1);
  }
}

public class _1140_Stone_Game_II {

  public static void main(String[] args) {
    System.out.println(new Solution().stoneGameII(new int[] { 2, 7, 9, 4, 4 }));
  }
}
