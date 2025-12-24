import java.util.LinkedHashSet;
import java.util.TreeMap;
import java.util.TreeSet;

class RangeModule {

  private TreeMap<Integer, Integer> o;

  public RangeModule() {
    this.o = new TreeMap<>();
  }

  public void addRange(int left, int right) {
    // Check if there is any over lap with the existing values.
    Integer leftBound = this.o.floorKey(left);
    Integer rightBound = leftBound != null
      ? this.o.get(leftBound)
      : Integer.MIN_VALUE;
    if (leftBound != null && rightBound >= left) {
      left = leftBound;
      right = Math.max(right, rightBound);
      this.o.remove(leftBound);
    }
    // Merge all right overlaps
    rightBound = this.o.ceilingKey(left);
    while (rightBound != null && rightBound <= right) {
      right = Math.max(right, this.o.get(rightBound));
      this.o.remove(rightBound);
      rightBound = this.o.ceilingKey(left);
    }
    this.o.put(left, right);
  }

  public boolean queryRange(int left, int right) {
    Integer l = this.o.floorKey(left);
    return (l != null && this.o.get(l) >= right);
  }

  public void removeRange(int left, int right) {
    Integer leftBound = this.o.floorKey(left);
    if (leftBound != null && this.o.get(leftBound) > left) {
      int end = o.get(leftBound);
      if (end > right) o.put(right, end);
      o.put(leftBound, left);
    }

    Integer rightBound = o.ceilingKey(left);
    while (rightBound != null && rightBound < right) {
      int end = o.get(rightBound);
      o.remove(rightBound);
      if (end > right) {
        o.put(right, end);
        break;
      }
      rightBound = o.ceilingKey(left);
    }
  }
}

/**
 * Your RangeModule object will be instantiated and called as such:
 * RangeModule obj = new RangeModule();
 * obj.addRange(left,right);
 * boolean param_2 = obj.queryRange(left,right);
 * obj.removeRange(left,right);
 */
public class _715_Range_Module {

  public static void main(String[] args) {
    RangeModule obj = new RangeModule();
    obj.addRange(10, 20);
    obj.addRange(15, 25);
    obj.addRange(30, 40);
    System.out.println(obj.queryRange(14, 16));
    System.out.println(obj.queryRange(26, 29));
    obj.removeRange(14, 16);
    obj.removeRange(22, 37);
  }
}
