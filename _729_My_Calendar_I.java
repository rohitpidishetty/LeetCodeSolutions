import java.util.TreeMap;

class MyCalendar {

  private TreeMap<Integer, Integer> treeMap;

  public MyCalendar() {
    this.treeMap = new TreeMap<>();
  }

  public boolean book(int startTime, int endTime) {
    Integer leftKey = this.treeMap.floorKey(startTime);
    if (leftKey != null && this.treeMap.get(leftKey) > startTime) {
      return false;
    }
    Integer rightKey = this.treeMap.ceilingKey(startTime);
    if (rightKey != null && rightKey < endTime) {
      return false;
    }
    this.treeMap.put(startTime, endTime);
    return true;
  }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(startTime,endTime);
 */

public class _729_My_Calendar_I {

  public static void main(String[] args) {
    MyCalendar o = new MyCalendar();
    System.out.println(o.book(10, 20));
    System.out.println(o.book(15, 25));
    System.out.println(o.book(20, 30));
  }
}
