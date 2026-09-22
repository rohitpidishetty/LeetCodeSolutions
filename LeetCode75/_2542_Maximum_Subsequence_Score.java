import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {

  public long maxScore(int[] nums1, int[] nums2, int k) {
    int n = nums1.length;
    int[][] nums = new int[n][2];
    for (int i = 0; i < n; i++) nums[i] = new int[] { nums1[i], nums2[i] };
    Arrays.sort(nums, (a, b) -> b[1] - a[1]);

    PriorityQueue<Integer> pq = new PriorityQueue<>();
    long sum = 0;
    long max = 0;
    int i = 0;
    for (; i < n; i++) {
      pq.offer(nums[i][0]);
      sum += nums[i][0];
      if (pq.size() >= k) {
        max = Math.max(max, sum * nums[i][1]);
        sum -= pq.poll();
      }
    }

    return max;
  }
}

public class _2542_Maximum_Subsequence_Score {

  public static void main(String[] args) {
    System.out.println(
      new Solution().maxScore(
        new int[] { 1, 3, 3, 2 },
        new int[] { 2, 1, 3, 4 },
        3
      )
    );
  }
}
