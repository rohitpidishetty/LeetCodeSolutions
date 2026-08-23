import java.util.*;

class Solution {

  private class cell {

    protected int next, x_coord, y_coord;

    public cell(int next, int x_coord, int y_coord) {
      this.next = next;
      this.x_coord = x_coord;
      this.y_coord = y_coord;
    }

    @Override
    public String toString() {
      return new StringBuilder()
        .append("[")
        .append(this.next)
        .append("]:(")
        .append(this.x_coord)
        .append(",")
        .append(this.y_coord)
        .append(")")
        .toString();
    }
  }

  public int cutOffTree(List<List<Integer>> forest) {
    int n = forest.size(), m = forest.get(0).size();
    PriorityQueue<cell> pQ = new PriorityQueue<>((a, b) -> a.next - b.next);
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        int X = forest.get(i).get(j);
        if (X == 0 || X == 1) continue;
        pQ.offer(new cell(X, i, j));
      }
    }
    Queue<cell> bfsQ = new ArrayDeque<>();
    bfsQ.offer(new cell(forest.get(0).get(0), 0, 0));
    int ans = 0;
    while (!bfsQ.isEmpty() && !pQ.isEmpty()) {
      cell curr = bfsQ.poll(), next = pQ.poll();
      int dist = distance(curr, next, n, m, forest);
      if (dist == -1) return -1;
      ans += dist;
      bfsQ.offer(next);
    }
    return ans;
  }

  private int[][] neighbors = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };

  private int distance(
    cell curr,
    cell next,
    int n,
    int m,
    List<List<Integer>> forest
  ) {
    boolean[][] visited = new boolean[n][m];
    int level = 0;
    int[] curr_coords = new int[] { curr.x_coord, curr.y_coord, level };
    Queue<int[]> bfsQ = new ArrayDeque<>();
    bfsQ.offer(curr_coords);
    while (!bfsQ.isEmpty()) {
      int[] curr_coord = bfsQ.poll();
      if (
        curr_coord[0] == next.x_coord && curr_coord[1] == next.y_coord
      ) return curr_coord[2];
      for (int[] neighbor : this.neighbors) {
        int i = curr_coord[0] + neighbor[0], j = curr_coord[1] + neighbor[1];
        if (
          i < 0 ||
          i >= n ||
          j < 0 ||
          j >= m ||
          forest.get(i).get(j) == 0 ||
          visited[i][j] == true
        ) continue;
        bfsQ.offer(new int[] { i, j, curr_coord[2] + 1 });
        visited[i][j] = true;
      }
    }
    return -1;
  }
}

public class _675_Cut_Off_Trees_for_Golf_Event {

  public static void main(String[] args) {
    System.out.println(
      new Solution()
        .cutOffTree(
          Arrays.asList(
            Arrays.asList(2, 3, 4),
            Arrays.asList(0, 0, 5),
            Arrays.asList(8, 7, 6)
          )
        )
    );
  }
}
