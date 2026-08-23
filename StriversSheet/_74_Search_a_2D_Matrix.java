class Solution {

  public boolean searchMatrix(int[][] matrix, int target) {
    if (
      matrix == null || matrix.length == 0 || matrix[0].length == 0
    ) return false;
    int lb = 0;
    int ub = matrix.length - 1;
    int j = matrix[0].length - 1;
    while (lb <= ub) {
      int mid = (lb + (ub - lb) / 2);
      if (target < matrix[mid][0]) ub = mid - 1;
      else if (target > matrix[mid][j]) lb = mid + 1;
      else {
        int l = 0;
        int u = j;
        while (l <= u) {
          int m = (l + (u - l) / 2);
          if (matrix[mid][m] == target) return true;
          else if (matrix[mid][m] < target) l = m + 1;
          else u = m - 1;
        }
        return false;
      }
    }
    return false;
  }
}

public class _74_Search_a_2D_Matrix {

  public static void main(String[] args) {
    System.out.println(
      new Solution().searchMatrix(new int[][] { { 1, 3, 5, 7 } }, 50)
    );
  }
}
