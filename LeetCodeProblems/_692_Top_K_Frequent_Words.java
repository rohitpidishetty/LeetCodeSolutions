import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

  public List<String> topKFrequent(String[] words, int k) {
    Map<String, Integer> freq = new HashMap<>();
    for (String word : words) freq.put(word, freq.getOrDefault(word, 0) + 1);
    List<List<String>> bucketSort = new ArrayList<>();
    List<String> result = new ArrayList<>();
    for (Map.Entry<String, Integer> map : freq.entrySet()) {
      int index = map.getValue();
      while (bucketSort.size() <= index) bucketSort.add(new ArrayList<>());
      bucketSort.get(index).add(map.getKey());
      Collections.sort(bucketSort.get(index), (a, b) -> a.compareTo(b));
    }

    int n = bucketSort.size() - 1;
    for (int i = n; i > -1; i--) {
      for (String s : bucketSort.get(i)) {
        result.add(s);
        k--;
        if (k == 0) return result;
      }
    }

    return null;
  }
}

public class _692_Top_K_Frequent_Words {

  public static void main(String[] args) {
    System.out.println(
      new Solution()
        .topKFrequent(
          new String[] {
            "the",
            "day",
            "is",
            "sunny",
            "the",
            "the",
            "the",
            "sunny",
            "is",
            "is",
          },
          4
        )
    );
  }
}
