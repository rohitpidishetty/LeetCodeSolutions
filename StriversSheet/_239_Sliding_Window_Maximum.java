import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Queue;

class Solution {

  public int[] maxSlidingWindow(int[] nums, int k) {
    int[] res = new int[nums.length - k + 1];
    Deque<Integer> q = new ArrayDeque<>();
    for (int i = 0; i < nums.length; i++) {
      while (!q.isEmpty() && q.peek() <= i - k) q.poll();
      while (!q.isEmpty() && nums[q.peekLast()] <= nums[i]) q.pollLast();
      q.offer(i);
      if (i >= k - 1) res[i - k + 1] = (nums[q.peek()]);
    }
    return res;
  }
}

public class _239_Sliding_Window_Maximum {

  public static void main(String[] args) {
    System.out.println(
      Arrays.toString(
        new Solution().maxSlidingWindow(new int[] { 1, 3, 1, 2, 0, 5 }, 3)
      )
    );
  }
}
