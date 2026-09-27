import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

  private boolean placable(byte[][] mat, int r, int c) {
    // row
    for (int row = 0; row < mat.length; row++) {
      if (mat[row][c] == 1 && r != row) return false;
    }

    // col
    for (int col = 0; col < mat.length; col++) {
      if (mat[r][col] == 1 && c != col) return false;
    }

    // dig-a
    int R = r;
    int C = c;
    while (R >= 0 && C >= 0) {
      if (mat[R][C] == 1 && C != c && R != r) return false;
      R--;
      C--;
    }
    R = r;
    C = c;
    while (R < mat.length && C < mat.length) {
      if (mat[R][C] == 1 && C != c && R != r) return false;
      R++;
      C++;
    }

    // dig-b
    R = r;
    C = c;
    while (R >= 0 && C < mat.length) {
      if (mat[R][C] == 1 && C != c && R != r) return false;
      R--;
      C++;
    }

    R = r;
    C = c;
    while (R < mat.length && C >= 0) {
      if (mat[R][C] == 1 && C != c && R != r) return false;
      R++;
      C--;
    }
    return true;
  }

  private void populateQueens(
    byte[][] mat,
    int n,
    int row,
    List<List<String>> result
  ) {
    if (row == n) {
      List<String> board = new ArrayList<>();
      for (byte[] arr : mat) {
        StringBuilder state = new StringBuilder();
        for (byte b : arr) state.append(b == 1 ? "Q" : ".");
        board.add(state.toString());
      }
      result.add(new ArrayList<>(board));
      return;
    }
    int col;
    for (int i = 0; i < n; i++) {
      if (placable(mat, row, col = i)) {
        mat[row][i] = 1;
        populateQueens(mat, n, row + 1, result);
        mat[row][i] = 0;
      }
    }
  }

  public List<List<String>> solveNQueens(int n) {
    byte[][] matrix = new byte[n][n];
    int row;
    List<List<String>> result = new ArrayList<>();
    populateQueens(matrix, n, row = 0, result);
    return result;
  }
}

public class _51_N_Queens {

  public static void main(String[] args) {
    System.out.println(new Solution().solveNQueens(4));
  }
}
