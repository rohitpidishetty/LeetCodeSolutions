import java.util.Arrays;

class Solution {
  public int[][] matrixReshape(int[][] mat, int r, int c) {
    int n = mat.length, m = mat[0].length;
    if ((n * m) != (r * c))
      return mat;
    int buffer[] = new int[n * m];
    int idx = 0;
    for (int i = 0; i < n; i++)
      for (int j = 0; j < m; j++)
        buffer[idx++] = mat[i][j];
    int[][] newBuffer = new int[r][c];
    idx = 0;
    for (int i = 0; i < r; i++)
      for (int j = 0; j < c; j++)
        newBuffer[i][j] = buffer[idx++];
    return newBuffer;
  }
}

public class _566_Reshape_the_Matrix {
  public static void main(String[] args) {
    System.out.println(Arrays
        .deepToString(new Solution()
            .matrixReshape(
                new int[][] {
                    { 1, 2 }, { 3, 4 } },
                1, 4)));
  }
}
