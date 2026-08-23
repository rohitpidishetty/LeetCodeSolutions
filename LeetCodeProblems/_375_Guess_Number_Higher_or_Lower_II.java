class Solution {

  private Integer[][] memo;

  private int guess(int start, int end) {
    if (start >= end) return 0;
    if (memo[start][end] != null) return memo[start][end];
    int ans = Integer.MAX_VALUE;
    for (int i = start; i <= end; i++) {
      ans = Math.min(ans, i + Math.max(guess(start, i - 1), guess(i + 1, end)));
    }
    memo[start][end] = ans;
    return ans;
  }

  public int getMoneyAmount(int n) {
    memo = new Integer[n + 1][n + 1];
    return guess(0, n);
  }
}

public class _375_Guess_Number_Higher_or_Lower_II {

  public static void main(String[] args) {
    System.out.println(new Solution().getMoneyAmount(10));
  }
}
