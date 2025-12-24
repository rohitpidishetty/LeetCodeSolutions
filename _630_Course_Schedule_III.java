import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {

  public int scheduleCourse(int[][] courses) {
    // Goal: Maximize the number of courses that can be taken in the given amount of time.
    Arrays.sort(courses, (a, b) -> Integer.compare(a[1], b[1]));
    int time = 0;
    PriorityQueue<int[]> pursuable = new PriorityQueue<>((a, b) ->
      Integer.compare(b[0], a[0])
    );
    for (int pointer = 0; pointer < courses.length; pointer++) {
      if (time + courses[pointer][0] <= courses[pointer][1]) {
        pursuable.offer(courses[pointer]);
        time += courses[pointer][0];
      } else {
        if (pursuable.size() == 0) continue;
        int top = pursuable.peek()[0];
        if (courses[pointer][0] > top) continue;
        while (time + courses[pointer][0] > courses[pointer][1]) {
          time -= top;
          pursuable.poll();
        }
        pursuable.offer(courses[pointer]);
        time += courses[pointer][0];
      }
    }
    return pursuable.size();
  }
}

public class _630_Course_Schedule_III {

  public static void main(String[] args) {
    System.out.println(
      new Solution()
        .scheduleCourse(
          new int[][] {
            { 100, 200 },
            { 200, 1300 },
            { 1000, 1250 },
            { 2000, 3200 },
          }
        )
    );
  }
}
