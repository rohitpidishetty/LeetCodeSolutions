import java.util.Arrays;

class Solution {

  public int eraseOverlapIntervals(int[][] intervals) {
    Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
    int total = 0;
    int s = intervals[0][0];
    int e = intervals[0][1];
    for (int i = 1; i < intervals.length; i++) {
      if (intervals[i][0] < e) {
        total++;
        e = Math.min(e, intervals[i][1]);
        continue;
      }

      e = intervals[i][1];
    }
    return total;
  }
}

public class _435_Non_overlapping_Intervals {

  public static void main(String[] args) {
    System.out.println(
      new Solution().eraseOverlapIntervals(
        new int[][] { { 1, 100 }, { 11, 22 }, { 1, 11 }, { 2, 12 } }
      )
    );
  }
}
