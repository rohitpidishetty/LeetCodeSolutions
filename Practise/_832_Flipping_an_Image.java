import java.util.Arrays;

class Solution {

  public int[][] flipAndInvertImage(int[][] image) {
    for (int k = 0; k < image.length; k++) {
      int i = 0,
        j = image[i].length - 1;
      while (i < j) {
        int temp = 1 - image[k][i];
        image[k][i] = 1 - image[k][j];
        image[k][j] = temp;
        i++;
        j--;
      }
      if (i == j) image[k][i] = 1 - image[k][i];
    }
    return image;
  }
}

public class _832_Flipping_an_Image {

  public static void main(String[] args) {
    System.out.println(
      Arrays.deepToString(
        new Solution().flipAndInvertImage(
          new int[][] { { 1, 1, 0 }, { 1, 0, 1 }, { 0, 0, 0 } }
        )
      )
    );
  }
}
