import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {

  public List<Integer> findClosestElements(int[] arr, int k, int x) {
    int[][] sorted = new int[arr.length][2];
    for (int i = 0; i < arr.length; i++) {
      sorted[i] = new int[] { Math.abs(arr[i] - x), arr[i] };
    }
    Arrays.sort(sorted, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
    List<Integer> res = new ArrayList<>();
    int i = 0;
    while (k > 0) {
      res.add(sorted[i++][1]);
      k--;
    }
    Collections.sort(res);
    return res;
  }
}

public class _658_Find_K_Closest_Elements {

  public static void main(String[] args) {
    System.out.println(
      new Solution().findClosestElements(new int[] { 1, 1, 2, 3, 4 }, 4, -1)
    );
  }
}
