import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

  public int equalPairs(int[][] grid) {
    List<String> rows = new ArrayList<>();
    Map<String, Integer> freq = new HashMap<>();
    for (int i = 0; i < grid.length; i++) {
      StringBuilder r = new StringBuilder();
      for (int j = 0; j < grid[i].length; j++) r.append(grid[i][j]).append(".");
      String rv = r.toString();
      freq.put(rv, freq.getOrDefault(rv, 0) + 1);
    }
    int count = 0;
    for (int j = 0; j < grid[0].length; j++) {
      StringBuilder c = new StringBuilder();
      for (int i = 0; i < grid.length; i++) c.append(grid[i][j]).append(".");

      String cv = c.toString();
      if (freq.containsKey(cv)) {
        count += freq.get(cv);
      }
    }
    return count;
  }
}

public class _2352_Equal_Row_and_Column_Pairs {

  public static void main(String[] args) {
    System.out.println(
      new Solution().equalPairs(
        new int[][] {
          { 3, 1, 2, 2 },
          { 1, 4, 4, 5 },
          { 2, 4, 2, 2 },
          { 2, 4, 2, 2 },
        }
      )
    );
  }
}
