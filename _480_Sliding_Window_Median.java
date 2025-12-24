import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

// class Solution {

// static {
// for (int i = 0; i < 200; i++) {
// medianSlidingWindow(new int[] { 1, 2, 3, 4, 2, 3, 1, 4, 2 }, 3);
// }
// System.gc();
// }

// public static double[] medianSlidingWindow(int[] nums, int k) {
// int n = nums.length, i = 0;
// double[] x = new double[nums.length - k + 1];
// int id = 0;
// PriorityQueue<Integer> pQ = new PriorityQueue<>();
// while (i < n) {
// pQ.offer(i);
// if (i >= k)
// pQ.remove(i - k);
// if (pQ.size() == k) {
// Object[] buffer = pQ.toArray();
// int[] arr = new int[k];
// int idx = 0;
// for (Object o : buffer)
// arr[idx] = nums[(int) buffer[idx++]];
// Arrays.sort(arr);
// x[id++] = (k % 2 != 0) ? arr[k / 2] : ((double) arr[(k / 2) - 1] + (double)
// arr[k / 2]) / 2.0;
// }
// i++;
// }
// return x;
// }

// }

import java.util.*;

class Solution {
  public double[] medianSlidingWindow(int[] nums, int k) {
    int n = nums.length;
    double[] result = new double[n - k + 1];
    MedianHeap medianHeap = new MedianHeap();

    for (int i = 0; i < n; i++) {
      medianHeap.add(nums[i], i);

      if (i >= k)
        medianHeap.remove(nums[i - k], i - k);

      if (i >= k - 1)
        result[i - k + 1] = medianHeap.getMedian();
    }

    return result;
  }

  private class MedianHeap {
    private PriorityQueue<int[]> maxHeap; // lower half (max-heap)
    private PriorityQueue<int[]> minHeap; // upper half (min-heap)
    private Map<Integer, Integer> delayed; // index -> count of lazy deletions
    private Map<Integer, Integer> heapPosition; // index -> 1 (max) or 2 (min)
    private int smallSize; // active elements in maxHeap
    private int largeSize; // active elements in minHeap

    public MedianHeap() {
      maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
      minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
      delayed = new HashMap<>();
      heapPosition = new HashMap<>();
      smallSize = 0;
      largeSize = 0;
    }

    public void add(int num, int idx) {
      if (maxHeap.isEmpty() || num <= maxHeap.peek()[0]) {
        maxHeap.offer(new int[] { num, idx });
        heapPosition.put(idx, 1);
        smallSize++;
      } else {
        minHeap.offer(new int[] { num, idx });
        heapPosition.put(idx, 2);
        largeSize++;
      }
      balance();
    }

    public void remove(int num, int idx) {
      delayed.put(idx, delayed.getOrDefault(idx, 0) + 1);

      if (heapPosition.get(idx) == 1)
        smallSize--;
      else
        largeSize--;

      prune(maxHeap);
      prune(minHeap);

      balance();
    }

    private void balance() {
      if (smallSize > largeSize + 1) {
        prune(maxHeap);
        int[] moved = maxHeap.poll();
        minHeap.offer(moved);
        heapPosition.put(moved[1], 2);
        smallSize--;
        largeSize++;
      } else if (smallSize < largeSize) {
        prune(minHeap);
        int[] moved = minHeap.poll();
        maxHeap.offer(moved);
        heapPosition.put(moved[1], 1);
        smallSize++;
        largeSize--;
      }

      prune(maxHeap);
      prune(minHeap);
    }

    private void prune(PriorityQueue<int[]> heap) {
      while (!heap.isEmpty()) {
        int idx = heap.peek()[1];
        if (delayed.containsKey(idx)) {
          delayed.put(idx, delayed.get(idx) - 1);
          if (delayed.get(idx) == 0)
            delayed.remove(idx);
          heap.poll();
        } else
          break;
      }
    }

    public double getMedian() {
      prune(maxHeap);
      prune(minHeap);

      if (smallSize == largeSize) {
        return ((double) maxHeap.peek()[0] + (double) minHeap.peek()[0]) / 2.0;
      } else {
        return (double) maxHeap.peek()[0];
      }
    }
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    int[] nums1 = { 1, 3, -1, -3, 5, 3, 6, 7 };
    System.out.println(Arrays.toString(s.medianSlidingWindow(nums1, 3)));
    // Expected: [1.0, -1.0, -1.0, 3.0, 5.0, 6.0]

    int[] nums2 = { 1, 2, 3, 4, 2, 3, 1, 4, 2 };
    System.out.println(Arrays.toString(s.medianSlidingWindow(nums2, 3)));
    // Expected: [2.0, 3.0, 3.0, 3.0, 2.0, 3.0, 2.0]
  }
}
