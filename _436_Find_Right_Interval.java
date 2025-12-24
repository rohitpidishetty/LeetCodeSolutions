import java.util.Arrays;

class Solution {

  public int[] findRightInterval(int[][] intervals) {
    int[][] buffer = new int[intervals.length][3];
    int idx = 0;
    for (int[] intrs : intervals) {
      buffer[idx][0] = intrs[0];
      buffer[idx][1] = intrs[1];
      buffer[idx][2] = idx++;
    }
    Arrays.sort(buffer, (a, b) -> a[0] - b[0]);
    int[] result = new int[intervals.length];
    for (int i = 0; i < intervals.length; i++) {
      int l = 0, r = intervals.length - 1, ans = -1;
      while (l <= r) {
        int m = (l + r) / 2;
        if (buffer[m][0] >= intervals[i][1]) {
          ans = buffer[m][2];
          r = m - 1;
        } else l = m + 1;
      }
      result[i] = ans;
    }
    return result;
  }
}

public class _436_Find_Right_Interval {

  public static void main(String[] args) {
    System.out.println(
      Arrays.toString(
        new Solution()
          .findRightInterval(new int[][] { { 3, 4 }, { 2, 3 }, { 1, 2 } })
      )
    );
  }
}
