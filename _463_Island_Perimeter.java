import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

class Solution {

  public int islandPerimeter(int[][] grid) {
    int n = grid.length, m = grid[0].length, s_i = 0, s_j = 0;
    boolean found_s = false;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (grid[i][j] == 1) {
          found_s = true;
          s_i = i;
          s_j = j;
        }
      }
      if (found_s) break;
    }
    Queue<int[]> bfsQ = new ArrayDeque<>();
    Set<String> visited = new HashSet<>();
    int[] node = new int[] { s_i, s_j };
    bfsQ.offer(node);
    visited.add(s_i + "|" + s_j);
    int border = 0;
    int[][] directions = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
    while (!bfsQ.isEmpty()) {
      int[] curr = bfsQ.poll();
      for (int[] dir : directions) {
        int next_i = curr[0] + dir[0];
        int next_j = curr[1] + dir[1];
        if (next_i < 0 || next_i >= n || next_j < 0 || next_j >= m) border++;
        else {
          int next[] = new int[] { next_i, next_j };
          String nex = next_i + "|" + next_j;
          if (grid[next_i][next_j] == 0) border++;
          else {
            if (!visited.contains(nex)) {
              visited.add(nex);
              bfsQ.offer(next);
            }
          }
        }
      }
    }

    return border;
  }
}

public class _463_Island_Perimeter {

  public static void main(String[] args) {
    System.out.println(
      new Solution()
        .islandPerimeter(
          new int[][] {
            { 0, 1, 0, 0 },
            { 1, 1, 1, 0 },
            { 0, 1, 0, 0 },
            { 1, 1, 0, 0 },
          }
        )
    );
  }
}
