import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {

  public class Char {

    protected char ch;
    protected int freq;

    public Char(char ch, int freq) {
      this.ch = ch;
      this.freq = freq;
    }
  }

  public String reorganizeString(String s) {
    Map<Character, Integer> map = new HashMap<>();
    PriorityQueue<Character> pq = new PriorityQueue<>(
      (a, b) -> map.get(b) - map.get(a)
    );
    int n = s.length();
    for (int i = 0; i < n; i++) {
      char ch = s.charAt(i);
      map.put(ch, map.getOrDefault(ch, 0) + 1);
    }

    pq.addAll(map.keySet());
    char cooldown = '\0';

    StringBuilder sb = new StringBuilder();
    while (!pq.isEmpty()) {
      char curr = pq.poll();
      sb.append(curr);
      int reduce = map.get(curr) - 1;
      if (reduce > 0) map.put(curr, reduce);
      else map.remove(curr);
      if (cooldown != '\0' && map.containsKey(cooldown)) pq.offer(cooldown);
      cooldown = curr;
    }

    return sb.length() == n ? sb.toString() : "";
  }
}

public class _767_Reorganize_String {

  public static void main(String[] args) {
    System.out.println(new Solution().reorganizeString("aaaaabbzzc"));
  }
}
