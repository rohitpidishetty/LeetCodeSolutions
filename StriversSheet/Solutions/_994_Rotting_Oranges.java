import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

class Solution {

  public int orangesRotting(int[][] grid) {
    int n = grid.length;
    int m = grid[0].length;
    Queue<int[]> q = new ArrayDeque<>();
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (grid[i][j] == 2) q.offer(new int[] { i, j });
      }
    }
    int level = 0;
    int[][] dir = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
    while (!q.isEmpty()) {
      int qSize = q.size();
      while (qSize > 0) {
        int[] cell = q.poll();
        for (int[] d : dir) {
          int x = d[0] + cell[0];
          int y = d[1] + cell[1];
          if (!(x < 0 || x >= n || y < 0 || y >= m) && grid[x][y] == 1) {
            grid[x][y] = 2;
            q.offer(new int[] { x, y });
          }
        }
        qSize--;
      }
      level++;
    }
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (grid[i][j] != 0 && grid[i][j] != 2) return -1;
      }
    }
    return Math.max(0, level - 1);
  }
}

public class _994_Rotting_Oranges {

  public static void main(String[] args) {
    System.out.println(
      new Solution().orangesRotting(
        new int[][] { { 2, 1, 1 }, { 0, 1, 1 }, { 1, 0, 1 } }
      )
    );
    System.out.println(
      new Solution().orangesRotting(
        new int[][] { { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } }
      )
    );
    System.out.println(new Solution().orangesRotting(new int[][] { { 0, 2 } }));
  }
}
