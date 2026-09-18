import java.util.HashMap;
import java.util.Map;

class Solution {

  public int maximumWidth(int[] planks) {
    Map<Integer, Integer> freq = new HashMap<>();

    for (int plank : planks) {
      freq.put(plank, freq.getOrDefault(plank, 0) + 1);
    }

    Map<Integer, Integer> width = new HashMap<>();

    for (int x : freq.keySet()) {
      int countX = freq.get(x);

      width.put(x, width.getOrDefault(x, 0) + countX);

      int sameHeight = x + x;

      width.put(sameHeight, width.getOrDefault(sameHeight, 0) + countX / 2);

      for (int y : freq.keySet()) {
        if (y <= x) continue;

        int countY = freq.get(y);

        int targetHeight = x + y;
        int pairs = Math.min(countX, countY);

        width.put(targetHeight, width.getOrDefault(targetHeight, 0) + pairs);
      }
    }

    int maxWidth = 0;

    for (int value : width.values()) {
      maxWidth = Math.max(maxWidth, value);
    }

    return maxWidth;
  }
}

public class _4007_Widest_Possible_Fence {

  public static void main(String[] args) {
    System.out.println(
      new Solution().maximumWidth(new int[] { 1, 3, 2, 5, 7, 5, 4, 2, 1 })
    );
  }
}
