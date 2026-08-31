import java.util.ArrayList;
import java.util.List;

class Solution {

  private void solve(
    int x,
    int y,
    int[][] grid,
    int n,
    int m,
    StringBuilder sb,
    List<String> buff
  ) {
    if (
      x < 0 ||
      x >= n + 1 ||
      y < 0 ||
      y >= m + 1 ||
      grid[x][y] == 2 ||
      grid[x][y] == 0
    ) return;
    if (x == n && y == m) {
      buff.add(sb.toString());
      return;
    }
    grid[x][y] = 2;

    sb.append('D');
    solve(x + 1, y, grid, n, m, sb, buff);
    sb.deleteCharAt(sb.length() - 1);

    sb.append('R');
    solve(x, y + 1, grid, n, m, sb, buff);
    sb.deleteCharAt(sb.length() - 1);

    grid[x][y] = 1;
  }

  public List<String> findPath(int[][] grid) {
    List<String> buff = new ArrayList<>();
    solve(
      0,
      0,
      grid,
      grid.length - 1,
      grid[0].length - 1,
      new StringBuilder(),
      buff
    );
    return buff;
  }
}

public class _Rat_In_a_Maze {

  public static void main(String[] args) {
    System.out.println(
      new Solution().findPath(
        new int[][] {
          { 1, 0, 0, 0 },
          { 1, 1, 0, 1 },
          { 1, 1, 0, 0 },
          { 0, 1, 1, 1 },
        }
      )
    );
  }
}
