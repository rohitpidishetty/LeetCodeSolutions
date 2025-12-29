import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

  Map<String, List<String>> map;
  Map<String, Boolean> memo;

  private boolean dfs(StringBuilder sb, ArrayList<String> buffer) {
    if (sb.length() == 1 && buffer.isEmpty()) {
      return true;
    }

    String row = sb.toString();
    if (buffer.isEmpty()) {
      if (memo.containsKey(row)) {
        return memo.get(row);
      }
      ArrayList<String> newBuff = new ArrayList<>();
      int m = row.length();
      for (int i = 0; i < m - 1; i++) {
        newBuff.add(row.substring(i, Math.min(i + 2, m)));
      }
      boolean res = dfs(new StringBuilder(), newBuff);
      memo.put(row, res);
      return res;
    }

    String e = buffer.get(0);

    if (!this.map.containsKey(e)) return false;
    for (String x : this.map.get(e)) {
      sb.append(x);
      ArrayList<String> buf = new ArrayList<>(buffer);
      buf.removeFirst();
      if (dfs(sb, buf)) return true;
      sb.deleteCharAt(sb.length() - 1);
    }

    return false;
  }

  public boolean pyramidTransition(String bottom, List<String> allowed) {
    this.map = new HashMap<>();
    this.memo = new HashMap<>();
    int n = allowed.size();
    for (int i = 0; i < n; i++) {
      String str = allowed.get(i);
      String k = str.substring(0, 2);
      if (!map.containsKey(k)) map.put(k, new ArrayList<>());
      map.get(k).add(str.substring(2));
    }

    ArrayList<String> buffer = new ArrayList<>();
    int m = bottom.length();
    for (int i = 0; i < m - 1; i++) {
      buffer.add(bottom.substring(i, Math.min(i + 2, m)));
    }

    return dfs(new StringBuilder(), buffer);
  }
}

public class _756_Pyramid_Transition_Matrix {

  public static void main(String[] args) {
    System.out.println(
      new Solution()
        .pyramidTransition(
          "AAAA",
          Arrays.asList("AAB", "AAC", "BCD", "BBE", "DEF")
        )
    );
  }
}
