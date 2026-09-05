class Solution {

  private boolean isPossible(int cap, int weights[], int days) {
    int totalDays = 0;
    int sum = 0;
    for (int i = 0; i < weights.length; i++) {
      if (sum + weights[i] > cap) {
        sum = weights[i];
        totalDays++;
      } else sum += weights[i];
    }
    return (totalDays + 1) <= days;
  }

  public int shipWithinDays(int[] weights, int days) {
    int l = 0;
    int h = 0;
    for (int i = 0; i < weights.length; i++) {
      l = Math.max(l, weights[i]);
      h += weights[i];
    }

    while (l < h) {
      int m = (l + h) / 2;
      if (isPossible(m, weights, days)) h = m;
      else l = m + 1;
    }
    return l;
  }
}

public class _1011_Capacity_To_Ship_Packages_Within_D_Days {

  public static void main(String[] args) {
    System.out.println(
      new Solution().shipWithinDays(
        new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 },
        5
      )
    );
  }
}
