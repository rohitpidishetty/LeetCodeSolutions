import java.util.Arrays;

class Solution {

  private int[][] neighbors = new int[][] {
    { 1, 0 },
    { 0, 1 },
    { -1, 0 },
    { 0, -1 },
  };

  private void fill(
    int target,
    int with,
    int[][] buffer,
    int i,
    int j,
    boolean[][] visited
  ) {
    if (visited[i][j]) return;
    buffer[i][j] = with;
    visited[i][j] = true;

    for (int[] neighbor : neighbors) {
      int i_ = neighbor[0] + i, j_ = neighbor[1] + j;
      if (
        i_ < 0 ||
        i_ > buffer.length - 1 ||
        j_ < 0 ||
        j_ > buffer[0].length - 1 ||
        buffer[i_][j_] != target
      ) continue;
      fill(target, with, buffer, i_, j_, visited);
    }
  }

  public int[][] floodFill(int[][] image, int sr, int sc, int color) {
    int target, with;
    boolean[][] visited = new boolean[image.length][image[0].length];
    fill(target = image[sr][sc], with = color, image, sr, sc, visited);
    return image;
  }
}

public class _733_Flood_Fill {

  public static void main(String[] args) {
    System.out.println(
      Arrays.deepToString(
        new Solution()
          .floodFill(new int[][] { { 0, 0, 0 }, { 0, 0, 0 } }, 0, 0, 0)
      )
    );
  }
}
