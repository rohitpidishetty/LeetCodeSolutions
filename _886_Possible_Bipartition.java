import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

class Solution {

  public boolean possibleBipartition(int n, int[][] dislikes) {
    List<List<Integer>> graph = new ArrayList<>();
    int[] color = new int[n + 1];
    for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());
    for (int[] edge : dislikes) {
      graph.get(edge[0]).add(edge[1]);
      graph.get(edge[1]).add(edge[0]);
    }
    for (int i = 1; i <= n; i++) {
      int colorCode = 0;
      Arrays.fill(color, -1);
      color[i] = colorCode;
      Queue<Integer> bfsQ = new ArrayDeque<>();
      bfsQ.offer(i);
      while (!bfsQ.isEmpty()) {
        int s = bfsQ.size();
        colorCode = 1 - colorCode;
        while (s > 0) {
          int currentNode = bfsQ.poll();
          for (int neighbor : graph.get(currentNode)) {
            // Unvisited node == Uncolored node
            if (color[neighbor] == color[currentNode]) return false;
            if (color[neighbor] == -1) {
              color[neighbor] = colorCode;
              bfsQ.offer(neighbor);
            }
          }
          s--;
        }
      }
    }
    return true;
  }
}

public class _886_Possible_Bipartition {

  public static void main(String[] args) {
    System.out.println(
      new Solution().possibleBipartition(
        3,
        new int[][] { { 1, 2 }, { 1, 3 }, { 2, 3 } }
      )
    );
    System.out.println(
      new Solution().possibleBipartition(
        4,
        new int[][] { { 1, 2 }, { 1, 3 }, { 2, 4 } }
      )
    );
    System.out.println(
      new Solution().possibleBipartition(
        5,
        new int[][] { { 1, 2 }, { 3, 4 }, { 4, 5 } }
      )
    );
    System.out.println(
      new Solution().possibleBipartition(
        4,
        new int[][] { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 4, 1 }, { 1, 3 } }
      )
    );

    System.out.println(
      new Solution().possibleBipartition(
        10,
        new int[][] {
          { 4, 7 },
          { 4, 8 },
          { 5, 6 },
          { 1, 6 },
          { 3, 7 },
          { 2, 5 },
          { 5, 8 },
          { 1, 2 },
          { 4, 9 },
          { 6, 10 },
          { 8, 10 },
          { 3, 6 },
          { 2, 10 },
          { 9, 10 },
          { 3, 9 },
          { 2, 3 },
          { 1, 9 },
          { 4, 6 },
          { 5, 7 },
          { 3, 8 },
          { 1, 8 },
          { 1, 7 },
          { 2, 4 },
        }
      )
    );
  }
}
