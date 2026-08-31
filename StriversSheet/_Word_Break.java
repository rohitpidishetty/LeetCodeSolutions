import java.util.List;

class Solution {

  private boolean solve(int s, String str, List<String> d, int n) {
    if (s == n) return true;
    for (int i = s; i < n; i++) {
      if (
        d.contains(str.substring(s, i + 1)) && solve(i + 1, str, d, n)
      ) return true;
    }
    return false;
  }

  public boolean wordBreak(String s, List<String> wordDict) {
    return solve(0, s, wordDict, s.length());
  }
}

public class _Word_Break {

  public static void main(String[] args) {
    System.out.println(
      new Solution().wordBreak(
        "takeuforward",
        List.of("take", "forward", "you", "u")
      )
    );
  }
}
