import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
  public void setZeroes(int[][] matrix) {
    Set<String> v = new HashSet<>();
    Set<String> z = new HashSet<>();
    String mark = new String();
    int r = matrix.length;
    int c = matrix[0].length;
    for (int i = 0; i < r; i++) {
      for (int j = 0; j < c; j++) {
        mark = (i + "," + j);
        if (matrix[i][j] == 0)
          v.add(mark);
      }
    }

    v.iterator().forEachRemaining(e -> {
      String[] idx = e.split(",");
      int i = Integer.parseInt(idx[0]);
      int j = Integer.parseInt(idx[1]);
      String _mark_ = (i + "," + j);
      // if (!z.contains(_mark_)) {
      for (int jnext = 0; jnext < c; jnext++) {
        _mark_ = (i + "," + jnext);
        if (v.contains(_mark_))
          z.add(_mark_);
        matrix[i][jnext] = 0;
      }
      for (int inext = 0; inext < r; inext++) {
        _mark_ = (inext + "," + j);
        if (v.contains(_mark_))
          z.add(_mark_);
        matrix[inext][j] = 0;
      }
      // }
    });
  }
}

public class ZeroMat {
  public static void main(String[] args) {
    int[][] matrix = new int[][] {
        { 0, 1, 2, 0 },
        { 3, 4, 5, 2 },
        { 1, 3, 1, 5 }
    };
    new Solution().setZeroes(matrix);
    System.out.println(Arrays.deepToString(matrix));
  }
}
