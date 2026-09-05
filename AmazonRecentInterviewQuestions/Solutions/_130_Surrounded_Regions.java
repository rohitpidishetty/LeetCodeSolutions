import java.util.Arrays;

class Solution {

  private void expand(int i, int j, int n, int m, char[][] board) {
    if (
      i < 0 ||
      i >= n ||
      j < 0 ||
      j >= m ||
      board[i][j] == 'Z' ||
      board[i][j] == 'X'
    ) return;
    board[i][j] = 'Z';
    expand(i + 1, j, n, m, board);
    expand(i - 1, j, n, m, board);
    expand(i, j + 1, n, m, board);
    expand(i, j - 1, n, m, board);
  }

  public void solve(char[][] board) {
    int i = 0;
    int j = 0;
    int n = board.length;
    int m = board[i].length;
    for (; j < m; j++) if (board[i][j] == 'O') expand(i, j, n, m, board);
    j--;
    for (; i < n; i++) if (board[i][j] == 'O') expand(i, j, n, m, board);
    i--;
    for (; j > -1; j--) if (board[i][j] == 'O') expand(i, j, n, m, board);
    j++;
    for (; i > -1; i--) if (board[i][j] == 'O') expand(i, j, n, m, board);

    for (i = 0; i < n; i++) {
      for (j = 0; j < m; j++) if (board[i][j] == 'O') board[i][j] = 'X';
    }

    for (i = 0; i < n; i++) {
      for (j = 0; j < m; j++) if (board[i][j] == 'Z') board[i][j] = 'O';
    }
  }
}

public class _130_Surrounded_Regions {

  public static void main(String[] args) {
    char[][] board = {
      { 'X', 'X', 'X', 'X' },
      { 'X', 'O', 'O', 'X' },
      { 'X', 'X', 'O', 'X' },
      { 'X', 'O', 'X', 'X' },
    };
    new Solution().solve(board);
  }
}
