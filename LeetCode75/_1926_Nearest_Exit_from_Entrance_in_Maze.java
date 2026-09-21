import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

class Solution {

  public int nearestExit(char[][] maze, int[] entrance) {
    int[][] dirs = new int[][] { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };
    Queue<int[]> q = new ArrayDeque<>();
    q.offer(entrance);
    maze[entrance[0]][entrance[1]] = '+';
    int n = maze.length;
    int m = maze[0].length;

    int level = 0;

    while (!q.isEmpty()) {
      int size = q.size();
      while (size > 0) {
        int[] curr = q.poll();
        for (int[] dir : dirs) {
          int i = curr[0] + dir[0];
          int j = curr[1] + dir[1];
          if (i < 0 || i > n - 1 || j < 0 || j > m - 1 || maze[i][j] == '+') {
            continue;
          }
          if (i == 0 || i == n - 1 || j == 0 || j == m - 1) return (level + 1);
          q.offer(new int[] { i, j });
          maze[i][j] = '+';
        }
        size--;
      }
      level++;
    }
    return -1;
  }
}

public class _1926_Nearest_Exit_from_Entrance_in_Maze {

  public static void main(String[] args) {
    System.out.println(
      new Solution().nearestExit(
        new char[][] {
          { '+', '+', '+' },
          { '.', '.', '.' },
          { '+', '+', '+' },
        },
        new int[] { 1, 0 }
      )
    );
  }
}
