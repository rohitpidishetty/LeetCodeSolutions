import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;

class Solution {

  public int shortestSubarray(int[] nums, int k) {
    int min = Integer.MAX_VALUE;

    long prefixSum = 0;
    ArrayDeque<long[]> dq = new ArrayDeque<>();
    dq.offer(new long[] { 0, -1 });
    for (int i = 0; i < nums.length; i++) {
      prefixSum += nums[i];

      while (!dq.isEmpty() && prefixSum - dq.peekFirst()[0] >= k) {
        min = Math.min(min, i - (int) dq.pollFirst()[1]);
      }

      while (!dq.isEmpty() && dq.peekLast()[0] >= prefixSum) {
        dq.pollLast();
      }

      dq.offer(new long[] { prefixSum, i });
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
