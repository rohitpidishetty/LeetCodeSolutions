import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


class Solution {
  private boolean solve(String s, Set<String> wD) {
    int n = s.length();
    boolean[][] dp = new boolean[n][n];
    String consider = new String();
    for (int i = 0; i < n; i++) {
      int c = 0;
      for (int j = i; j < n; j++, c++) {
        consider = s.substring(c, j + 1);
        if (wD.contains(consider))
          dp[c][j] = true;
        else {
          boolean status = false;
          for (int k = c; k < j; k++)
            status |= dp[c][k] & dp[k + 1][j];
          dp[c][j] = status;
        }
      }
    }
    return dp[0][n - 1];
  }

  public boolean wordBreak(String s, List<String> wordDict) {
    return solve(s, new HashSet<>(wordDict));
  }
}

public class _139_Word_Break {
  public static void main(String[] args) {
    System.out.println(new Solution().wordBreak("leetcode", Arrays.asList("leet", "code")));
  }
}
