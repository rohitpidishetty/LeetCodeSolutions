import java.util.PriorityQueue;

class KthLargest {

  private PriorityQueue<Integer> pQ;
  private int k;

  public KthLargest(int k, int[] nums) {
    this.k = k;
    this.pQ = new PriorityQueue<>();
    for (int i = 0; i < nums.length; i++) {
      if (this.pQ.size() == k) {
        if (nums[i] < this.pQ.peek()) continue;
        else this.pQ.poll();
      }
      this.pQ.offer(nums[i]);
    }
  }

  public int add(int val) {
    if (this.pQ.size() < this.k) {
      this.pQ.offer(val);
      return this.pQ.peek();
    }
    int peek = this.pQ.peek();
    if (val < peek) return peek;
    this.pQ.poll();
    this.pQ.offer(val);
    return this.pQ.peek();
  }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
public class _703_Kth_Largest_Element_in_a_Stream {

  public static void main(String[] args) {
    KthLargest obj = new KthLargest(3, new int[] { 4, 5, 8, 2 });
    System.out.println(obj.add(3));
    System.out.println(obj.add(5));
    System.out.println(obj.add(10));
    System.out.println(obj.add(9));
    System.out.println(obj.add(4));
  }
}
