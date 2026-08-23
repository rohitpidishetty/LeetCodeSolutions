class Solution {

  public boolean searchMatrix(int[][] matrix, int target) {
    int row = 0;
    int col = matrix[row].length - 1;
    while (row < matrix.length && col >= 0) {
      if (matrix[row][col] == target) return true;
      else if (matrix[row][col] > target) col--;
      else row++;
    }
    return false;
  }
}

public class _240_Search_a_2D_Matrix_II {

  public static void main(String[] args) {
    System.out.println(
      new Solution()
        .searchMatrix(
          new int[][] {
            { 1, 4, 7, 11, 15 },
            { 2, 5, 8, 12, 19 },
            { 3, 6, 9, 16, 22 },
            { 10, 13, 14, 17, 24 },
            { 18, 21, 23, 26, 30 },
          },
          32
        )
    );
  }
}
