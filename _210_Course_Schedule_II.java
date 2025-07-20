import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class Solution {

  private int order[];

  private boolean detectCycle(
    Map<Integer, List<Integer>> graph,
    int numCourses,
    int[] inDegrees
  ) {
    Queue<Integer> bfsQ = new ArrayDeque<>();

    for (int i = 0; i < numCourses; i++) if (inDegrees[i] == 0) bfsQ.offer(i);
    int visitedNeighborCount = 0;
    order = new int[numCourses];
    while (!bfsQ.isEmpty()) {
      order[visitedNeighborCount++] = bfsQ.peek();
      for (int neighbor : graph.get(bfsQ.poll())) {
        inDegrees[neighbor]--;
        if (inDegrees[neighbor] == 0) bfsQ.offer(neighbor);
      }
    }
    return visitedNeighborCount == numCourses;
  }

  public int[] findOrder(int numCourses, int[][] prerequisites) {
    Map<Integer, List<Integer>> graph = new HashMap<>();
    int inDegrees[] = new int[numCourses];
    for (int i = 0; i < numCourses; i++) graph.put(i, new ArrayList<>());
    for (int[] edge : prerequisites) {
      inDegrees[edge[0]]++;
      graph.get(edge[1]).add(edge[0]);
    }
    return detectCycle(graph, numCourses, inDegrees) ? order : new int[0];
  }
}

public class _210_Course_Schedule_II {

  public static void main(String[] args) {
    System.out.println(
      Arrays.toString(
        new Solution()
          .findOrder(4, new int[][] { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 } })
      )
    );
  }
}
