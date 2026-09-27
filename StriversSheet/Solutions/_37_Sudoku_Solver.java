import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {

  private Map<Integer, Set<Character>> row;
  private Map<Integer, Set<Character>> col;
  private Map<String, Set<Character>> block;

  private void preReq(char[][] board) {
    row = new HashMap<>();
    col = new HashMap<>();
    block = new HashMap<>();

    for (int i = 0; i < 9; i++) {
      row.put(i, new HashSet<>());
      col.put(i, new HashSet<>());
    }

    for (int r = 0; r < 9; r++) {
      for (int c = 0; c < 9; c++) {
        String key = (r / 3) + "," + (c / 3);
        block.computeIfAbsent(key, k -> new HashSet<>());
        if (board[r][c] != '.') {
          row.get(r).add(board[r][c]);
          col.get(c).add(board[r][c]);
          block.get(key).add(board[r][c]);
        }
      }
    }
  }

  private boolean placable(char[][] matrix, int r, int c, char v, String key) {
    return (
      !row.get(r).contains(v) &&
      !col.get(c).contains(v) &&
      !block.get(key).contains(v)
    );
  }

  private boolean solve(int r, int c, char[][] board) {
    if (r == 9) return true;
    if (c == 9) return solve(r + 1, c = 0, board);
    if (board[r][c] != '.') return solve(r, c + 1, board);

    for (int value = 1; value <= 9; value++) {
      char val = (char) (value + '0');
      String key = (r / 3) + "," + (c / 3);
      if (placable(board, r, c, val, key)) {
        board[r][c] = val;
        row.get(r).add(val);
        col.get(c).add(val);
        block.get(key).add(val);
        if (solve(r, c + 1, board)) return true;
        board[r][c] = '.';
        row.get(r).remove(val);
        col.get(c).remove(val);
        block.get(key).remove(val);
      }
    }
    return false;
  }

  public void solveSudoku(char[][] board) {
    preReq(board);
    int row, col;
    solve(row = 0, col = 0, board);
  }
}

public class _37_Sudoku_Solver {

  public static void main(String[] args) {
    char[][] board = {
      { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
      { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
      { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
      { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
      { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
      { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
      { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
      { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
      { '.', '.', '.', '.', '8', '.', '.', '7', '9' },
    };
    new Solution().solveSudoku(board);
    System.out.println(Arrays.deepToString(board));
  }
}
