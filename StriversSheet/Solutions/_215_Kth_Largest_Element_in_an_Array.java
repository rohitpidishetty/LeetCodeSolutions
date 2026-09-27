import java.util.PriorityQueue;

class Solution {

  private PriorityQueue<Integer> pq;

  public int findKthLargest(int[] nums, int k) {
    pq = new PriorityQueue<>();
    for (int num : nums) {
      pq.offer(num);
      if (pq.size() > k) pq.poll();
    }
    return pq.peek();
  }
}

public class _215_Kth_Largest_Element_in_an_Array {

  public static void main(String[] args) {
    System.out.println(
      new Solution().findKthLargest(new int[] { 3, 2, 1, 5, 6, 4 }, 2)
    );
  }
}
