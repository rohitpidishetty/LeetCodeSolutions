import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
  public int[] findDiagonalOrder(int[][] mat) {     
    int n = mat.length, m = mat[0].length, idx = 0;
    int[] res = new int[n * m];
    Map<Integer, List<Integer>> M = new HashMap<>();
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        int key = (i + j);
        if (M.get(key) == null)
          M.put(key, new ArrayList<>());
        if (key % 2 == 0)
          M.get(key).addFirst(mat[i][j]);
        else
          M.get(key).add(mat[i][j]);
      }
    }
    for (Map.Entry<Integer, List<Integer>> o : M.entrySet()) {
      for (int x : o.getValue())
        res[idx++] = x;
    }
    return res;
  }
}

public class _498_Diagonal_Traverse {
  public static void main(String[] args) {
    System.out.println(
        Arrays.toString(new Solution().findDiagonalOrder(
            new int[][] {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
            })));
  }
}
