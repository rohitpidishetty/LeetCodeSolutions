class Solution {
  private boolean check(int i, int j, int idx, char[][] board, String word) {
    if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || word.charAt(idx) != board[i][j])
      return false;
    if (idx == word.length() - 1)
      return true;

    char temp = board[i][j];
    board[i][j] = '*';
    boolean ans = (check(i, j + 1, idx + 1, board, word) ||
        check(i, j - 1, idx + 1, board, word) ||
        check(i + 1, j, idx + 1, board, word) ||
        check(i - 1, j, idx + 1, board, word));
    board[i][j] = temp;
    return ans;
  }

  protected boolean exist(char[][] board, String keyword) {
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (board[i][j] == keyword.charAt(0)) {
          // Solution can exist, so check
          if (check(i, j, 0, board, keyword)) {
            return true;
          }
        }
      }
    }
    return false;
  }
}

public class _79_word_search {
  public static void main(String[] args) {
    System.out.println(new Solution().exist(new char[][] {
        { 'A', 'B', 'C', 'D' },
        { 'S', 'F', 'C', 'S' },
        { 'A', 'D', 'E', 'E' }
    }, new String("DFE")));
  }
}
