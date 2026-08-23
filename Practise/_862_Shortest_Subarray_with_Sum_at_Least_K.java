import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class Solution {

  public int shortestSubarray(int[] nums, int k) {
    int n = nums.length;
    long prefixSum = 0;
    long prefixSumArr[] = new long[n + 1];
    Deque<Integer> mQ = new ArrayDeque<>();
    int length = Integer.MAX_VALUE;

    for (int j = 0; j < n; j++) {
      prefixSumArr[j] = (j == 0) ? nums[j] : prefixSumArr[j - 1] + nums[j];

      if (prefixSumArr[j] >= k) length = Math.min(length, j + 1);

      while (
        !mQ.isEmpty() && prefixSumArr[j] - prefixSumArr[mQ.peekFirst()] >= k
      ) length = Math.min(length, j - mQ.pollFirst());

      while (
        !mQ.isEmpty() && prefixSumArr[j] <= prefixSumArr[mQ.peekLast()]
      ) mQ.pollLast();

      mQ.offerLast(j);
    }

    return length == Integer.MAX_VALUE ? -1 : length;
  }
}

public class _862_Shortest_Subarray_with_Sum_at_Least_K {

  public static void main(String[] args) {
    System.out.println(
      new Solution().shortestSubarray(new int[] { 2, -1, 2 }, 3)
    );
    System.out.println(
      new Solution().shortestSubarray(new int[] { 84, -37, 37, 40, 95 }, 167)
    );
  }
}
