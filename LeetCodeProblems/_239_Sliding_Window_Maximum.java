import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {

  public int[] maxSlidingWindow_v0(int[] nums, int k) {
    if (nums == null) return new int[0];
    Queue<Integer> window = new PriorityQueue<>(Collections.reverseOrder());
    int[] ret = new int[nums.length - k + 1];
    int idx = 0;
    for (int i = 0; i < nums.length; i++) {
      window.add(nums[i]);
      if (window.size() == k) {
        ret[idx++] = window.peek();
        window.remove(nums[i - k + 1]);
      }
    }
    return ret;
  }

  public int[] maxSlidingWindow(int[] nums, int k) {
    if (nums == null) return new int[0];
    int[] ret = new int[nums.length - k + 1];
    int idx = 0;
    Deque<Integer> window = new ArrayDeque<>();
    for (int i = 0; i < nums.length; i++) {
      // Add ele indices into window.
      while (!window.isEmpty() && nums[window.peekLast()] < nums[i]) {
        window.pollLast();
      }
      window.offer(i);
      // Remove out of boundary indices.
      while (
        !window.isEmpty() && window.peekFirst() <= i - k
      ) window.pollFirst();

      if (i >= k - 1) ret[idx++] = nums[window.peek()];
    }
    return ret;
  }
}

public class _239_Sliding_Window_Maximum {

  public static void main(String[] args) {
    System.out.println(
      Arrays.toString(
        new Solution()
          .maxSlidingWindow(new int[] { 1, 3, -1, -3, 5, 3, 6, 7 }, 3)
      )
    );
  }
}
