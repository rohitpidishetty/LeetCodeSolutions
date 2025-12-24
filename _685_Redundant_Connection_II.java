import java.util.*;

class Solution {

  public int[] findRedundantDirectedConnection(int[][] edges) {
    int n = edges.length;
    int[] dup_edge = new int[2], prev_edge = new int[2];
    int[] introducer = new int[n + 1];
    for (int[] edge : edges) {
      int u = edge[0], v = edge[1];
      if (introducer[v] == 0) introducer[v] = u;
      else {
        prev_edge = new int[] { introducer[v], v };
        dup_edge = edge;
      }
    }
    int[] uf_mat = new int[n + 1];
    for (int i = 1; i <= n; i++) uf_mat[i] = i;

    for (int[] edge : edges) {
      int u = edge[0], v = edge[1];
      if (u == dup_edge[0] && v == dup_edge[1]) continue;
      int root_of_u = find(u, uf_mat), root_of_v = find(v, uf_mat);
      if (root_of_u == root_of_v) {
        if (prev_edge[0] != 0 && prev_edge[1] != 0) return prev_edge;
        return edge;
      }
      uf_mat[root_of_v] = root_of_u;
    }
    return dup_edge;
  }

  private int find(int n, int[] mat) {
    if (mat[n] == n) return n;
    return find(mat[n], mat);
  }
}

public class _685_Redundant_Connection_II {

  public static void main(String[] args) {
    System.out.println(
      Arrays.toString(
        new Solution()
          .findRedundantDirectedConnection(
            new int[][] { { 2, 1 }, { 3, 1 }, { 4, 2 }, { 1, 4 } }
            // new int[][] { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 4, 1 }, { 1, 5 } }
          )
      )
    );
  }
}
