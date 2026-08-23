import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

class MyCalendarThree {

  private TreeMap<Integer, Integer> bookings;

  public MyCalendarThree() {
    this.bookings = new TreeMap<>();
  }

  public int book(int startTime, int endTime) {
    this.bookings.put(startTime, this.bookings.getOrDefault(startTime, 0) + 1);
    this.bookings.put(endTime, this.bookings.getOrDefault(endTime, 0) - 1);

    int count = 0;
    int cnt = 0;
    for (int val : bookings.values()) {
      cnt += val;
      count = Math.max(count, cnt);
    }
    return count;
  }
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(startTime,endTime);
 */

public class _732_My_Calendar_III {

  public static void main(String[] args) {
    MyCalendarThree obj = new MyCalendarThree();

    System.out.println(obj.book(10, 20)); // 1
    System.out.println(obj.book(50, 60)); // 1
    System.out.println(obj.book(10, 40)); // 2
    System.out.println(obj.book(05, 15)); // 3
    System.out.println(obj.book(05, 10)); // 3
    System.out.println(obj.book(25, 55)); // 4
  }
}
