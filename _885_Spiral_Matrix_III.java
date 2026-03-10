class Solution {

  public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
    int[][] directions = new int[][] {
      { 0, 1 },
      { 1, 0 },
      { 0, -1 },
      { -1, 0 },
    }; // E -> S -> W -> N.. -> E => [dir = (dir + 1) % 4]
    int steps = 0;
    int direction = 0;
    int total = rows * cols;
    int[][] result = new int[total][2];
    int magnitude = 1;
    result[0] = new int[] { rStart, cStart };
    while (magnitude < total) {
      if (direction == 0 || direction == 2) steps++;
      for (int i = 0; i < steps; i++) {
        rStart += directions[direction][0];
        cStart += directions[direction][1];
        if (
          rStart >= 0 && rStart < rows && cStart >= 0 && cStart < cols
        ) result[magnitude++] = new int[] { rStart, cStart };
      }
      direction = (direction + 1) % 4;
    }
    return result;
  }
}

public class _885_Spiral_Matrix_III {

  public static void main(String[] args) {
    System.out.println(new Solution().spiralMatrixIII(1, 4, 0, 0));
  }
}
