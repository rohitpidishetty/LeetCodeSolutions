class Solution {
  // private boolean solve(int s, int e, int p1_score, int p2_score, int[] buffer,
  // boolean player1_turn) {
  // if (s > e) {
  // return p1_score >= p2_score;
  // }
  // boolean next = !player1_turn;
  // boolean can_win = false;
  // if (player1_turn)
  // if (buffer[s] >= buffer[e])
  // can_win = solve(s + 1, e, p1_score + buffer[s], p2_score, buffer, next);
  // else
  // can_win = solve(s, e - 1, p1_score + buffer[e], p2_score, buffer, next);
  // else {
  // if (buffer[s] >= buffer[e])
  // can_win = solve(s + 1, e, p1_score, p2_score + buffer[s], buffer, next);
  // else
  // can_win = solve(s, e - 1, p1_score, p2_score + buffer[e], buffer, next);
  // }
  // return can_win;
  // }

  // public boolean predictTheWinner(int[] nums) {
  // int start = 0, end = nums.length - 1, player1_score = 0, player2_score = 0;
  // if (solve(start, end, player1_score, player2_score, nums, true))
  // return true;
  // return false;
  // }

  private Integer[][] memo;

  public boolean predictTheWinner(int[] nums) {
    this.memo = new Integer[23][23];
    int i = 0, j = nums.length - 1;
    int player1Score = solve(i, j, nums);
    int totalScore = 0;
    for (int n : nums)
      totalScore += n;
    int player2Score = totalScore - player1Score;
    return player1Score >= player2Score;
  }

  private int solve(int i, int j, int[] nums) {
    if (i > j)
      return 0;
    if (this.memo[i][j] != null)
      return this.memo[i][j];
    if (i == j)
      return nums[i];
    int player1_choice1 = nums[i] + Math.min(solve(i + 2, j, nums), solve(i + 1, j - 1, nums));
    int player1_choice2 = nums[j] + Math.min(solve(i + 1, j - 1, nums), solve(i, j - 2, nums));
    return this.memo[i][j] = Math.max(player1_choice1, player1_choice2);
  }
}

public class _486__Predict_the_Winner {
  public static void main(String[] args) {
    System.out.println(new Solution().predictTheWinner(new int[] { 1, 5, 2 }));
  }
}
