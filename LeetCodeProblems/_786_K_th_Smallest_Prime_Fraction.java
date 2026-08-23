import java.nio.Buffer;
import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {

  class Buffer {

    private int i, j;
    private double val;

    Buffer(int i, int j, double val) {
      this.i = i;
      this.j = j;
      this.val = val;
    }

    @Override
    public String toString() {
      return this.i + "/" + this.j + "=" + this.val;
    }
  }

  public int[] kthSmallestPrimeFraction(int[] arr, int k) {
    // k-th smallest element
    PriorityQueue<Buffer> pQ = new PriorityQueue<>((a, b) ->
      Double.compare(b.val, a.val)
    );
    for (int j = 1; j < arr.length; j++) {
      for (int i = 0; i < j; i++) {
        double res = (arr[i] / (double) arr[j]);
        Buffer buff = new Buffer(arr[i], arr[j], res);
        if (pQ.size() >= k) {
          if (res > pQ.peek().val) continue;
          pQ.poll();
        }
        pQ.offer(buff);
      }
    }
    Buffer buff = pQ.peek();

    return new int[] { buff.i, buff.j };
  }
}

public class _786_K_th_Smallest_Prime_Fraction {

  public static void main(String[] args) {
    System.out.println(
      Arrays.toString(
        new Solution()
          .kthSmallestPrimeFraction(new int[] { 1, 2, 11, 37, 83, 89 }, 11)
      )
    );
  }
}
