class Solution {

  private class Trie {

    protected Trie[] buffer;
    protected boolean isEOW;
    protected String word;

    public Trie() {
      this.buffer = new Trie[26];
      this.isEOW = false;
      this.word = new String();
    }
  }

  private void dfs(Trie r, StringBuilder ms) {
    if (r == null) return;

    if (r.isEOW) {
      if (ms.length() < r.word.length()) {
        ms.setLength(0);
        ms.append(r.word);
      }
    }
    for (int i = 0; i < 26; i++) {
      if (r.buffer[i] != null && r.buffer[i].isEOW == true) {
        dfs(r.buffer[i], ms);
      }
    }
  }

  public String longestWord(String[] words) {
    Trie root = new Trie();
    for (String word : words) {
      Trie seed = root;
      for (char ch : word.toCharArray()) {
        int index = ch - 'a';
        if (seed.buffer[index] == null) seed.buffer[index] = new Trie();
        seed = seed.buffer[index];
      }
      seed.isEOW = true;
      seed.word = word;
    }

    StringBuilder maxString = new StringBuilder();

    dfs(root, maxString);

    return maxString.toString();
  }
}

public class _720_Longest_Word_in_Dictionary {

  public static void main(String[] args) {
    System.out.println(
      new Solution()
        .longestWord(
          new String[] { "a", "banana", "app", "appl", "ap", "apply", "apple" }
        )
    );
    System.out.println(
      new Solution()
        .longestWord(
          new String[] {
            "yo",
            "ew",
            "fc",
            "zrc",
            "yodn",
            "fcm",
            "qm",
            "qmo",
            "fcmz",
            "z",
            "ewq",
            "yod",
            "ewqz",
            "y",
          }
        )
    );
  }
}
