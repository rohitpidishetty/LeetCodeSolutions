import java.util.Arrays;

class Solution {

  private int find(int x, int[] parents) {
    if (x == parents[x]) return x;
    return parents[x] = find(parents[x], parents);
  }

  private void union(int a, int b, int[] rank, int[] parents) {
    if (rank[a] > rank[b]) parents[b] = a;
    else if (rank[b] > rank[a]) parents[a] = b;
    else {
      parents[b] = a;
      rank[a]++;
    }
  }

  public int makeConnected(int n, int[][] connections) {
    if (connections.length < n - 1) return -1;
    int[] parents = new int[n];
    int[] rank = new int[n];
    for (int i = 0; i < n; i++) parents[i] = i;
    for (int i = 0; i < connections.length; i++) {
      int n1 = connections[i][0];
      int n2 = connections[i][1];
      int n1p = find(n1, parents);
      int n2p = find(n2, parents);
      if (n1p == n2p) continue;
      union(n1p, n2p, rank, parents);
    }

    int sets = 0;

    for (int i = 0; i < n; i++) if (parents[i] == i) sets++;
    int edges = sets - 1;
    return edges;
  }
}

public class _1319_Number_of_Operations_to_Make_Network_Connected {

  public static void main(String[] args) {
    System.out.println(
      new Solution().makeConnected(
        6,
        new int[][] { { 0, 1 }, { 0, 2 }, { 0, 3 }, { 1, 2 }, { 1, 3 } }
      )
    );
  }
}
