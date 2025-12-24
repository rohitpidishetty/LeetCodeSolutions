import java.util.HashMap;
import java.util.Map;

class Solution {

  public int numberOfBoomerangs(int[][] points) {
    int i = 0, j = 0, n = points.length, m = n, total = 0;
    while (i < n) {
      j = 0;
      Map<Integer, Integer> dist = new HashMap<>();
      while (j < m) {
        if (i != j) {
          int distance =
            ((points[i][0] - points[j][0]) * (points[i][0] - points[j][0])) +
            ((points[i][1] - points[j][1]) * (points[i][1] - points[j][1]));
          dist.put(distance, dist.getOrDefault(distance, 0) + 1);
        }
        j++;
      }
      // using formula m * (m - 1)
      for (int v : dist.values()) total += v * (v - 1);
      i++;
    }
    return total;
  }
}

public class _447_Number_of_Boomerangs {

  public static void main(String[] args) {
    System.out.println(
      new Solution()
        .numberOfBoomerangs(new int[][] { { 0, 0 }, { 1, 0 }, { 2, 0 } })
    );
  }
}
