import java.util.Arrays;

class Solution {

  private int solve(int idx, int[] nums, int n, int memo[][]) {
    if (idx > n) return 0;
    if (idx == n) return nums[idx];
    if (memo[idx][n] != -1) return memo[idx][n];

    return memo[idx][n] = Math.max(
      nums[idx] +
        Math.min(
          solve(idx + 2, nums, n, memo),
          solve(idx + 1, nums, n - 1, memo)
        ),
      nums[n] +
        Math.min(
          solve(idx + 1, nums, n - 1, memo),
          solve(idx, nums, n - 2, memo)
        )
    );
  }

  public boolean predictTheWinner(int[] nums) {
    int sum = 0;
    for (int num : nums) sum += num;
    int n = nums.length;
    int memo[][] = new int[n][n];
    for (int m[] : memo) Arrays.fill(m, -1);
    int p1Score = solve(0, nums, n - 1, memo);
    int p2Score = sum - p1Score;
    return p1Score >= p2Score;
  }
}

public class _486_Predict_the_Winner {

  public static void main(String[] args) {
    System.out.println(new Solution().predictTheWinner(new int[] { 1, 5, 2 }));
  }
}
