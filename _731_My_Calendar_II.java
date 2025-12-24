import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

class MyCalendarTwo {

  private List<int[]> bookings, doubleBookings;

  public MyCalendarTwo() {
    this.bookings = new ArrayList<>();
    this.doubleBookings = new ArrayList<>();
  }

  public boolean book(int startTime, int endTime) {
    for (int[] e : doubleBookings) {
      if (Math.max(startTime, e[0]) < Math.min(endTime, e[1])) return false;
    }
    bookings.forEach(e -> {
      int a1 = startTime, a2 = e[0], b1 = endTime, b2 = e[1];
      int x = Math.max(a1, a2), y = Math.min(b1, b2);
      if (x < y) doubleBookings.add(new int[] { x, y });
    });
    bookings.add(new int[] { startTime, endTime });
    return true;
  }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(startTime,endTime);
 */
public class _731_My_Calendar_II {

  public static void main(String[] args) {
    MyCalendarTwo obj = new MyCalendarTwo();
    System.out.println(obj.book(10, 20));
    System.out.println(obj.book(50, 60));
    System.out.println(obj.book(10, 40));
    System.out.println(obj.book(5, 15));
    System.out.println(obj.book(5, 10));
    System.out.println(obj.book(25, 55));
  }
}
