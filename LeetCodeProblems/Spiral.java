import java.util.List;
import java.util.ArrayList;

class Solution {
  public List<Integer> spiralOrder(int[][] matrix) {
    int rowMag = matrix.length;
    int colMag = matrix[0].length;

    int b1 = 0; // row
    int b4 = 0; // col
    int b2 = colMag - 1;
    int b3 = rowMag - 1;
    List<Integer> res = new ArrayList<>();
    while (b1 <= b3 && b4 <= b2) {

      int rightPointer = b4;
      while (rightPointer <= b2)
        res.add(matrix[b1][rightPointer++]);

      b1++;
      int downPointer = b1;
      while (downPointer <= b3)
        res.add(matrix[downPointer++][b2]);

      b2--;
      if (b1 <= b3) {
        int leftPointer = b2;
        while (leftPointer >= b4)
          res.add(matrix[b3][leftPointer--]);

        b3--;
      }
      if (b4 <= b2) {
        int upPointer = b3;
        while (upPointer >= b1)
          res.add(matrix[upPointer--][b4]);

        b4++;
      }
    }

    return res;
  }
}

public class Spiral {
  public static void main(String[] args) {
    System.out.println(new Solution().spiralOrder(new int[][] {
        { 1, 2, 3, 4 },
        { 5, 6, 7, 8 },
        { 9, 10, 11, 12 }
    }));
  }
}
