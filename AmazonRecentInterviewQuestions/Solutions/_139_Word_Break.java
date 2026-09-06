import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Solution {

  private boolean solve(
    String s,
    Set<String> words,
    int start,
    int n,
    Map<Integer, Boolean> memo
  ) {
    if (start == n) return true;
    if (memo.get(start) != null) return memo.get(start);
    for (int i = start; i < n; i++) {
      if (words.contains(s.substring(start, i + 1))) {
        if (solve(s, words, i + 1, n, memo)) {
          memo.put(start, true);
          return true;
        }
      }
    }
    memo.put(start, false);
    return false;
  }

  public boolean wordBreak(String s, List<String> wordDict) {
    Set<String> words = new HashSet<>();
    words.addAll(wordDict);
    Map<Integer, Boolean> memo = new HashMap<>();
    return solve(s, words, 0, s.length(), memo);
  }
}

public class _139_Word_Break {

  public static void main(String[] args) {
    System.out.println(
      new Solution().wordBreak("leetcodeleet", List.of("leet", "code"))
    );
  }
}
