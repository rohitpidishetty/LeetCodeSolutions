import java.util.*;

class Solution {

  public int containVirus(int[][] grid) {
    int m = grid.length, n = grid[0].length;
    int totalWalls = 0;

    while (true) {
      boolean[][] visited = new boolean[m][n];
      List<List<int[]>> regions = new ArrayList<>();
      List<Set<String>> frontiers = new ArrayList<>();
      List<Integer> wallsNeeded = new ArrayList<>();

      for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
          if (grid[i][j] == 1 && !visited[i][j]) {
            List<int[]> region = new ArrayList<>();
            Set<String> frontier = new HashSet<>();
            int walls = bfs(grid, i, j, visited, region, frontier);
            regions.add(region);
            frontiers.add(frontier);
            wallsNeeded.add(walls);
          }
        }
      }

      if (regions.size() == 0) break;

      int maxIndex = 0;
      for (int i = 1; i < frontiers.size(); i++) {
        if (frontiers.get(i).size() > frontiers.get(maxIndex).size()) {
          maxIndex = i;
        }
      }

      totalWalls += wallsNeeded.get(maxIndex);
      for (int[] cell : regions.get(maxIndex)) {
        grid[cell[0]][cell[1]] = -1;
      }

      for (int i = 0; i < regions.size(); i++) {
        if (i == maxIndex) continue;
        for (String s : frontiers.get(i)) {
          String[] parts = s.split(",");
          int x = Integer.parseInt(parts[0]);
          int y = Integer.parseInt(parts[1]);
          grid[x][y] = 1;
        }
      }
    }

    return totalWalls;
  }

  private int bfs(
    int[][] grid,
    int i,
    int j,
    boolean[][] visited,
    List<int[]> region,
    Set<String> frontier
  ) {
    int m = grid.length, n = grid[0].length;
    int walls = 0;
    int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
    Queue<int[]> queue = new LinkedList<>();
    queue.offer(new int[] { i, j });
    visited[i][j] = true;
    region.add(new int[] { i, j });

    while (!queue.isEmpty()) {
      int[] cell = queue.poll();
      int x = cell[0], y = cell[1];
      for (int[] dir : dirs) {
        int nx = x + dir[0], ny = y + dir[1];
        if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
        if (grid[nx][ny] == 0) {
          frontier.add(nx + "," + ny);
          walls++;
        } else if (grid[nx][ny] == 1 && !visited[nx][ny]) {
          visited[nx][ny] = true;
          queue.offer(new int[] { nx, ny });
          region.add(new int[] { nx, ny });
        }
      }
    }

    return walls;
  }
}
