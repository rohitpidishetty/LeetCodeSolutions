import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class TrieNode {
  public TrieNode[] buffer;
  public boolean EOW;

  public TrieNode() {
    this.buffer = new TrieNode[26];
    this.EOW = false;
  }
}

class Solution {

  private boolean process(String word, int n, Set<String> collec, String string, int matches, List<String> buffer,
      Map<String, Boolean> memo) {

    if (memo.containsKey(word))
      return memo.get(word);

    if (n == 0) {
      memo.put(word, true);
      return true;
    }

    for (int i = 1; i <= n; i++) {
      String prefix = word.substring(0, i);
      String suffix = word.substring(i, n);
      if (collec.contains(prefix)
          && (collec.contains(suffix) || process(suffix, suffix.length(), collec, string, matches + 1, buffer, memo))) {
        memo.put(word, true);
        return true;
      }
    }
    memo.put(word, false);
    return false;
  }

  public List<String> findAllConcatenatedWordsInADict(String[] words) {
    Set<String> set = new HashSet<>();
    for (String word : words)
      set.add(word);
    int matches = 0;
    List<String> buffer = new ArrayList<>();
    for (String word : words) {
      Map<String, Boolean> memo = new HashMap<>();
      set.remove(word);
      if (process(word, word.length(), set, word, matches, buffer, memo))
        buffer.add(word);
      set.add(word);
    }
    return buffer;
  }
}

public class _472_Concatenated_Words {
  public static void main(String[] args) {
    System.out.println(new Solution().findAllConcatenatedWordsInADict(
        new String[] { "cat", "cats", "catsdogcats", "dog", "dogcatsdog", "hippopotamuses", "rat", "ratcatdogcat" }));
  }
}
