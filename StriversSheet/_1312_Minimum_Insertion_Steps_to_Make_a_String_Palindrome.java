import java.util.Arrays;

class Solution {

  private int solve(int l, int r, String s, int[][] memo) {
    if (l >= r) return 0;
    if (memo[l][r] != -1) return memo[l][r];
    if (s.charAt(l) == s.charAt(r)) return solve(l + 1, r - 1, s, memo);
    int ans = memo[l][r] =
      1 + Math.min(solve(l + 1, r, s, memo), solve(l, r - 1, s, memo));
    return ans;
  }

  public int minInsertions(String s) {
    int l = 0;
    int r = s.length() - 1;
    int[][] memo = new int[r + 1][r + 1];
    for (int[] m : memo) Arrays.fill(m, -1);
    return solve(l, r, s, memo);
  }
}

public class _1312_Minimum_Insertion_Steps_to_Make_a_String_Palindrome {

  public static void main(String[] args) {
    System.out.println(new Solution().minInsertions("leetcode"));
  }
}
