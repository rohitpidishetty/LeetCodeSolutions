class Solution {

  public boolean validTicTacToe(String[] board) {
    int X = 0;
    int O = 0;
    for (String row : board) {
      for (int i = 0; i < 3; i++) {
        if (row.charAt(i) == 'X') X++;
        else if (row.charAt(i) == 'O') O++;
      }
    }
    if (X == O) {
      if (
        board[0].equals("XXX") ||
        board[1].equals("XXX") ||
        board[2].equals("XXX")
      ) return false;

      if (
        ('X' == (board[0].charAt(0)) &&
          'X' == (board[1].charAt(0)) &&
          'X' == (board[2].charAt(0))) ||
        ('X' == (board[0].charAt(1)) &&
          'X' == (board[1].charAt(1)) &&
          'X' == (board[2].charAt(1))) ||
        ('X' == (board[0].charAt(2)) &&
          'X' == (board[1].charAt(2)) &&
          'X' == (board[2].charAt(2))) ||
        ('X' == (board[0].charAt(0)) &&
          'X' == (board[1].charAt(1)) &&
          'X' == (board[2].charAt(2))) ||
        ('X' == (board[0].charAt(2)) &&
          'X' == (board[1].charAt(1)) &&
          'X' == (board[2].charAt(0)))
      ) return false;

      return true;
    }
    if (X == O + 1) {
      if (
        board[0].equals("OOO") ||
        board[1].equals("OOO") ||
        board[2].equals("OOO")
      ) return false;
      if (
        ('O' == (board[0].charAt(0)) &&
          'O' == (board[1].charAt(0)) &&
          'O' == (board[2].charAt(0))) ||
        ('O' == (board[0].charAt(1)) &&
          'O' == (board[1].charAt(1)) &&
          'O' == (board[2].charAt(1))) ||
        ('O' == (board[0].charAt(2)) &&
          'O' == (board[1].charAt(2)) &&
          'O' == (board[2].charAt(2))) ||
        ('O' == (board[0].charAt(0)) &&
          'O' == (board[1].charAt(1)) &&
          'O' == (board[2].charAt(2))) ||
        ('O' == (board[0].charAt(2)) &&
          'O' == (board[1].charAt(1)) &&
          'O' == (board[2].charAt(0)))
      ) return false;
      return true;
    }
    return false;
  }
}

public class _794_Valid_Tic_Tac_Toe_State {

  public static void main(String[] args) {
    System.out.println(
      new Solution().validTicTacToe(new String[] { "XOX", " X ", "   " })
    );

    System.out.println(
      new Solution().validTicTacToe(new String[] { "XOX", "O O", "XOX" })
    );

    System.out.println(
      new Solution().validTicTacToe(new String[] { "XXX", "   ", "OOO" })
    );

    System.out.println(
      new Solution().validTicTacToe(new String[] { "XO ", "XO ", "XO " })
    );

    System.out.println(
      new Solution().validTicTacToe(new String[] { "OXX", "XOX", "OXO" })
    );

    System.out.println(
      new Solution().validTicTacToe(new String[] { "XXO", "XOX", "OXO" })
    );
  }
}
