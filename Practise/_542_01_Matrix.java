import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

class Solution {

  // 19 / 50 testcases passed
  // private int[][] memo;

  // private int dfs(int i, int j, int n, int m, int[][] buffer) {

  // if (i > n - 1 || i < 0 || j > m - 1 || j < 0 || buffer[i][j] ==
  // Integer.MAX_VALUE)
  // return Integer.MAX_VALUE;
  // if (this.memo[i][j] != Integer.MAX_VALUE)
  // return this.memo[i][j];

  // if (buffer[i][j] == 0)
  // return 0;
  // int save = buffer[i][j];
  // buffer[i][j] = Integer.MAX_VALUE;
  // int top = dfs(i - 1, j, n, m, buffer);
  // int down = dfs(i + 1, j, n, m, buffer);
  // int left = dfs(i, j - 1, n, m, buffer);
  // int right = dfs(i, j + 1, n, m, buffer);
  // buffer[i][j] = save;
  // int ret = Math.min(Math.min(top, down), Math.min(left, right)) + 1;
  // this.memo[i][j] = ret;
  // return ret;
  // }

  // public int[][] updateMatrix(int[][] mat) {
  // int n = mat.length, m = mat[0].length;
  // this.memo = new int[n][m];
  // int[][] final_mat = new int[n][m];

  // for (int i = 0; i < n; i++)
  // Arrays.fill(this.memo[i], Integer.MAX_VALUE);

  // for (int i = 0; i < n; i++) {
  // for (int j = 0; j < m; j++)
  // final_mat[i][j] = dfs(i, j, n, m, mat);
  // }

  // return final_mat;
  // }

  public int[][] updateMatrix(int[][] mat) {
    int n = mat.length, m = mat[0].length;
    int distMatrix[][] = new int[n][m];
    Queue<int[]> bfsQ = new ArrayDeque<>();
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (mat[i][j] == 0) {
          distMatrix[i][j] = 0;
          bfsQ.offer(new int[] { i, j });
        } else
          distMatrix[i][j] = 100000;
      }
    }
    int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
    while (!bfsQ.isEmpty()) {
      int[] coord = bfsQ.poll();
      for (int[] d : dir) {
        int ni = d[0] + coord[0], nj = d[1] + coord[1];
        if (ni < 0 || ni > n - 1 || nj < 0 || nj > m - 1)
          continue;
        int new_dist = distMatrix[coord[0]][coord[1]] + 1;
        if (new_dist < distMatrix[ni][nj]) {
          distMatrix[ni][nj] = new_dist;
          bfsQ.offer(new int[] { ni, nj });
        }
      }
    }
    return distMatrix;
  }

}

public class _542_01_Matrix {
  public static void main(String[] args) {
    System.out.println(
        Arrays.deepToString(new Solution()
            .updateMatrix(
                new int[][] {
                    { 1, 0, 1, 1, 0, 0, 1, 0, 0, 1 },
                    { 0, 1, 1, 0, 1, 0, 1, 0, 1, 1 },
                    { 0, 0, 1, 0, 1, 0, 0, 1, 0, 0 },
                    { 1, 0, 1, 0, 1, 1, 1, 1, 1, 1 },
                    { 0, 1, 0, 1, 1, 0, 0, 0, 0, 1 },
                    { 0, 0, 1, 0, 1, 1, 1, 0, 1, 0 },
                    { 0, 1, 0, 1, 0, 1, 0, 0, 1, 1 },
                    { 1, 0, 0, 0, 1, 1, 1, 1, 0, 1 },
                    { 1, 1, 1, 1, 1, 1, 1, 0, 1, 0 },
                    { 1, 1, 1, 1, 0, 1, 0, 0, 1, 1 }
                })));
  }
}
