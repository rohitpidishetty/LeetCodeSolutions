import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

  public List<Integer> fallingSquares(int[][] positions) {
    List<Integer> buffer = new ArrayList<>();
    int max = 0;
    int n = positions.length;
    for (int i = 0; i < n; i++) {
      positions[i][1] += positions[i][0];
      positions[i] = Arrays.copyOf(positions[i], 3);
    }

    positions[0][2] = (positions[0][1] - positions[0][0]);
    int height = positions[0][2];
    buffer.add(height);
    for (int i = 1; i < n; i++) {
      int left = positions[i][0], right = positions[i][1];

      int bestHeight = 0;
      for (int j = 0; j < i; j++) if (
        left < positions[j][1] && right > positions[j][0]
      ) bestHeight = Math.max(bestHeight, positions[j][2]);
      positions[i][2] = right - left + bestHeight;

      height = Math.max(height, positions[i][2]);
      buffer.add(height);
    }

    return buffer;
  }
}

public class _699_Falling_Squares {

  public static void main(String[] args) {
    System.out.println(
      new Solution()
        .fallingSquares(new int[][] { { 1, 2 }, { 2, 3 }, { 6, 1 } })
    );
  }
}
