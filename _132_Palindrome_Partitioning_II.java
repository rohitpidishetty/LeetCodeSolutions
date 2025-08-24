import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
  private static int minCuts;

  private boolean isPalindrome(String s) {
    int i = 0;
    int j = s.length() - 1;
    while (i < j)
      if (s.charAt(i++) != s.charAt(j--))
        return false;
    return true;
  }

  private void cuts(String s, int end, int cut) {
    if (s.isEmpty()) {
      Solution.minCuts = Math.min(Solution.minCuts, cut);
      return;
    }
    cut++;

    for (int i = 1; i <= end; i++) {
      String consider = s.substring(0, i);
      String remaining = s.substring(i, end);
      if (isPalindrome(consider))
        cuts(remaining, remaining.length(), cut);
    }
  }

  public int minCut(String s) {
    // Rec-way
    // Solution.minCuts = Integer.MAX_VALUE;
    // cuts(s, s.length(), -1);
    // return Solution.minCuts;

    // DP-way
    return computeDPtable(s);
  }

  private boolean isPalindrome(String s, int x1, int x2) {
    while (x1 < x2)
      if (s.charAt(x1++) != s.charAt(x2--))
        return false;
    return true;
  }

  private int computeDPtable(String s) {
    int n = s.length();
    int[][] dp_table = new int[n][n];

    for (int i = 0; i < n; i++) {
      Arrays.fill(dp_table[i], Integer.MAX_VALUE);
      dp_table[i][i] = 0;
    }

    int i = 0;
    int j_start = 0;
    int j = 0;
    int limit = n - 1;

    for (; i < limit; i++, j++) {
      int row = i;
      int col = j + 1;

      if (col >= n)
        continue;

      if (isPalindrome(s, row, col)) {
        dp_table[row][col] = 0;
      } else {
        for (int k = row; k < col; k++) {
          dp_table[row][col] = Math.min(
              dp_table[row][col],
              dp_table[row][k] + dp_table[k + 1][col] + 1);
        }
      }

      if (i == 0 && (j + 1) == limit)
        break;

      if ((j + 1) == limit) {
        i = -1;
        j_start++;
        j = j_start - 1;
      }
    }

    return dp_table[0][n - 1];
  }
}

public class _132_Palindrome_Partitioning_II {
  public static void main(String[] args) {
    System.out.println(new Solution().minCut("cabababcbc"));
  }
}