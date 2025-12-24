import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
  private Set<String> wordBucket;
  private List<String> retBucket;

  private void solve(String s, int start, int limit, List<String> bucket) {
    if (s.isEmpty()) {
      retBucket.add(String.join(" ", bucket));
      return;
    }

    for (int i = 1; i <= limit; i++) {
      String consider = s.substring(start, i);
      if (wordBucket.contains(consider)) {
        String remaining = s.substring(i, limit);
        int n = remaining.length();
        bucket.add(consider);
        solve(remaining, 0, n, bucket);
        bucket.remove(bucket.size() - 1);
      }
    }
  }

  public List<String> wordBreak(String s, List<String> wordDict) {
    wordBucket = new HashSet<>(wordDict);
    retBucket = new ArrayList<>();
    int wordLength = s.length();
    solve(s, 0, wordLength, new ArrayList<>());
    return retBucket;
  }
}

public class _140_Word_Break_II {
  public static void main(String[] args) {
    System.out.println(new Solution().wordBreak("catsanddog", Arrays.asList("cat", "cats", "and", "sand", "dog")));
  }
}
