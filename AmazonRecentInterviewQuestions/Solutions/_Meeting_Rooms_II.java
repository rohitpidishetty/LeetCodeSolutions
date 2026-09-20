import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class Interval {

  public int start, end;

  public Interval(int start, int end) {
    this.start = start;
    this.end = end;
  }
}

class Solution {

  public int minMeetingRooms(List<Interval> intervals) {
    intervals.sort((a, b) -> a.start - b.start);
    PriorityQueue<Integer> pq = new PriorityQueue<>();

    for (Interval itr : intervals) {
      if (!pq.isEmpty() && pq.peek() <= itr.start) pq.poll();

      pq.add(itr.end);
    }

    return pq.size();
  }
}

public class _Meeting_Rooms_II {

  public static void main(String[] args) {
    System.out.println(
      new Solution().minMeetingRooms(
        Arrays.asList(
          new Interval(0, 40),
          new Interval(5, 10),
          new Interval(15, 20)
        )
      )
    );
  }
}
