class Solution {

  private boolean eat(int[] piles, int m, int h) {
    int hours = 0;
    for (int pile : piles) {
      hours += pile / m;
      if (pile % m != 0) hours++;
    }
    return hours <= h;
  }

  public int minEatingSpeed(int[] piles, int h) {
    int l = 1;
    int r = 0;
    for (int pile : piles) r = Math.max(r, pile);
    while (l < r) {
      int m = l + (r - l) / 2;
      boolean canEat = eat(piles, m, h);
      if (canEat) r = m;
      else l = m + 1;
    }
    return l;
  }
}

public class _875_Koko_Eating_Bananas {

  public static void main(String[] args) {
    System.out.println(
      new Solution().minEatingSpeed(new int[] { 30, 11, 23, 4, 20 }, 5)
    );
    System.out.println(
      new Solution().minEatingSpeed(
        new int[] { 805306368, 805306368, 805306368 },
        1000000000
      )
    );
  }
}
