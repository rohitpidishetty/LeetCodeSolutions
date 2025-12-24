import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
  public int findMinDifference(List<String> timePoints) {
    int[] timeStamps = new int[timePoints.size()];
    int idx[] = { 0 };
    timePoints.forEach(e -> {
      String[] buff = e.split(":");
      int time_stamp = Integer.parseInt(buff[0]);
      int min = Integer.parseInt(buff[1]);
      timeStamps[idx[0]++] = time_stamp * 60 + min;
    });
    Arrays.sort(timeStamps);
    Map<String, Integer> diff = new HashMap<>();
    int min = Integer.MAX_VALUE;
    for (int i = 1; i < timeStamps.length; i++)
      min = Math.min(min, timeStamps[i] - timeStamps[i - 1]);
    return Math.min(min, (1440 - timeStamps[timeStamps.length - 1]) + timeStamps[0]);
  }

}

public class _539_Minimum_Time_Difference {
  public static void main(String[] args) {
    System.out.println(new Solution().findMinDifference(new ArrayList<>(Arrays.asList("23:59", "00:00"))));
  }
}