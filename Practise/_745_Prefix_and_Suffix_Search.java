import java.util.Arrays;

class WordFilter {

  class TrieNode {

    protected TrieNode[] buffer;
    protected boolean isEOW;
    protected int index;

    public TrieNode(int index) {
      this.buffer = new TrieNode[27];
      this.isEOW = false;
      this.index = index;
    }
  }

  private TrieNode root;

  public WordFilter(String[] words) {
    this.root = new TrieNode(-1);
    int index = 0;
    for (String word : words) {
      StringBuilder sb = new StringBuilder(word);
      while (!sb.isEmpty()) {
        TrieNode seed = this.root;
        String _word_ = sb + "{" + word;
        for (char ch : _word_.toCharArray()) {
          if (seed.buffer[ch - 'a'] == null) seed.buffer[ch - 'a'] =
            new TrieNode(index);
          seed = seed.buffer[ch - 'a'];
          seed.index = index;
        }
        seed.isEOW = true;
        sb.deleteCharAt(0);
      }
      index++;
    }
  }

  public int f(String pref, String suff) {
    TrieNode seed = this.root;
    String search = suff + "{" + pref;
    for (char ch : search.toCharArray()) {
      int idx = ch - 'a';
      if (seed.buffer[idx] == null) return -1;
      seed = seed.buffer[idx];
    }
    return seed.index;
  }
}

public class _745_Prefix_and_Suffix_Search {

  public static void main(String[] args) {
    WordFilter o = new WordFilter(new String[] { "apple" });
    System.out.println(o.f(new String("ap"), new String("ple")));
  }
}
