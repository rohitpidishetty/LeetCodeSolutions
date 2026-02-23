import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

class Solution {

  public int shortestPathAllKeys(String[] grid) {
    int n = grid.length;
    int m = grid[0].length();

    Set<String> visited = new HashSet<>();
    int[] startingState = new int[3];
    int finalState = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        char c = grid[i].charAt(j);
        if (c == '@') {
          startingState = new int[] { i, j, 0 };
          visited.add(i + ":" + j + ":" + 0);
        } else if (c >= 'a' && c <= 'z') finalState |= (1 << (c - 'a'));
      }
    }
    Queue<int[]> bfsQueue = new ArrayDeque<>();
    bfsQueue.add(startingState);
    int[][] neighbors = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
    int level = 0;
    while (!bfsQueue.isEmpty()) {
      int s = bfsQueue.size();
      while (s > 0) {
        int[] currentState = bfsQueue.poll();
        if (currentState[2] == finalState) return level;
        for (int[] neighbor : neighbors) {
          int i_ = (neighbor[0] + currentState[0]),
            j_ = (currentState[1] + neighbor[1]);
          if (
            i_ < 0 ||
            i_ >= n ||
            j_ < 0 ||
            j_ >= m ||
            visited.contains(i_ + ":" + j_ + ":" + currentState[2]) ||
            grid[i_].charAt(j_) == '#'
          ) continue;
          int loc = (int) grid[i_].charAt(j_);
          // If this loc has key, we need to pick it up.
          int nextState = (loc >= 97 && loc <= 122)
            ? (currentState[2] | (1 << (loc - 97)))
            : currentState[2];

          boolean includeState = true;
          if (loc >= 65 && loc <= 90) {
            if (((currentState[2] & (1 << (loc - 65))) == 0)) {
              // Its a set bit
              continue;
            }
          }
          bfsQueue.add(new int[] { i_, j_, nextState });
          visited.add(i_ + ":" + j_ + ":" + nextState);
        }
        s--;
      }
      level++;
    }
    return -1;
  }
}

public class _864_Shortest_Path_to_Get_All_Keys {

  public static void main(String[] args) {
    System.out.println(
      new Solution().shortestPathAllKeys(
        new String[] { "@..aA", "..B#.", "....b" }
      )
    );
    System.out.println(
      new Solution().shortestPathAllKeys(
        new String[] { "@.a..", "###.#", "b.A.B" }
      )
    );
  }
}
