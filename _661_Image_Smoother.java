import java.util.Arrays;

class Solution {

  public int[][] imageSmoother(int[][] img) {
    int n = img.length, m = img[0].length;
    int[][] newImg = new int[n][m];
    int[][] neighbors = {
      { 0, 1 },
      { 1, 0 },
      { 0, -1 },
      { -1, 0 },
      { -1, -1 },
      { 1, 1 },
      { -1, 1 },
      { 1, -1 },
    };
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        int avgOf = 1, sum = img[i][j];
        for (int neighbor[] : neighbors) {
          int I = (i + neighbor[0]), J = (j + neighbor[1]);
          if (!(I < 0 || J > m - 1 || I > n - 1 || J < 0)) {
            sum += img[I][J];
            avgOf++;
          }
        }
        newImg[i][j] = sum / avgOf;
      }
    }
    return newImg;
  }
}

public class _661_Image_Smoother {

  public static void main(String[] args) {
    System.out.println(
      Arrays.deepToString(
        new Solution()
          .imageSmoother(
            new int[][] {
              { 100, 200, 100 },
              { 200, 50, 200 },
              { 100, 200, 100 },
            }
          )
      )
    );
  }
}
