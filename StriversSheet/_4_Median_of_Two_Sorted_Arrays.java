import java.util.Collections;
import java.util.PriorityQueue;

class Solution {

  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(
      Collections.reverseOrder()
    );
    for (int num : nums1) {
      maxHeap.add(num);
      minHeap.add(maxHeap.poll());
      if (Math.abs(maxHeap.size() - minHeap.size()) > 1) maxHeap.add(
        minHeap.poll()
      );
    }
    for (int num : nums2) {
      maxHeap.add(num);
      minHeap.add(maxHeap.poll());
      if (Math.abs(maxHeap.size() - minHeap.size()) > 1) maxHeap.add(
        minHeap.poll()
      );
    }
    int minS = minHeap.size();
    int maxS = maxHeap.size();
    if (minS == maxS) return ((double) (minHeap.poll() + maxHeap.poll())) / 2d;
    else if (minS > maxS) return (double) minHeap.poll();
    return (double) maxHeap.poll();
  }
}

public class _4_Median_of_Two_Sorted_Arrays {

  public static void main(String[] args) {
    System.out.println(
      new Solution().findMedianSortedArrays(new int[] { 2, 3 }, new int[] { 1 })
    );
  }
}
