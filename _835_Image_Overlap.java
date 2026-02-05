class Solution {

  public int largestOverlap(int[][] img1, int[][] img2) {
    int n = img1.length;
    int maxOverLap = 0;
    for (int r = -n + 1; r <= n - 1; r++) {
      for (int c = -n + 1; c <= n - 1; c++) {
        int count = 0;
        for (int i = 0; i < n; i++) {
          for (int j = 0; j < n; j++) {
            int b_i = r + i,
              b_j = c + j;
            if (b_i < 0 || b_i >= n || b_j < 0 || b_j >= n) continue;
            if (img1[i][j] == img2[b_i][b_j] && img1[i][j] == 1) count++;
          }
        }
        maxOverLap = Math.max(maxOverLap, count);
      }
    }
    return maxOverLap;
  }
}

public class _835_Image_Overlap {

  public static void main(String[] args) {
    System.out.println(
      new Solution().largestOverlap(
        new int[][] { { 1, 1, 0 }, { 0, 1, 0 }, { 0, 1, 0 } },
        new int[][] { { 0, 0, 0 }, { 0, 1, 1 }, { 0, 0, 1 } }
      )
    );
  }
}
