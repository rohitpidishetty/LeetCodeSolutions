class Solution {
  public int findPoisonedDuration(int[] timeSeries, int duration) {
    int n = timeSeries.length;
    int totalSeconds = 0;
    int maxSecond = 0;
    for (int i = 0; i < n; i++) {
      if (i > 0) {
        if (timeSeries[i] > maxSecond)
          totalSeconds += duration;
        else
          totalSeconds += timeSeries[i] - timeSeries[i - 1];
      }
      maxSecond = timeSeries[i] + duration;
    }
    totalSeconds += duration;
    return totalSeconds;
  }
}

public class _495_Teemo_Attacking {
  public static void main(String[] args) {
    System.out.println(new Solution().findPoisonedDuration(new int[] { 1, 2 }, 2));
  }
}
