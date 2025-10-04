import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

  public String frequencySort(String s) {
    int n = s.length();
    Map<Character, Integer> freq = new HashMap<>();
    for (int i = 0; i < n; i++) {
      char ch = s.charAt(i);
      freq.put(ch, freq.getOrDefault(ch, 0) + 1);
    }
    Map<Integer, List<Character>> bucketSort = new HashMap<>();
    List<Boolean> buffer = new ArrayList<>();
    for (Map.Entry<Character, Integer> frq : freq.entrySet()) {
      int V = frq.getValue();
      if (bucketSort.get(V) == null) bucketSort.put(V, new ArrayList<>());
      while (V >= buffer.size()) buffer.add(false);
      bucketSort.get(V).add(frq.getKey());
      buffer.set(V, true);
    }
    int x = buffer.size() - 1;

    StringBuilder sb = new StringBuilder();
    while (x >= 0) {
      if (buffer.get(x)) {
        List<Character> subBuf = bucketSort.get(x);
        int o = subBuf.size();
        for (int i = 0; i < o; i++) {
          char chr = subBuf.get(i);
          for (int m = 0; m < x; m++) sb.append(chr);
        }
      }
      x--;
    }
    return sb.toString();
  }
}

public class _451_Sort_Characters_By_Frequency {

  public static void main(String[] args) {
    System.out.println(new Solution().frequencySort("AAAaazzbbzzz"));
  }
}
