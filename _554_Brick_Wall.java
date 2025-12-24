import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
  public int leastBricks(List<List<Integer>> wall) {
    Map<Integer, Integer> freq = new HashMap<>();
    int buff_sum = 0;
    for (List<Integer> buffer : wall) {
      int sum = 0;
      for (Integer num : buffer) {
        sum += num;
        freq.put(sum, freq.getOrDefault(sum, 0) + 1);
      }
      if (buff_sum == 0)
        buff_sum = sum;
    }
    freq.remove(buff_sum);
    return wall.size() - (int) freq.values().stream().max((a, b) -> a - b).orElse(0);
  }
}

public class _554_Brick_Wall {
  /**
   * new int[] {
   * { 1, 2, 2, 1 },
   * { 3, 1, 2 },
   * { 1, 3, 2 },
   * { 2, 4 },
   * { 3, 1, 2 },
   * { 1, 3, 1, 1 }
   * }
   */
  public static void main(String[] args) {
    System.out.println(new Solution()
        .leastBricks(
            Arrays.asList(
                Arrays.asList(1, 2, 2, 1),
                Arrays.asList(3, 1, 2),
                Arrays.asList(1, 3, 2),
                Arrays.asList(2, 4),
                Arrays.asList(3, 1, 2),
                Arrays.asList(1, 3, 1, 1))));
  }
}
