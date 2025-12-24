import java.util.*;

class Solution {

  public int[] findRedundantConnection(int[][] edges) {
    int n = edges.length;
    int[] unionFindMat = new int[n + 1];
    for (int i = 1; i < n; i++) unionFindMat[i] = i;

    for (int[] edge : edges) {
      int s = edge[0], d = edge[1];
      int X = find(s, unionFindMat), Y = find(d, unionFindMat);
      if (X == Y) return edge;
      unionFindMat[X] = Y;
    }
    return null;
  }

  private int find(int s, int[] uf_mat) {
    if (uf_mat[s] != s) uf_mat[s] = find(uf_mat[s], uf_mat);
    return uf_mat[s];
  }
}

public class _684_Redundant_Connection {

  public static void main(String[] args) {
    System.out.println(
      Arrays.toString(
        new Solution()
          .findRedundantConnection(
            new int[][] { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 1, 4 }, { 1, 5 } }
          )
      )
    );
  }
}
