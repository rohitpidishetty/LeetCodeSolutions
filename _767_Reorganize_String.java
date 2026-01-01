import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {

  private class Freq {

    protected char ch;
    protected int freq;

    public Freq(char ch, int freq) {
      this.ch = ch;
      this.freq = freq;
    }
  }

  public String reorganizeString(String s) {
    int n = s.length();
    Map<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < n; i++) {
      char ch = s.charAt(i);
      map.put(ch, map.getOrDefault(ch, 0) + 1);
    }

    PriorityQueue<Freq> pQ = new PriorityQueue<>((a, b) -> b.freq - a.freq);

    for (Map.Entry<Character, Integer> m : map.entrySet()) {
      pQ.offer(new Freq(m.getKey(), m.getValue()));
    }

    StringBuilder sb = new StringBuilder();
    while (!pQ.isEmpty()) {
      Freq f = pQ.poll();
      n = sb.length();

      if (n > 0) {
        Queue<Freq> temp = new ArrayDeque<>();
        char prevChar = sb.charAt(n - 1);

        while (!pQ.isEmpty() && prevChar == f.ch) {
          temp.add(f);
          f = pQ.poll();
        }

        if (f == null || f.ch == prevChar) return "";
        while (!temp.isEmpty()) pQ.offer(temp.poll());
      }

      sb.append(f.ch);
      f.freq--;
      if (f.freq > 0) pQ.offer(new Freq(f.ch, f.freq));
    }
    return sb.toString();
  }
}

public class _767_Reorganize_String {

  public static void main(String[] args) {
    System.out.println(new Solution().reorganizeString(new String("vvvlo")));
  }
}
