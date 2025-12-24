import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {

  // Memory Limit Exceeded: 18 / 21 testcases passed
  // public int smallestDistancePair(int[] nums, int k) {
  //   PriorityQueue<Integer> pQ = new PriorityQueue<>();
  //   for (int i = 1; i < nums.length; i++) {
  //     for (int j = 0; j < i; j++) pQ.offer(Math.abs(nums[i] - nums[j]));
  //   }
  //   int x = 0;

  //   while (!pQ.isEmpty() && x < k - 1) {
  //     pQ.poll();
  //     x++;
  //   }

  //   return pQ.peek();
  // }

  private int countPairsWithDistance_as_mid(int m, int[] buf) {
    int pairs = 0, j = 0, i = 0;
    while (j < buf.length) {
      while (buf[j] - buf[i] > m) i++;
      pairs += (j - i);
      j++;
    }
    return pairs;
  }

  public int smallestDistancePair(int[] nums, int k) {
    Arrays.sort(nums);
    int n = nums.length;
    int left = 0, right = nums[n - 1] - nums[0], result = 0;
    while (left <= right) {
      int mid = (left + right) / 2; // distance
      if (countPairsWithDistance_as_mid(mid, nums) < k) {
        left = mid + 1;
        result = left;
      } else {
        right = mid - 1;
      }
    }
    return result;
  }
}

public class _719_Find_K_th_Smallest_Pair_Distance {

  public static void main(String[] args) {
    System.out.println(
      new Solution().smallestDistancePair(new int[] { 1, 5, 4, 10 }, 3)
    );
  }
}
