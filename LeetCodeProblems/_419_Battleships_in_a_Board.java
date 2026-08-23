import java.util.Arrays;

class Solution {

  public int countBattleships(char[][] board) {
    int threshold = 0;
    boolean present = false;
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        if (board[i][j] == '.') continue;
        present = true;
        if (j == 0) {
          if (i == 0 && board[i][j] != '.') {
            threshold++;
            board[i][j] = (char) (threshold + '0');
          } else if (board[i][j] != '.') {
            if (board[i - 1][j] != '.') board[i][j] = board[i - 1][j];
            else {
              threshold++;
              board[i][j] = (char) (threshold + '0');
            }
          }
        } else {
          if (board[i][j - 1] != '.') board[i][j] = board[i][j - 1];
          else if (i > 0 && board[i - 1][j] != '.') board[i][j] = board[i -
            1][j];
          else {
            threshold++;
            board[i][j] = (char) (threshold + '0');
          }
        }
      }
    }
    // System.out.println(Arrays.deepToString(board));
    return present ? threshold : 0;
  }
}

public class _419_Battleships_in_a_Board {

  public static void main(String[] args) {
    System.out.println(
      new Solution()
        .countBattleships(new char[][] { { '.', '.' }, { 'X', 'X' } })
    );
  }
}
