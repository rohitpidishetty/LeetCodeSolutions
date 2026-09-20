import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

class Solution {

  public String alienOrder(String[] words) {
    Map<Character, Set<Character>> graph = new HashMap<>();
    Map<Character, Integer> inDegs = new HashMap<>();

    for (String word : words)
      for (char ch : word.toCharArray()) inDegs.put(ch, 0);

    for (int i = 1; i < words.length; i++) {
      String first = words[i - 1];
      String second = words[i];
      int limit = Math.min(first.length(), second.length());
      int ptr = 0;

      while (ptr < limit && first.charAt(ptr) == second.charAt(ptr)) ptr++;
      if (ptr >= limit) {
        if (first.length() > second.length()) return "";
        continue;
      }

      char u = first.charAt(ptr);
      char v = second.charAt(ptr);
      if (graph.computeIfAbsent(u, key -> new HashSet<>()).add(v)) {
        inDegs.put(v, inDegs.get(v) + 1);
      }
    }

    Queue<Character> q = new ArrayDeque<>();
    for (Map.Entry<Character, Integer> degs : inDegs.entrySet()) {
      if (degs.getValue() == 0) q.offer(degs.getKey());
    }

    StringBuilder sb = new StringBuilder();
    while (!q.isEmpty()) {
      char ch = q.poll();
      sb.append(ch);
      Set<Character> neighbors = graph.get(ch);
      if (neighbors == null) continue;
      for (char neighbor : neighbors) {
        int deg = inDegs.get(neighbor) - 1;
        inDegs.put(neighbor, deg);
        if (deg == 0) q.offer(neighbor);
      }
    }

    if (sb.length() != inDegs.size()) return "";

    return sb.toString();
  }
}

public class _269_Alien_Dictionary {

  public static void main(String[] args) {
    System.out.println(
      new Solution().alienOrder(
        new String[] { "wrt", "wrf", "er", "ett", "rftt" }
      )
    );
  }
}
