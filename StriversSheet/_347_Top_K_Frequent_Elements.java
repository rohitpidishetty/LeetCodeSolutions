import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

  public int[] topKFrequent(int[] nums, int k) {
    HashMap<Integer, Integer> freq = new HashMap<>();
    for (int num : nums) freq.put(num, freq.getOrDefault(num, 0) + 1);
    List<List<Integer>> bucket = new ArrayList<>();
    for (Map.Entry<Integer, Integer> m : freq.entrySet()) {
      int index = m.getValue();
      while (bucket.size() <= index) bucket.add(new ArrayList<>());
      bucket.get(index).add(m.getKey());
    }
    int res[] = new int[k];
    int size = 0;
    for (int i = bucket.size() - 1; i >= 0; i--) {
      List<Integer> buff = bucket.get(i);
      if (buff != null) {
        for (int num : buff) {
          if (size < k) res[size++] = num;
          else break;
        }
      }
    }
    return res;
  }
}

public class _347_Top_K_Frequent_Elements {

  public static void main(String[] args) {
    System.out.println(
      new Solution().topKFrequent(new int[] { 1, 2, 1, 2, 1, 2, 3, 1, 3, 2 }, 2)
    );
  }
}
