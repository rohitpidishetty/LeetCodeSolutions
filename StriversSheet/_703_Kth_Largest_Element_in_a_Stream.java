import java.util.PriorityQueue;

class KthLargest {

  private PriorityQueue<Integer> pq;
  private int k;

  public KthLargest(int k, int[] nums) {
    this.k = k;
    pq = new PriorityQueue<>();
    for (int num : nums) {
      pq.offer(num);
      if (pq.size() > k) pq.poll();
    }
  }

  public int add(int val) {
    pq.offer(val);
    if (pq.size() > this.k) pq.poll();
    return pq.peek();
  }
}

public class _703_Kth_Largest_Element_in_a_Stream {

  public static void main(String[] args) {
    /**
     * Your KthLargest object will be instantiated and called as such:
     * KthLargest obj = new KthLargest(k, nums);
     * int param_1 = obj.add(val);
     */

    KthLargest kl = new KthLargest(3, new int[] { 4, 5, 8, 2 });
  }
}
