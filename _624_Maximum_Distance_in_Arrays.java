import java.util.*;

class Solution {

  // 120 / 136 testcases passed (TLE)
  // public int maxDistance(List<List<Integer>> arrays) {
  //   int max = Integer.MIN_VALUE;
  //   int n = arrays.size();
  //   for (int i = 0; i < n; i++) {
  //     for (int j = 0; j < n; j++) {
  //      if (i != j) {
  //         for (int x : arrays.get(i)) {
  //           for (int y : arrays.get(j)) {
  //             max = Math.max(max, Math.abs(x - y));
  //           }
  //         }
  //       }
  //     }
  //   }
  //   return max;
  // }
  public int maxDistance(List<List<Integer>> arrays) {
    List<Integer> arr = arrays.get(0);
    int n = arr.size() - 1;
    int min = arr.get(0);
    int max = arr.get(n);
    int m = arrays.size();
    int MAX = Integer.MIN_VALUE;
    for (int i = 1; i < m; i++) {
      arr = arrays.get(i);
      n = arr.size() - 1;
      int new_min = arr.get(0), new_max = arr.get(n);
      MAX = Math.max(MAX, Math.abs(new_max - min));
      MAX = Math.max(MAX, Math.abs(max - new_min));
      min = Math.min(min, new_min);
      max = Math.max(max, new_max);
    }
    return MAX;
  }
}

public class _624_Maximum_Distance_in_Arrays {

  public static void main(String[] args) {
    System.out.println(
      new Solution()
        .maxDistance(
          Arrays.asList(
            Arrays.asList(1, 2, 3),
            Arrays.asList(4, 5),
            Arrays.asList(1, 2, 3)
          )
        )
    );
  }
}
