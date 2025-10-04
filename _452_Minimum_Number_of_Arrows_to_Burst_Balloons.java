import java.util.Arrays;

class Solution {

  public int findMinArrowShots(int[][] points) {
    Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
    /**
     * In the worst case we can hit at the end of a balloon,
     * thus on hitting a specific end lets see how many balloons can be burst.
     * For that we just have to continue if the currentBalloon's  start is less than its previousBalloon's end.
     * Else, we need to count++
     */

    int count = 1;
    int prev[] = points[0];
    for (int i = 1; i < points.length; i++) {
      if (points[i][0] <= prev[1]) continue;
      else {
        count++;
        prev = points[i];
      }
    }
    return count;
  }
}

public class _452_Minimum_Number_of_Arrows_to_Burst_Balloons {

  public static void main(String[] args) {
    System.out.println(
      new Solution()
        .findMinArrowShots(
          new int[][] { { 10, 16 }, { 2, 8 }, { 1, 6 }, { 7, 12 } }
        )
    );
  }
}
