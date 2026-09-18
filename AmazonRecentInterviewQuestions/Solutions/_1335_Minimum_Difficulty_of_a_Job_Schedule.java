import java.util.Arrays;

class Solution {

  private int solve(int i, int[] diff, int d, int memo[][]) {
    if (memo[i][d] != -1) return memo[i][d];
    int max = Integer.MIN_VALUE;
    if (d == 1) {
      for (int s = i; s < diff.length; s++) max = Math.max(max, diff[s]);
      return max;
    }

    int min = Integer.MAX_VALUE;
    for (int s = i; s <= diff.length - d; s++) {
      max = Math.max(max, diff[s]);
      int result = Math.max(max, diff[s]) + solve(s + 1, diff, d - 1, memo);
      min = Math.min(min, result);
    }
    return memo[i][d] = min;
  }

  public int minDifficulty(int[] jobDifficulty, int d) {
    int memo[][] = new int[jobDifficulty.length + 1][d + 1];
    for (int m[] : memo) Arrays.fill(m, -1);
    int res = solve(0, jobDifficulty, d, memo);
    if (res == Integer.MAX_VALUE) return -1;
    return res;
  }
}

public class _1335_Minimum_Difficulty_of_a_Job_Schedule {

  public static void main(String[] args) {
    System.out.println(
      new Solution().minDifficulty(new int[] { 6, 5, 4, 3, 2, 1 }, 2)
    );
  }
}
