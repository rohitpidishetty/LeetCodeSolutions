import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {

  public int minRefuelStops(int target, int startFuel, int[][] stations) {
    if (target <= startFuel) return 0;
    if (stations.length == 0 || stations[0].length == 0) return -1;
    PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[1] - a[1]);
    int currentFuel = startFuel;
    int n = stations.length;
    int count = 0;
    int i = 0;
    while (currentFuel < target) {
      while (i < n && stations[i][0] <= currentFuel) {
        maxHeap.offer(stations[i++]);
      }
      if (maxHeap.isEmpty()) return -1;
      currentFuel += maxHeap.poll()[1];
      count++;
    }
    return count;
  }
}

public class _871_Minimum_Number_of_Refueling_Stops {

  public static void main(String[] args) {
    System.out.println(
      new Solution().minRefuelStops(
        100,
        10,
        new int[][] { { 10, 60 }, { 20, 30 }, { 30, 30 }, { 60, 40 } }
      )
    );
  }
}
