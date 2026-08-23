import java.util.Arrays;

class Solution {
  public char[][] updateBoard(char[][] board, int[] click) {
    int row = click[0], col = click[1];

    if (board[row][col] == 'M') {
      board[row][col] = 'X';
      return board;
    }

    dfs(board, row, col);
    return board;
  }

  private void dfs(char[][] board, int row, int col) {
    if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] != 'E') {
      return;
    }

    int[] dx = { -1, -1, -1, 0, 0, 1, 1, 1 };
    int[] dy = { -1, 0, 1, -1, 1, -1, 0, 1 };

    int mines = 0;

    for (int i = 0; i < 8; i++) {
      int x = row + dx[i], y = col + dy[i];
      if (x >= 0 && x < board.length && y >= 0 && y < board[0].length && board[x][y] == 'M') {
        mines++;
      }
    }

    if (mines > 0) {
      board[row][col] = (char) (mines + '0');
      return;
    }

    board[row][col] = 'B';

    for (int i = 0; i < 8; i++) {
      int x = row + dx[i], y = col + dy[i];
      dfs(board, x, y);
    }
  }
}

public class _529_Minesweeper {
  public static void main(String[] args) {
    System.out.println(Arrays.toString(new Solution()
        .updateBoard(
            new char[][] {
                { 'E', 'E', 'E', 'E', 'E' },
                { 'E', 'E', 'M', 'E', 'E' },
                { 'E', 'E', 'E', 'E', 'E' },
                { 'E', 'E', 'E', 'E', 'E' }
            },
            new int[] { 3, 0 })));
  }
}
