import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {

  public int[] advantageCount(int[] nums1, int[] nums2) {
    PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
    Arrays.sort(nums1);
    int left = 0;
    int right = nums1.length - 1;

    for (int i = 0; i < nums2.length; i++) {
      maxHeap.offer(new int[] { nums2[i], i });
    }

    int[] result = new int[right + 1];
    while (!maxHeap.isEmpty()) {
      int[] curr = maxHeap.poll();
      if (nums1[right] > curr[0]) {
        result[curr[1]] = nums1[right];
        right--;
      } else {
        result[curr[1]] = nums1[left];
        left++;
      }
    }
    return result;
  }
}

public class _870_Advantage_Shuffle {

  public static void main(String[] args) {
    System.out.println(
      Arrays.toString(
        new Solution().advantageCount(
          new int[] { 2, 7, 11, 15 },
          new int[] { 1, 10, 4, 11 }
        )
      )
    );

    System.out.println(
      Arrays.toString(
        new Solution().advantageCount(
          new int[] { 12, 24, 8, 32 },
          new int[] { 13, 25, 32, 11 }
        )
      )
    );
  }
}
