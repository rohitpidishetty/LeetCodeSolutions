// 22 / 55 testcases passed
// class Solution {

//   private Integer I, J, max;
//   private Integer memo[][];

//   private void solve(
//     int xIdx,
//     int x[],
//     int xLen,
//     int yIdx,
//     int y[],
//     int yLen,
//     int count
//   ) {
//     if (xIdx == xLen || yIdx == yLen) {
//       max = Math.max(max, count);
//       return;
//     }
//     if (this.memo[xIdx][yIdx] != null && count <= this.memo[xIdx][yIdx]) return;

//     if (x[xIdx] == y[yIdx]) solve(
//       xIdx + 1,
//       x,
//       xLen,
//       yIdx + 1,
//       y,
//       yLen,
//       count + 1
//     );

//     this.memo[xIdx][yIdx] = count;
//     solve(xIdx, x, xLen, yIdx + 1, y, yLen, 0);
//     solve(xIdx + 1, x, xLen, yIdx, y, yLen, 0);
//   }

//   public int findLength(int[] nums1, int[] nums2) {
//     int n = nums1.length, m = nums2.length;
//     this.memo = new Integer[n + 1][m + 1];
//     this.max = 0;
//     solve(0, nums1, n, 0, nums2, m, 0);
//     return this.max;
//   }
// }

import java.util.Arrays;

class Solution {

  public int findLength(int[] nums1, int[] nums2) {
    int max = 0;
    int n = nums1.length, m = nums2.length;
    int[][] dp = new int[n + 1][m + 1];
    for (int i = 0; i < dp.length; i++) {
      for (int j = 0; j < dp[0].length; j++) {
        if (i == 0 || j == 0) continue;
        if (nums1[i - 1] == nums2[j - 1]) {
          dp[i][j] = 1 + dp[i - 1][j - 1];
          max = Math.max(max, dp[i][j]);
        } else dp[i][j] = 0;
      }
    }
    return max;
  }
}

public class _718_Maximum_Length_of_Repeated_Subarray {

  public static void main(String[] args) {
    System.out.println(
      new Solution()
        .findLength(new int[] { 1, 1, 0, 0, 1 }, new int[] { 1, 1, 0, 0, 0 })
    );
  }
}
