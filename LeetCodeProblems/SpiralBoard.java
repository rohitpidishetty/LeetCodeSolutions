import java.util.Arrays;

class Solution {
  private static int[][] createBoard(int size) {
    int[][] board = new int[size][size];
    for (int i = 0; i < size; i++)
      board[i] = new int[size];
    return board;
  }

  private int[][] generate(int[][] board) {
    int topToDown = 0;
    int rightToLeft = board.length - 1;
    int leftToRight = 0;
    int bottomToUp = board.length - 1;
    int number = 1;
    int i = -1;
    int j = -1;

    while (topToDown < bottomToUp || topToDown <= bottomToUp) {
      j = topToDown - 1;
      while (++j <= rightToLeft)
        board[topToDown][j] = number++;
      topToDown++;

      i = topToDown - 1;
      while (++i <= bottomToUp)
        board[i][rightToLeft] = number++;
      rightToLeft--;

      j = rightToLeft + 1;
      while (--j >= leftToRight)
        board[bottomToUp][j] = number++;
      bottomToUp--;

      i = bottomToUp + 1;
      while (--i >= topToDown)
        board[i][leftToRight] = number++;
      leftToRight++;
    }

    return board;
  }

  public int[][] generateMatrix(int n) {
    return generate(createBoard(n));
  }
}

public class SpiralBoard {
  public static void main(String[] args) {
    System.out.println(Arrays.deepToString(new Solution().generateMatrix(9)));
  }
}