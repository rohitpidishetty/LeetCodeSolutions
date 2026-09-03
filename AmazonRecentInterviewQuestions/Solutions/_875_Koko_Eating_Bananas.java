class Solution {

  private boolean isPossible(int k, int[] piles, int h) {
    int timeTaken = 0;
    for (int pile : piles) timeTaken += Math.ceil((double) pile / k);
    return timeTaken <= h;
  }

  public int minEatingSpeed(int[] piles, int h) {
    int lb = 1;
    int ub = 0;
    int n = piles.length;
    for (int i = 0; i < n; i++) ub = Math.max(ub, piles[i]);

    while (lb < ub) {
      int m = (lb + ub) / 2;
      if (isPossible(m, piles, h)) ub = m;
      else lb = m + 1;
    }

    return lb;
  }
}

public class _875_Koko_Eating_Bananas {

  public static void main(String[] args) {
    System.out.println(
      new Solution().minEatingSpeed(new int[] { 3, 6, 7, 11 }, 8)
    );
  }
}
