import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class Solution {

  public boolean circularArrayLoop(int[] nums) {
    int n = nums.length;
    int[] inDegrees = new int[n];
    Map<Integer, List<Integer>> graph = new HashMap<>();
    for (int i = 0; i < n; i++) {
      int nextNode = (((i + nums[i]) % n) + n) % n;
      if (
        nextNode == i ||
        (nums[i] > 0 && nums[nextNode] < 0) ||
        (nums[i] < 0 && nums[nextNode] > 0)
      ) continue;
      inDegrees[nextNode]++;
      if (!graph.containsKey(i)) graph.put(i, new ArrayList<>());
      graph.get(i).add(nextNode);
    }
    Queue<Integer> bfsQ = new ArrayDeque<>();
    for (int i = 0; i < n; i++) if (inDegrees[i] == 0) bfsQ.offer(i);
    int processedNodes = 0;
    while (!bfsQ.isEmpty()) {
      int magnitude = bfsQ.size();
      for (int _zID_node = 0; _zID_node < magnitude; _zID_node++) {
        int actualNode = bfsQ.poll();
        processedNodes++;
        if (!graph.containsKey(actualNode)) continue;
        for (Integer neighbor : graph.get(actualNode)) {
          inDegrees[neighbor]--;
          if (inDegrees[neighbor] == 0) bfsQ.offer(neighbor);
        }
      }
    }

    return !(processedNodes == n);
  }
}

public class _457_Circular_Array_Loop {

  public static void main(String[] args) {
    System.out.println(
      new Solution().circularArrayLoop(new int[] { -1, -2, -3, -4, -5, 6 })
    );
  }
}
