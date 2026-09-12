import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

class Solution {

  private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
  private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(
    Collections.reverseOrder()
  );

  private double median() {
    if (minHeap.size() > maxHeap.size()) return minHeap.peek();
    else if (minHeap.size() < maxHeap.size()) return maxHeap.peek();
    else return ((double) minHeap.peek() + maxHeap.peek()) / 2.0;
  }

  private void offer(int number) {
    maxHeap.offer(number);
    minHeap.offer(maxHeap.poll());
    if (maxHeap.size() < minHeap.size()) maxHeap.offer(minHeap.poll());
  }

  private void remove(int number) {
    if (minHeap.contains(number)) {
      minHeap.remove(number);
      if (maxHeap.size() > minHeap.size()) minHeap.offer(maxHeap.poll());
    } else {
      maxHeap.remove(number);
      if (maxHeap.size() < minHeap.size()) maxHeap.offer(minHeap.poll());
    }
  }

  public double[] medianSlidingWindow(int[] nums, int k) {
    int n = nums.length;
    double[] res = new double[n - k + 1];
    for (int i = 0; i < n; i++) {
      offer(nums[i]);

      if (i >= k) remove(nums[i - k]);
      // get median
      if (i >= k - 1) res[i - k + 1] = median();
    }
    return res;
  }
}

public class _480_Sliding_Window_Median {

  public static void main(String[] args) {
    System.out.println(
      Arrays.toString(
        new Solution().medianSlidingWindow(
          new int[] { 1, 3, -1, -3, 5, 3, 6, 7 },
          3
        )
      )
    );
  }
}
