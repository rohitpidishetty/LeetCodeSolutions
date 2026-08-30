import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {

  public int totalMeetings(int[] starts, int[] ends, int N) {
    int[][] durations = new int[N][2];
    for (int i = 0; i < N; i++) durations[i] = new int[] { starts[i], ends[i] };
    Arrays.sort(durations, (a, b) ->
      (a[1] != b[1]) ? a[1] - b[1] : a[0] - b[0]
    );

    int s = durations[0][0];
    int e = durations[0][1];
    int total = 1;

    for (int i = 1; i < N; i++) {
      int curr_s = durations[i][0];
      int curr_e = durations[i][1];
      if (Math.max(s, curr_s) <= Math.min(e, curr_e)) continue;
      e = curr_e;
      total++;
    }
    return total;
  }
}

public class _N_meetings_in_one_room {

  public static void main(String[] args) {
    System.out.println(
      new Solution().totalMeetings(
        new int[] { 2, 1, 6, 4, 8, 5 },
        new int[] { 3, 5, 7, 6, 9, 8 },
        6
      )
    );
  }
}
