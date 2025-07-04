import java.util.Arrays;

class Solution {

  private void discardFromTop(char[][] board, int start_row, int start_col) {
    if (start_row < 0 || start_row >= board.length || start_col > board[0].length - 1 || start_col < 0)
      return;
    if (board[start_row][start_col] != 'O')
      return;
    board[start_row][start_col] = 'D';
    discardFromTop(board, start_row - 1, start_col);
    discardFromTop(board, start_row + 1, start_col);
    discardFromTop(board, start_row, start_col - 1);
    discardFromTop(board, start_row, start_col + 1);
  }

  private void discardFromBottom(char[][] board, int start_row, int start_col) {
    if (start_row < 0 || start_col > board[0].length - 1 || start_col < 0)
      return;
    if (board[start_row][start_col] != 'O')
      return;
    board[start_row][start_col] = 'D';
    discardFromBottom(board, start_row - 1, start_col);
    discardFromBottom(board, start_row, start_col - 1);
    discardFromBottom(board, start_row, start_col + 1);
  }

  private void discardFromLeft(char[][] board, int start_row, int start_col) {
    if (start_row < 0 || start_row >= board.length || start_col > board[0].length - 1)
      return;
    if (board[start_row][start_col] != 'O')
      return;
    board[start_row][start_col] = 'D';
    discardFromTop(board, start_row + 1, start_col);
    discardFromLeft(board, start_row - 1, start_col);
    discardFromLeft(board, start_row, start_col + 1);
  }

  private void discardFromRight(char[][] board, int start_row, int start_col) {
    if (start_row < 0 || start_row >= board.length | start_col < 0)
      return;
    if (board[start_row][start_col] != 'O')
      return;
    board[start_row][start_col] = 'D';
    discardFromRight(board, start_row + 1, start_col);
    discardFromRight(board, start_row - 1, start_col);
    discardFromRight(board, start_row, start_col - 1);
  }

  public void solve(char[][] board) {
    for (int j = 0; j < board[0].length; j++)
      if (board[0][j] == 'O')
        discardFromTop(board, 0, j);

    for (int i = 0; i < board.length; i++) {

      for (int j = 0; j < board[i].length; j++) {

        System.out.print(board[i][j] + " ");
      }
      System.out.println();
    }

    for (int j = 0; j < board[0].length; j++)
      if (board[board.length - 1][j] == 'O')
        discardFromBottom(board, board.length - 1, j);

    for (int i = 0; i < board.length; i++)
      if (board[i][0] == 'O')
        discardFromLeft(board, i, 0);

    for (int i = 0; i < board.length; i++)
      if (board[i][board[0].length - 1] == 'O')
        discardFromRight(board, i, board[0].length - 1);

    for (int i = 0; i < board.length; i++)
      for (int j = 0; j < board[i].length; j++)
        if (board[i][j] == 'O')
          board[i][j] = 'X';

    for (int i = 0; i < board.length; i++)
      for (int j = 0; j < board[i].length; j++)
        if (board[i][j] == 'D')
          board[i][j] = 'O';

    System.out.println(Arrays.deepToString(board));
  }
}

public class _130_Surrounded_Regions {
  public static void main(String[] args) {
    char[][] board = new char[][] {
        { 'X', 'O', 'X', 'O', 'O', 'O', 'O' },
        { 'X', 'O', 'O', 'O', 'O', 'O', 'O' },
        { 'X', 'O', 'O', 'O', 'O', 'X', 'O' },
        { 'O', 'O', 'O', 'O', 'X', 'O', 'X' },
        { 'O', 'X', 'O', 'O', 'O', 'O', 'O' },
        { 'O', 'O', 'O', 'O', 'O', 'O', 'O' },
        { 'O', 'X', 'O', 'O', 'O', 'O', 'O' }
    };

    new Solution().solve(board);
  }
}