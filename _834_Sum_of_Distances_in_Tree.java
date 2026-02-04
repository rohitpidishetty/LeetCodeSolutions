import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

  private int distSum = 0;
  private int[] distSummations;
  private int[] children;

  private int dfs_of_root(
    List<List<Integer>> tree,
    int source,
    int depth,
    int introducer
  ) {
    int count = 1;
    distSum += depth;

    // Children
    for (int next : tree.get(source)) {
      if (next == introducer) continue;
      count += dfs_of_root(tree, next, depth + 1, source);
    }

    children[source] = count;
    return count;
  }

  private void dfs(
    List<List<Integer>> tree,
    int source,
    int introducer,
    int N,
    int[] distSummations
  ) {
    // Children
    for (int next : tree.get(source)) {
      if (next == introducer) continue;
      distSummations[next] =
        distSummations[source] - children[next] + (N - children[next]);
      dfs(tree, next, source, N, distSummations);
    }
  }

  public int[] sumOfDistancesInTree(int n, int[][] edges) {
    distSummations = new int[n];
    children = new int[n];
    List<List<Integer>> tree = new ArrayList<>();
    for (int i = 0; i < n; i++) tree.add(new ArrayList<>());

    for (int[] edge : edges) {
      tree.get(edge[0]).add(edge[1]);
      tree.get(edge[1]).add(edge[0]);
    }

    dfs_of_root(tree, 0, 0, -1);
    distSummations[0] = distSum;

    dfs(tree, 0, -1, n, distSummations);

    return distSummations;
  }
}

public class _834_Sum_of_Distances_in_Tree {

  public static void main(String[] args) {
    System.out.println(
      Arrays.toString(
        new Solution().sumOfDistancesInTree(
          6,
          new int[][] { { 0, 1 }, { 0, 2 }, { 2, 3 }, { 2, 4 }, { 2, 5 } }
        )
      )
    );

    System.out.println(
      Arrays.toString(
        new Solution().sumOfDistancesInTree(2, new int[][] { { 1, 0 } })
      )
    );
  }
}
