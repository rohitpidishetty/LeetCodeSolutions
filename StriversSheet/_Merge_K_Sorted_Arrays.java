import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Solution {

  private class Payload {

    public int[] arr;
    public int arrLen = 0;
    public int idx;

    public Payload(int[] arr, int arrLen, int idx) {
      this.arr = arr;
      this.arrLen = arrLen;
      this.idx = idx;
    }
  }

  public List<Integer> mergeKSortedArrays(int[][] arr, int k) {
    List<Integer> res = new ArrayList<>();
    PriorityQueue<Payload> pq = new PriorityQueue<>((a, b) ->
      Integer.compare(a.arr[a.idx], b.arr[b.idx])
    );
    for (int i = 0; i < arr.length; i++) pq.offer(
      new Payload(arr[i], arr[i].length, 0)
    );
    while (!pq.isEmpty()) {
      Payload p = pq.poll();
      res.add(p.arr[p.idx]);
      p.idx++;
      if (p.idx < p.arrLen) pq.offer(p);
    }

    return res;
  }
}

public class _Merge_K_Sorted_Arrays {

  public static void main(String[] args) {
    System.out.println(
      new Solution().mergeKSortedArrays(
        new int[][] {
          { 1, 2, 3, 4 },
          { 2, 2, 2, 4 },
          { 5, 5, 6, 6 },
          { 7, 8, 9, 9 },
        },
        4
      )
    );
  }
}
