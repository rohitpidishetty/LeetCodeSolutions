import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

  public int[] topKFrequent(int[] nums, int k) {
    Map<Integer, Integer> freq = new HashMap<>();
    for (int num : nums) freq.put(num, freq.getOrDefault(num, 0) + 1);
    @SuppressWarnings("unchecked")
    List<Integer>[] buckets = new ArrayList[nums.length + 1];
    freq
      .keySet()
      .forEach(key -> {
        int idx = freq.get(key);
        if (buckets[idx] == null) buckets[idx] = new ArrayList<>();
        buckets[freq.get(key)].add(key);
      });
    int[] ret = new int[k];
    int idx = 0;
    for (int i = buckets.length - 1; i >= 0; i--) {
      if (buckets[i] == null) continue;
      int n = buckets[i].size() - 1;
      while (k > 0 && n >= 0) {
        ret[idx++] = buckets[i].get(n--);
        k--;
      }
    }
    return ret;
  }
}

public class _347_Top_K_Frequent_Elements {

  public static void main(String[] args) {
    System.out.println(
      Arrays.toString(new Solution().topKFrequent(new int[] { 1 }, 1))
    );
  }
}
