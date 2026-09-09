class Solution {

  private boolean isPossible(int[] bloomDay, int mid, int m, int k) {
    int consecutive = 0;
    int bouquets = 0;

    for (int bloom : bloomDay) {
      if (bloom <= mid) {
        consecutive++;
        if (consecutive == k) {
          bouquets++;
          consecutive = 0;
        }
      } else consecutive = 0;
    }

    return bouquets >= m;
  }

  public int minDays(int[] bloomDay, int m, int k) {
    int n = bloomDay.length;
    if ((long) m * k > n) return -1;
    int l = Integer.MAX_VALUE;
    int h = 0;
    for (int i = 0; i < n; i++) {
      l = Math.min(l, bloomDay[i]);
      h = Math.max(h, bloomDay[i]);
    }
    while (l <= h) {
      int mid = (l + h) / 2;
      if (isPossible(bloomDay, mid, m, k)) h = mid - 1;
      else l = mid + 1;
    }
    return l;
  }
}

public class _1482_Minimum_Number_of_Days_to_Make_n_Bouquets {

  public static void main(String[] args) {
    System.out.println(
      new Solution().minDays(new int[] { 1, 10, 3, 10, 2 }, 3, 2)
    );
  }
}
