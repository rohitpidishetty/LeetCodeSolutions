// import java.util.ArrayList;
// import java.util.Arrays;
// import java.util.List;

// class Solution {

//   private class quad {

//     protected boolean canReachTop;
//     protected boolean canReachBottom;
//     protected boolean canReachRight;
//     protected boolean canReachLeft;
//   }

//   public List<List<Integer>> pacificAtlantic(int[][] heights) {
//     int n = heights.length;
//     int m = heights[0].length;
//     quad[][] board = new quad[n][m];
//     for (int i = 0; i < n; i++) for (int j = 0; j < m; j++) board[i][j] =
//       new quad();

//     for (int j = 0; j < m; j++) {
//       board[0][j].canReachTop = true;
//       board[n - 1][j].canReachBottom = true;
//     }

//     for (int i = 0; i < n; i++) {
//       board[i][0].canReachLeft = true;
//       board[i][m - 1].canReachRight = true;
//     }

//     // Top:1, Down:2, Left:3, Right:4
//     int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
//     for (int i = 0; i < n; i++) {
//       for (int j = 0; j < m; j++) {
//         for (int[] direction : dir) {
//           int ni = i + direction[0];
//           int nj = j + direction[1];
//           if (ni > -1 && ni < n && nj > -1 && nj < m) {
//             if (heights[ni][nj] >= heights[i][j]) {
//               if (board[i][j].canReachTop) board[ni][nj].canReachBottom = true;
//               else if (board[i][j].canReachBottom) board[ni][nj].canReachTop =
//                 true;
//               else if (board[i][j].canReachLeft) board[ni][nj].canReachRight =
//                 true;
//               else if (board[i][j].canReachRight) board[ni][nj].canReachLeft =
//                 true;
//             }
//           }
//         }
//       }
//     }

//     List<List<Integer>> buffer = new ArrayList<>();
//     for (int i = 0; i < n; i++) {
//       for (int j = 0; j < m; j++) {
//         if (
//           (board[i][j].canReachLeft && board[i][j].canReachBottom) ||
//           (board[i][j].canReachTop && board[i][j].canReachRight)
//         ) buffer.add(Arrays.asList(i, j));
//       }
//     }
//     return buffer;
//   }
// }

// public class _417_Pacific_Atlantic_Water_Flow {

//   public static void main(String[] args) {
//     System.out.println(new Solution().pacificAtlantic(new int[][] { { 1 } }));
//   }
// }

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

  private int[][] heights;
  private int n, m;

  public List<List<Integer>> pacificAtlantic(int[][] heights) {
    this.heights = heights;
    n = heights.length;
    m = heights[0].length;

    boolean[][] pacific = new boolean[n][m];
    boolean[][] atlantic = new boolean[n][m];

    for (int i = 0; i < n; i++) dfs(i, 0, pacific);
    for (int j = 0; j < m; j++) dfs(0, j, pacific);
    for (int i = 0; i < n; i++) dfs(i, m - 1, atlantic);
    for (int j = 0; j < m; j++) dfs(n - 1, j, atlantic);

    List<List<Integer>> result = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (pacific[i][j] && atlantic[i][j]) result.add(Arrays.asList(i, j));
      }
    }
    return result;
  }

  private void dfs(int i, int j, boolean[][] visited) {
    if (visited[i][j]) return;
    visited[i][j] = true;

    int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
    for (int[] d : dir) {
      int ni = i + d[0], nj = j + d[1];
      if (
        ni >= 0 &&
        ni < n &&
        nj >= 0 &&
        nj < m &&
        heights[ni][nj] >= heights[i][j]
      ) {
        dfs(ni, nj, visited);
      }
    }
  }
}

public class _417_Pacific_Atlantic_Water_Flow {

  public static void main(String[] args) {
    System.out.println(
      new Solution()
        .pacificAtlantic(
          new int[][] {
            { 1, 2, 2, 3, 5 },
            { 3, 2, 3, 4, 4 },
            { 2, 4, 5, 3, 1 },
            { 6, 7, 1, 4, 5 },
            { 5, 1, 1, 2, 4 },
          }
        )
    );
  }
}
