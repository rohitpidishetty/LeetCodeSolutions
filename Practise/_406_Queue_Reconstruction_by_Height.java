import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class Solution {

  public int[][] reconstructQueue(int[][] people) {
    Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
    List<int[]> res = new ArrayList<>();
    for (int[] p : people) {
      res.add(p[1], p);
    }
    return res.toArray(new int[people.length][]);
  }
}

public class _406_Queue_Reconstruction_by_Height {

  public static void main(String[] args) {
    System.out.println(
      new Solution()
        .reconstructQueue(
          new int[][] {
            { 6, 0 },
            { 5, 0 },
            { 4, 0 },
            { 3, 2 },
            { 2, 2 },
            { 1, 4 },
          }
        )
    );
  }
}
