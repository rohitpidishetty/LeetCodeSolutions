import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

class Solution {

  public int[] maxSumCombinations(int[] nums1, int[] nums2, int k) {
    Arrays.sort(nums1);
    Arrays.sort(nums2);
    Set<String> visited = new HashSet<>();
    int i = nums1.length - 1;
    int j = nums2.length - 1;
    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) ->
      Integer.compare(b[0], a[0])
    );
    int idx = 0;
    int[] res = new int[k];
    String state = (i + "," + j);
    pq.offer(new int[] { nums1[i] + nums2[j], i, j });
    visited.add(state);
    while (!pq.isEmpty() && k > 0) {
      int[] top = pq.poll();

      i = top[1];
      j = top[2];

      res[idx++] = top[0];

      if (i - 1 >= 0) {
        state = i - 1 + "," + j;
        if (!visited.contains(state)) {
          pq.offer(new int[] { nums1[i - 1] + nums2[j], i - 1, j });
          visited.add(state);
        }
      }
      if (j - 1 >= 0) {
        state = i + "," + (j - 1);
        if (!visited.contains(state)) {
          pq.offer(new int[] { nums1[i] + nums2[j - 1], i, j - 1 });
          visited.add(state);
        }
      }
      k--;
    }
    return res;
  }
}

public class _Maximum_Sum_Combination {

  public static void main(String[] args) {
    System.out.println(
      Arrays.toString(
        new Solution().maxSumCombinations(
          new int[] { 7, 3 },
          new int[] { 1, 6 },
          2
        )
      )
    );
  }
}
