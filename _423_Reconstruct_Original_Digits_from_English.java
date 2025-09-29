import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Trie {

  protected Trie[] buffer;
  protected boolean isEOW;
  protected String digit;

  public Trie() {
    this.buffer = new Trie[26];
    this.isEOW = false;
    this.digit = new String();
  }
}

class Solution {

  protected void dfs(
    Trie root,
    Map<Character, Integer> hMap,
    Set<Character> set,
    Character ch
  ) {
    if (root == null) return;
    if (root.isEOW) {
      System.out.println(root.digit);
      return;
    }

    for (int i = 0; i < root.buffer.length; i++) {
      char subCh = (char) (i + 'a');
      if (root.buffer[i] != null && set.contains(subCh)) {
        if (hMap.get(subCh) > 0) hMap.put(subCh, hMap.get(subCh) - 1);
        else set.remove(subCh);
        dfs(root.buffer[i], hMap, set, subCh);
      }
    }
  }

  public String originalDigits(String s) {
    Map<Character, Integer> hMap = new HashMap<>();
    Set<Character> set = new HashSet<>();
    Trie root = new Trie();
    int n = s.length();

    // Lets first build TRIE tree
    String[] numbers = {
      "one",
      "two",
      "three",
      "four",
      "five",
      "six",
      "seven",
      "eight",
      "nine",
    };
    for (int i = 0; i < numbers.length; i++) {
      int m = numbers[i].length();
      Trie subRoot = root;
      for (int j = 0; j < m; j++) {
        int chIdx = numbers[i].charAt(j) - 'a';
        if (subRoot.buffer[chIdx] == null) subRoot.buffer[chIdx] = new Trie();
        subRoot = subRoot.buffer[chIdx];
      }
      subRoot.isEOW = true;
      subRoot.digit = numbers[i];
    }
    // EO: Trie Tree

    for (int i = 0; i < n; i++) {
      char ch = s.charAt(i);
      hMap.put(ch, hMap.getOrDefault(ch, 0) + 1);
      set.add(ch);
    }

    for (int i = 0; i < n; i++) {
      char ch = s.charAt(i);
      Trie subRoot = root;
      if (set.contains(ch) && root.buffer[ch - 'a'] != null) {
        dfs(subRoot, hMap, set, ch);
      }
    }
    return null;
  }
}

public class _423_Reconstruct_Original_Digits_from_English {

  public static void main(String[] args) {
    System.out.println(new Solution().originalDigits("owoztneoer"));
  }
}
