import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

class Solution {

  public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
    List<List<Integer>> buffer = new ArrayList<>();
    PriorityQueue<int[]> pQ = new PriorityQueue<>((a, b) ->
      Integer.compare(a[2], b[2])
    );
    int start[] = { 0, 0, nums1[0] + nums2[0] };
    pQ.offer(start);
    Set<String> visited = new HashSet<>();
    while (buffer.size() < k) {
      int[] poll = pQ.poll();
      String path = poll[0] + "-" + poll[1];
      if (!visited.contains(path)) {
        buffer.add(Arrays.asList(nums1[poll[0]], nums2[poll[1]]));
        if (poll[0] + 1 < nums1.length) pQ.offer(
          new int[] {
            poll[0] + 1,
            poll[1],
            nums1[poll[0] + 1] + nums2[poll[1]],
          }
        );
        if (poll[1] + 1 < nums2.length) pQ.offer(
          new int[] {
            poll[0],
            poll[1] + 1,
            nums1[poll[0]] + nums2[poll[1] + 1],
          }
        );
        visited.add(path);
      }
    }
    return buffer;
  }
}

public class _373_Find_K_Pairs_with_Smallest_Sums {

  public static void main(String[] args) {
    System.out.println(
      new Solution()
        .kSmallestPairs(new int[] { 1, 7, 11 }, new int[] { 2, 4, 6 }, 3)
    );
  }
}
