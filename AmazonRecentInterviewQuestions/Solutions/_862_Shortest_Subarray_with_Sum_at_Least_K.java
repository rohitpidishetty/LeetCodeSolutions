import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;

class Solution {

  public int shortestSubarray(int[] nums, int k) {
    int n = nums.length;
    long[] prefix = new long[n + 1];
    prefix[0] = nums[0];

    for (int i = 1; i < n; i++) prefix[i] = prefix[i - 1] + nums[i];

    ArrayDeque<long[]> q = new ArrayDeque<>();
    int min = Integer.MAX_VALUE;
    q.offer(new long[] { 0, -1 });
    for (int i = 0; i < n; i++) {
      while (!q.isEmpty() && q.peekLast()[0] >= prefix[i]) q.pollLast();

      while (!q.isEmpty() && (prefix[i] - q.peekFirst()[0]) >= k) {
        min = Math.min(min, i - (int) q.pollFirst()[1]);
      }

      q.offer(new long[] { prefix[i], i });
    }
    return min == Integer.MAX_VALUE ? -1 : min;
  }
}

public class _862_Shortest_Subarray_with_Sum_at_Least_K {

  public static void main(String[] args) {
    System.out.println(
      new Solution().shortestSubarray(new int[] { 2, -1, 4, -2, 5, 1, -3 }, 7)
    );
  }
}
