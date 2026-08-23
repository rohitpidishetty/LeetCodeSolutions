import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {
  private static boolean isSafe(List<List<String>> board, int row, int col, int size) {
    // checking-row
    for (int j = 0; j < size; j++) {
      if (j == col)
        continue;
      if (board.get(row).get(j).equals("Q"))
        return false;
    }
    // checking-col
    for (int i = 0; i < size; i++) {
      if (i == row)
        continue;
      if (board.get(i).get(col).equals("Q"))
        return false;
    }
    // Diagonal-1
    int i = row;
    int j = col;
    while (--j >= 0 && --i >= 0) {
      if (board.get(i).get(j).equals("Q"))
        return false;
    }
    // Diagonal-2
    i = row;
    j = col;
    while (--j >= 0 && ++i < size) {
      if (board.get(i).get(j).equals("Q"))
        return false;
    }
    return true;
  }

  private static boolean solve(int queen_count, List<List<String>> board, int row, int columns) {
    /**
     * Base condition
     */
    if (row == columns)
      return true;

    for (int j = 0; j < columns; j++) {
      if (isSafe(board, row, j, columns)) {
        board.get(row).set(j, "Q");
        if (solve(queen_count, board, row + 1, columns))
          return true;
        board.get(row).set(j, ".");
      }
      // if safe
      // // place
      // // // solve for next row
    }
    return false;
  }

  public List<List<String>> solveNQueens(int n) {
    List<List<String>> board = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      List<String> row = new ArrayList<>();
      for (int j = 0; j < n; j++)
        row.add(".");
      board.add(row);
    }

    NQueens.solve(n, board, 0, n);
    return board;
  }

  public static void main(String[] args) {
    System.out.println((new NQueens().solveNQueens(4)));
  }
}