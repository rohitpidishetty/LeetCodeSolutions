class Solution {

  public boolean searchMatrix(int[][] matrix, int target) {
    int l = 0;
    int n = matrix.length;
    int h = matrix[0].length - 1;
    while (l < n && h >= 0) {
      if (matrix[l][h] == target) return true;
      else if (target < matrix[l][h]) h--;
      else l++;
    }
    return false;
  }
}

public class _240_Search_a_2D_Matrix_II {

  public static void main(String[] args) {
    System.out.println(
      new Solution().searchMatrix(
        new int[][] {
          { 1, 4, 7, 11, 15 },
          { 2, 5, 8, 12, 19 },
          { 3, 6, 9, 16, 22 },
          { 10, 13, 14, 17, 24 },
          { 18, 21, 23, 26, 30 },
        },
        5
      )
    );
  }
}
