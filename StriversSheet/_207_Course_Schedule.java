import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class Solution {

  public boolean canFinish(int numCourses, int[][] prerequisites) {
    if (prerequisites.length == 0 || prerequisites[0].length == 0) return true;
    int[] inDegree = new int[numCourses];
    Map<Integer, List<Integer>> graph = new HashMap<>();
    Queue<Integer> q = new ArrayDeque<>();
    int processed = 0;

    for (int edges[] : prerequisites) {
      graph.computeIfAbsent(edges[1], key -> new ArrayList<>()).add(edges[0]);
      inDegree[edges[0]]++;
    }

    for (int i = 0; i < inDegree.length; i++) if (inDegree[i] == 0) q.offer(i);

    while (!q.isEmpty()) {
      processed++;
      List<Integer> neighbors = graph.get(q.poll());
      if (neighbors == null || neighbors.size() == 0) continue;
      for (Integer n : neighbors) {
        if (inDegree[n] != 0) {
          inDegree[n]--;
          if (inDegree[n] == 0) q.offer(n);
        }
      }
    }

    return processed == numCourses;
  }
}

public class _207_Course_Schedule {

  public static void main(String[] args) {
    System.out.println(new Solution().canFinish(2, new int[][] { { 0, 1 } }));
  }
}
