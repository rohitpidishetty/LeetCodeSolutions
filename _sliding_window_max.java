import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;

public class _sliding_window_max {
  public static void main(String[] args) {
    int[] arr = { 1, 3, -1, -3, 5, 3, 6, 7 };
    int k = 3;
    int[] res = new int[arr.length - k + 1];
    PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    int j = 0;
    while (j < arr.length) {
      pq.add(arr[j]);
      if (!pq.isEmpty() && pq.size() > k)
        pq.remove(arr[j - k]);
      if (pq.size() == k)
        res[j - k + 1] = pq.peek();
      j++;
    }
    System.out.println(Arrays.toString(res));
  }
}