import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

class RandomizedCollection {

  private List<Integer> buffer;
  private Map<Integer, List<Integer>> freqMap;
  private Random rand;

  public RandomizedCollection() {
    buffer = new ArrayList<>();
    freqMap = new HashMap<>();
    rand = new Random();
  }

  public boolean insert(int val) {
    boolean status = false;
    int index = buffer.size();
    buffer.add(val);
    if (!freqMap.containsKey(val)) {
      freqMap.put(val, new ArrayList<>());
      status = true;
    }
    freqMap.get(val).add(index);
    return status;
  }

  // public boolean remove(int val) {
  //   if (freqMap.containsKey(val)) {
  //     List<Integer> idxList = freqMap.get(val);
  //     int n = idxList.size();
  //     int values_last_index = idxList.get(n - 1);
  //     int idx = buffer.size() - 1;
  //     if (n > 0 && n < 2) {
  //       if (idx == values_last_index) {
  //         freqMap.remove(val);
  //         buffer.remove(idx);
  //       } else {
  //         int value = buffer.get(idx);
  //         List<Integer> buf1 = freqMap.get(value);
  //         buf1.remove(buf1.size() - 1);
  //         buf1.add(values_last_index);
  //         List<Integer> buf2 = freqMap.get(val);
  //         buf2.remove(buf2.size() - 1);
  //         int temp = buffer.get(idx);
  //         buffer.set(idx, buffer.get(values_last_index));
  //         buffer.set(values_last_index, temp);
  //         buffer.remove(idx);
  //         if (buf1.size() == 0) freqMap.remove(value);
  //         if (buf2.size() == 0) freqMap.remove(val);
  //       }
  //     } else {
  //       if (idx == values_last_index) {
  //         freqMap.get(val).remove(freqMap.get(val).size() - 1);
  //         buffer.remove(idx);
  //       } else {
  //         int value = buffer.get(idx);
  //         List<Integer> buf1 = freqMap.get(value);
  //         buf1.remove(buf1.size() - 1);
  //         buf1.add(values_last_index);
  //         List<Integer> buf2 = freqMap.get(val);
  //         buf2.remove(buf2.size() - 1);
  //         int temp = buffer.get(idx);
  //         buffer.set(idx, buffer.get(values_last_index));
  //         buffer.set(values_last_index, temp);
  //         buffer.remove(idx);
  //         if (buf1.size() == 0) freqMap.remove(value);
  //         if (buf2.size() == 0) freqMap.remove(val);
  //       }
  //     }
  //     return true;
  //   }
  //   return false;
  // }

  public boolean remove(int val) {
    if (!freqMap.containsKey(val) || freqMap.get(val).isEmpty()) return false;

    List<Integer> idxList = freqMap.get(val);
    int removeIdx = idxList.remove(idxList.size() - 1);
    int lastIdx = buffer.size() - 1;
    int lastVal = buffer.get(lastIdx);

    if (removeIdx != lastIdx) {
      List<Integer> lastValIdxList = freqMap.get(lastVal);
      lastValIdxList.remove(Integer.valueOf(lastIdx));
      lastValIdxList.add(removeIdx);

      buffer.set(removeIdx, lastVal);
    }

    buffer.remove(lastIdx);

    if (idxList.isEmpty()) {
      freqMap.remove(val);
    }

    return true;
  }

  public int getRandom() {
    return buffer.get(rand.nextInt(buffer.size()));
  }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
public class _381_Insert_Delete_GetRandom_O_1_Duplicates_allowed {

  public static void main(String[] args) {
    RandomizedCollection obj = new RandomizedCollection();
    System.out.println(obj.insert(1));
    System.out.println(obj.insert(2));
    System.out.println(obj.insert(1));
    System.out.println(obj.insert(3));
    System.out.println(obj.insert(2));
    System.out.println(obj.insert(3));
    System.out.println(obj.remove(3));
    System.out.println(obj.remove(1));
    System.out.println(obj.remove(3));
    System.out.println(obj.remove(1));
  }
}
