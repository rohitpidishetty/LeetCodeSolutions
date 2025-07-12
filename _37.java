import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Solution {
  private Map<String, List<Integer>> exclusiveBlockMap;
  private Map<Integer, Set<Integer>> exclusiveRows;
  private Map<Integer, Set<Integer>> exclusiveCols;
  private boolean solved = false;

  private void generateHashMapForEachBlock(char[][] board) {
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board.length; j++) {
        String BLOCK_NAME = (i / 3) + "," + (j / 3);
        List<Integer> blockElements = new ArrayList<>();
        for (int k = i; k < i + 3; k++)
          for (int kr = j; kr < j + 3; kr++)
            if (board[k][kr] != '.')
              blockElements.add(board[k][kr] - '0');
        exclusiveBlockMap.put(BLOCK_NAME, blockElements);
        j += 2;
      }
      i += 2;
    }
  }

  private void generateHashMapForEachRow(char[][] board) {
    for (int i = 0; i < board.length; i++) {
      Set<Integer> setElements = new HashSet<>();
      for (int j = 0; j < board[i].length; j++)
        if (board[i][j] != '.')
          setElements.add(board[i][j] - '0');
      exclusiveRows.put(i, setElements);
    }
  }

  private void generateHashMapForEachCol(char[][] board) {
    for (int j = 0; j < board.length; j++) {
      Set<Integer> setElements = new HashSet<>();
      for (int i = 0; i < board.length; i++)
        if (board[i][j] != '.')
          setElements.add(board[i][j] - '0');
      exclusiveCols.put(j, setElements);
    }
  }

  private void solve(char[][] board, int row, int col) {

    if (row == 9) {
      solved = true;
      return;
    }

    if (col == 9) {
      solve(board, row + 1, 0);
      return;
    }

    if (board[row][col] != '.') {
      solve(board, row, col + 1);
      return;
    }

    Set<Integer> consider = new HashSet<>(Set.of(1, 2, 3, 4, 5, 6, 7, 8, 9));
    Set<Integer> ex = new HashSet<>();
    ex.addAll(exclusiveBlockMap.get((row / 3) + "," + (col / 3)));
    ex.addAll(exclusiveRows.get(row));
    ex.addAll(exclusiveCols.get(col));
    consider.removeAll(ex);
    for (Integer val : consider) {
      char placed = (char) (val + '0');
      exclusiveBlockMap.get((row / 3) + "," + (col / 3)).add(val);
      exclusiveRows.get(row).add(val);
      exclusiveCols.get(col).add(val);
      board[row][col] = placed;
      solve(board, row, col + 1);
      if (solved)
        return;
      exclusiveBlockMap.get((row / 3) + "," + (col / 3)).remove(val);
      exclusiveRows.get(row).remove(val);
      exclusiveCols.get(col).remove(val);
      board[row][col] = '.';

    }

  }

  public boolean solveSudoku(char[][] board) {
    exclusiveBlockMap = new HashMap<>();
    exclusiveRows = new HashMap<>();
    exclusiveCols = new HashMap<>();
    generateHashMapForEachBlock(board);
    generateHashMapForEachRow(board);
    generateHashMapForEachCol(board);
    solve(board, 0, 0);
    return solved;
  }
}

public class _37 {
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
        { '.', '.', '.', '.', '8', '.', '.', '7', '9' }
    };
    System.out.println(new Solution().isValidSudoku(board));
  }
}
