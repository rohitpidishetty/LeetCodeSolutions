import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

class Solution {

  private class Tuple<E> {

    protected E buffer[];

    Tuple(E... buffer) {
      this.buffer = buffer;
    }

    @Override
    public String toString() {
      return Arrays.toString(this.buffer).replace("[", "(").replace("]", ")");
    }
  }

  public int swimInWater(int[][] grid) {
    PriorityQueue<Tuple<Integer>> pQ = new PriorityQueue<>(
      (a, b) -> a.buffer[0] - b.buffer[0]
    );

    boolean[][] visited = new boolean[grid.length][grid[0].length];

    // (next, i_coordinate, j_coordinate)
    int time = 0;
    int[][] neighbors = new int[][] {
      { -1, 0 },
      { 1, 0 },
      { 0, -1 },
      { 0, 1 },
    };

    pQ.add(new Tuple<Integer>(grid[0][0], 0, 0));

    while (!pQ.isEmpty()) {
      Tuple<Integer> top = pQ.poll();
      int nextPath = top.buffer[0];
      int curr_i_coord = top.buffer[1], curr_j_coord = top.buffer[2];
      if (
        curr_i_coord == grid.length - 1 && curr_j_coord == grid[0].length - 1
      ) return nextPath;
      for (int neighbor[] : neighbors) {
        int next_i = (neighbor[0] + curr_i_coord);
        int next_j = (neighbor[1] + curr_j_coord);
        if (
          next_i < 0 ||
          next_i >= grid.length ||
          next_j < 0 ||
          next_j >= grid[0].length
        ) continue;
        int ele = grid[next_i][next_j];

        if (!visited[next_i][next_j]) {
          pQ.offer(new Tuple<Integer>(Math.max(nextPath, ele), next_i, next_j));
          visited[next_i][next_j] = true;
        }
      }
    }

    return -1;
  }
}

public class _778_Swim_in_Rising_Water {

  public static void main(String[] args) {
    System.out.println(
      new Solution().swimInWater(new int[][] { { 0, 2 }, { 1, 3 } })
    );
  }
}
