import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {

  // Time Limit Exceeded 108 / 118 testcases passed
  // public int intersectionSizeTwo(int[][] intervals) {
  //   Arrays.sort(intervals, (a, b) ->
  //     (a[1] != b[1]) ? (a[1] - b[1]) : (b[0] - a[0])
  //   );
  //   Set<Integer> set = new HashSet<>();
  //   int rme = intervals[0].length - 1;
  //   set.add(intervals[0][rme]);
  //   set.add(intervals[0][rme] - 1);

  //   for (int i = 1; i < intervals.length; i++) {
  //     int taken = 0;
  //     rme = intervals[i].length - 1;
  //     for (int j = intervals[i][0]; j <= intervals[i][1]; j++) {
  //       if (set.contains(j)) taken++;
  //       if (taken == 2) break;
  //     }
  //     if (taken == 0) {
  //       set.add(intervals[i][rme]);
  //       set.add(intervals[i][rme] - 1);
  //     } else if (taken == 1) set.add(intervals[i][rme]);
  //   }
  //   return set.size();
  // }

  public int intersectionSizeTwo(int[][] intervals) {
    Arrays.sort(intervals, (a, b) ->
      (a[1] != b[1]) ? (a[1] - b[1]) : (b[0] - a[0])
    );
    int ans = 0;

    int first = -1, second = -1;
    for (int i = 0; i < intervals.length; i++) {
      int l = intervals[i][0], r = intervals[i][1];
      if (l <= first) continue;
      if (l > second) {
        first = r - 1;
        second = r;
        ans += 2;
      } else if (l <= second) {
        first = second;
        second = r;
        ans += 1;
      }
    }
    return ans;
  }
}

public class _757_Set_Intersection_Size_At_Least_Two {

  public static void main(String[] args) {
    System.out.println(
      new Solution()
        .intersectionSizeTwo(new int[][] { { 1, 3 }, { 3, 7 }, { 8, 9 } })
    );
    System.out.println(
      new Solution()
        .intersectionSizeTwo(
          new int[][] { { 1, 3 }, { 1, 4 }, { 2, 5 }, { 3, 5 } }
        )
    );
  }
}
