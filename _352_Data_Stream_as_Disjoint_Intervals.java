import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

// class SummaryRanges {

//   private TreeMap<Integer, Integer> globalPool;

//   public SummaryRanges() {
//     globalPool = new TreeMap<>();
//   }

//   public void addNum(int value) {
//     boolean nextElement_as_starting = globalPool.containsKey(value + 1);
//     boolean previousElement_as_ending = globalPool.containsKey(value - 1);

//     if (!nextElement_as_starting && !previousElement_as_ending) {
//       globalPool.put(value, value);
//     } else if (nextElement_as_starting && previousElement_as_ending) {
//       globalPool.put(value - 1, globalPool.get(value + 1));
//       globalPool.remove(value + 1);
//     } else {
//       if (!nextElement_as_starting) {
//         globalPool.put(value - 1, value);
//       } else {
//         globalPool.put(value, globalPool.get(value + 1));
//         globalPool.remove(value + 1);
//       }
//     }
//   }

//   public int[][] getIntervals() {
//     int size = globalPool.size();
//     int[][] ret = new int[size][2];
//     int idx = 0;
//     for (Map.Entry<Integer, Integer> entry : globalPool.entrySet()) {
//       ret[idx++] = new int[] { entry.getKey(), entry.getValue() };
//     }
//     return ret;
//   }
// }

class SummaryRanges {

  private TreeMap<Integer, Integer> globalPool;

  public SummaryRanges() {
    globalPool = new TreeMap<>();
  }

  public void addNum(int value) {
    Integer lowerKey = globalPool.floorKey(value);
    if (lowerKey != null && globalPool.get(lowerKey) >= value) return;

    Integer higherKey = globalPool.ceilingKey(value);

    boolean mergeLeft =
      (lowerKey != null && globalPool.get(lowerKey) + 1 == value);

    boolean mergeRight = (higherKey != null && higherKey - 1 == value);

    if (mergeLeft && mergeRight) {
      globalPool.put(lowerKey, globalPool.get(higherKey));
      globalPool.remove(higherKey);
    } else if (mergeLeft) {
      globalPool.put(lowerKey, globalPool.get(lowerKey) + 1);
    } else if (mergeRight) {
      int end = globalPool.get(higherKey);
      globalPool.remove(higherKey);
      globalPool.put(value, end);
    } else {
      globalPool.put(value, value);
    }
  }

  public int[][] getIntervals() {
    int[][] ret = new int[globalPool.size()][2];
    int idx = 0;
    for (Map.Entry<Integer, Integer> entry : globalPool.entrySet()) {
      ret[idx][0] = entry.getKey();
      ret[idx][1] = entry.getValue();
      idx++;
    }
    return ret;
  }
}

public class _352_Data_Stream_as_Disjoint_Intervals {

  public static void main(String[] args) {
    SummaryRanges summaryRanges = new SummaryRanges();
    summaryRanges.addNum(1); // arr = [1]
    System.out.println(Arrays.deepToString(summaryRanges.getIntervals())); // return [[1, 1]]
    summaryRanges.addNum(3); // arr = [1, 3]
    System.out.println(Arrays.deepToString(summaryRanges.getIntervals())); // return [[1, 1], [3, 3]]
    summaryRanges.addNum(7); // arr = [1, 3, 7]
    System.out.println(Arrays.deepToString(summaryRanges.getIntervals())); // return [[1, 1], [3, 3], [7, 7]]
    summaryRanges.addNum(2); // arr = [1, 2, 3, 7]
    System.out.println(Arrays.deepToString(summaryRanges.getIntervals())); // return [[1, 3], [7, 7]]
    summaryRanges.addNum(6); // arr = [1, 2, 3, 6, 7]
    System.out.println(Arrays.deepToString(summaryRanges.getIntervals())); // return [[1, 3], [6, 7]]
  }
}
