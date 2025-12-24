import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

  private int get1sCountFromNeighbors(
    int i,
    int j,
    int rowLen,
    int colLen,
    int[][] board
  ) {
    int row = i - 1;
    int col = j - 1;
    int ones = 0;
    for (int r = row; r < row + 3; r++) {
      for (int c = col; c < col + 3; c++) {
        if (
          (r == i && c == j) ||
          r < 0 ||
          c < 0 ||
          c > colLen - 1 ||
          r > rowLen - 1
        ) continue;
        if (board[r][c] == 1 || board[r][c] == 2) ones++;
      }
    }
    return ones;
  }

  public void gameOfLife(int[][] board) {
    int row_length = board.length;
    int col_length = board[0].length;
    for (int i = 0; i < row_length; i++) {
      for (int j = 0; j < col_length; j++) {
        int gameChanger = get1sCountFromNeighbors(
          i,
          j,
          row_length,
          col_length,
          board
        );
        if (board[i][j] == 0 && gameChanger == 3) board[i][j] = 3;
        else if (
          board[i][j] == 1 && (gameChanger < 2 || gameChanger > 3)
        ) board[i][j] = 2;
      }
    }
    for (int i = 0; i < row_length; i++) {
      for (int j = 0; j < col_length; j++) {
        if (board[i][j] == 2) board[i][j] = 0;
        else if (board[i][j] == 3) board[i][j] = 1;
      }
    }
  }
}

public class _289_Game_of_Life {

  public static void main(String[] args) {
    int[][] board = new int[][] { { 1, 1 }, { 1, 0 } };
    new Solution().gameOfLife(board);
    System.out.println(Arrays.deepToString(board));
  }
}
