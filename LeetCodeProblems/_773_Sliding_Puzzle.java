import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

class Solution {

  private class BoardState {

    protected int[][] board;
    protected int emptyBlock[];

    BoardState(int[][] board, int emptyBlock[]) {
      this.board = board;
      this.emptyBlock = emptyBlock;
    }
  }

  public int slidingPuzzle(int[][] board) {
    Set<String> boardStates = new HashSet<>();
    Queue<BoardState> bfsQ = new ArrayDeque<>();

    String haltState = Arrays.deepToString(
      new int[][] { { 1, 2, 3 }, { 4, 5, 0 } }
    );

    if (Arrays.deepToString(board).equals(haltState)) return 0;
    int position[] = new int[2];
    for (int j = 0; j < 3; j++) {
      if (board[0][j] == 0) {
        position[0] = 0;
        position[1] = j;
        break;
      } else if (board[1][j] == 0) {
        position[0] = 1;
        position[1] = j;
        break;
      }
    }

    int[][] neighbors = new int[][] {
      { -1, 0 },
      { 1, 0 },
      { 0, -1 },
      { 0, 1 },
    };
    int level = 1;
    bfsQ.offer(new BoardState(board, position));
    while (!bfsQ.isEmpty()) {
      int n = bfsQ.size();
      for (int i = 0; i < n; i++) {
        BoardState state = bfsQ.poll();

        for (int[] neighbor : neighbors) {
          int _i = neighbor[0] + state.emptyBlock[0], _j =
            neighbor[1] + state.emptyBlock[1];
          if (_i < 0 || _i > 1 || _j < 0 || _j > 2) continue;
          int buffer[][] = new int[2][3];
          buffer[0] = Arrays.copyOf(state.board[0], 3);
          buffer[1] = Arrays.copyOf(state.board[1], 3);
          int temp = state.board[_i][_j];
          buffer[_i][_j] = 0;
          buffer[state.emptyBlock[0]][state.emptyBlock[1]] = temp;
          String board_state = Arrays.deepToString(buffer);
          if (board_state.equals(haltState)) return level;
          if (!boardStates.contains(board_state)) {
            bfsQ.offer(new BoardState(buffer, new int[] { _i, _j }));
            boardStates.add(board_state);
          }
        }
      }
      level++;
    }
    return -1;
  }
}

public class _773_Sliding_Puzzle {

  public static void main(String[] args) {
    System.out.println(
      new Solution().slidingPuzzle(new int[][] { { 4, 1, 2 }, { 5, 0, 3 } })
    );
  }
}
