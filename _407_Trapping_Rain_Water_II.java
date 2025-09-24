import java.util.PriorityQueue;

class Solution {

  public int trapRainWater(int[][] heightMap) {
    int n = heightMap.length;
    int m = heightMap[0].length;
    if (n < 3 || m < 3) return 0;
    boolean[][] visited = new boolean[n][m];
    PriorityQueue<int[]> pQ = new PriorityQueue<>((a, b) -> a[0] - b[0]);
    for (int j = 0; j < m; j++) {
      pQ.offer(new int[] { heightMap[0][j], 0, j });
      pQ.offer(new int[] { heightMap[n - 1][j], n - 1, j });
      visited[0][j] = true;
      visited[n - 1][j] = true;
    }
    for (int i = 0; i < n; i++) {
      pQ.offer(new int[] { heightMap[i][0], i, 0 });
      pQ.offer(new int[] { heightMap[i][m - 1], i, m - 1 });
      visited[i][0] = true;
      visited[i][m - 1] = true;
    }
    int[][] neighbors = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };
    int water = 0;
    while (!pQ.isEmpty()) {
      int[] current_building = pQ.poll();
      // Visit Neighbors
      int curr_height = current_building[0];
      int x_coord = current_building[1];
      int y_coord = current_building[2];
      for (int[] neighbor : neighbors) {
        int next_x = x_coord + neighbor[0];
        int next_y = y_coord + neighbor[1];
        if (
          next_x > -1 &&
          next_x < n &&
          next_y > -1 &&
          next_y < m &&
          !visited[next_x][next_y]
        ) {
          int next_height = heightMap[next_x][next_y];
          if (curr_height > next_height) {
            water += curr_height - next_height;
          }
          pQ.offer(
            new int[] { Math.max(curr_height, next_height), next_x, next_y }
          );
          visited[next_x][next_y] = true;
        }
      }
    }
    return water;
  }
}

public class _407_Trapping_Rain_Water_II {

  public static void main(String[] args) {
    System.out.println(
      new Solution()
        .trapRainWater(
          new int[][] {
            { 1, 4, 3, 1, 3, 2 },
            { 3, 1, 1, 3, 2, 4 },
            { 3, 2, 1, 3, 2, 4 },
            { 7, 2, 1, 3, 2, 4 },
            { 3, 2, 1, 3, 2, 4 },
            { 3, 2, 1, 3, 1, 4 },
            { 2, 3, 3, 2, 3, 1 },
          }
        )
    );
  }
}
