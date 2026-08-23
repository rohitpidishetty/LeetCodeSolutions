// import java.util.Arrays;

// class Solution {

//   public int maxEnvelopes(int[][] envelopes) {
//     Arrays.sort(envelopes, (a, b) ->
//       (a[0] == b[0]) ? (b[1] - a[1]) : (a[0] - b[0])
//     );

//     int n = envelopes.length;
//     int[] dp = new int[n];
//     Arrays.fill(dp, 1);
//     int max = 1;
//     for (int i = 1; i < n; i++) {
//       for (int j = 0; j < i; j++) {
//         if (
//           envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]
//         ) {
//           dp[i] = Math.max(dp[i], dp[j] + 1);
//         }
//       }
//       max = Math.max(max, dp[i]);
//     }
//     return max;
//   }
// }

// public class _354_Russia_Doll_Envelopes {

//   public static void main(String[] args) {
//     System.out.println(
//       new Solution()
//         .maxEnvelopes(new int[][] { { 5, 4 }, { 6, 4 }, { 6, 7 }, { 2, 3 } })
//     );
//   }
// }

import java.util.*;

class Solution {

  public int maxEnvelopes(int[][] envelopes) {
    Arrays.sort(envelopes, (a, b) ->
      (a[0] == b[0]) ? (b[1] - a[1]) : (a[0] - b[0])
    );

    int[] lis = new int[envelopes.length];
    int len = 0;

    for (int[] env : envelopes) {
      int h = env[1];
      int i = Arrays.binarySearch(lis, 0, len, h);
      if (i < 0) i = -(i + 1);
      lis[i] = h;
      if (i == len) len++;
    }

    return len;
  }

  public static void main(String[] args) {
    Solution sol = new Solution();
    int[][] envelopes = { { 5, 4 }, { 6, 4 }, { 6, 7 }, { 2, 3 } };
    System.out.println(sol.maxEnvelopes(envelopes));
  }
}
