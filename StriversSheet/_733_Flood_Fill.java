import java.util.Arrays;

class Solution {

  private void dfs(
    int buff[][],
    int i,
    int j,
    int c,
    boolean visited[][],
    int sc
  ) {
    if (
      i < 0 ||
      i >= buff.length ||
      j < 0 ||
      j >= buff[0].length ||
      visited[i][j] ||
      buff[i][j] != sc
    ) return;
    visited[i][j] = true;
    buff[i][j] = c;
    dfs(buff, i - 1, j, c, visited, sc);
    dfs(buff, i, j - 1, c, visited, sc);
    dfs(buff, i + 1, j, c, visited, sc);
    dfs(buff, i, j + 1, c, visited, sc);
  }

  public int[][] floodFill(int[][] image, int sr, int sc, int color) {
    boolean[][] visited = new boolean[image.length][image[0].length];

    dfs(image, sr, sc, color, visited, image[sr][sc]);
    return image;
  }
}

public class _733_Flood_Fill {

  public static void main(String[] args) {
    System.out.println(
      Arrays.deepToString(
        new Solution().floodFill(
          new int[][] { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } },
          1,
          1,
          2
        )
      )
    );
    System.out.println(
      Arrays.deepToString(
        new Solution().floodFill(
          new int[][] { { 0, 0, 0 }, { 0, 0, 0 } },
          1,
          0,
          2
        )
      )
    );
  }
}
