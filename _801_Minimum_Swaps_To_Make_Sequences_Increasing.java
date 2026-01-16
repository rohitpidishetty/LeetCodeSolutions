import java.util.Arrays;

class Solution {

  private int[][] memo;

  private int solve(
    int[] a,
    int[] b,
    int i,
    int a_prev,
    int b_prev,
    int swapped
  ) {
    // base
    if (i == a.length) return 0;
    if (this.memo[i][swapped] != -1) return this.memo[i][swapped];

    int ans = Integer.MAX_VALUE;

    // no swap
    if (a[i] > a_prev && b[i] > b_prev) ans = solve(a, b, i + 1, a[i], b[i], 0);

    // swap
    if (a[i] > b_prev && b[i] > a_prev) {
      ans = Math.min(ans, 1 + solve(a, b, i + 1, b[i], a[i], 1));
    }

    return this.memo[i][swapped] = ans;
  }

  public int minSwap(int[] nums1, int[] nums2) {
    int prev_1, prev_2;
    this.memo = new int[nums1.length][2];
    for (int i = 0; i < this.memo.length; i++) Arrays.fill(this.memo[i], -1);
    return solve(nums1, nums2, 0, -1, -1, 0);
  }
}

public class _801_Minimum_Swaps_To_Make_Sequences_Increasing {

  public static void main(String[] args) {
    System.out.println(
      new Solution().minSwap(new int[] { 1, 3, 5, 6 }, new int[] { 1, 2, 3, 7 })
    );

    System.out.println(
      new Solution().minSwap(
        new int[] { 0, 3, 5, 8, 9 },
        new int[] { 2, 1, 4, 6, 9 }
      )
    );

    System.out.println(
      new Solution().minSwap(
        new int[] { 0, 4, 4, 5, 9 },
        new int[] { 0, 1, 6, 8, 10 }
      )
    );
  }
}
