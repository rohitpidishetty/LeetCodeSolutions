import java.util.Arrays;
import java.util.List;

class Solution {

  class TrieNode {

    protected TrieNode[] buffer;
    protected boolean isEOW;
    protected String word;

    public TrieNode() {
      this.buffer = new TrieNode[26];
      this.word = new String();
    }
  }

  class BuildTrieTree {

    private TrieNode ROOT;

    public BuildTrieTree(List<String> words) {
      TrieNode root = new TrieNode();
      for (String word : words) {
        TrieNode seed = root;
        for (char ch : word.toCharArray()) {
          int index = ch - 'a';
          if (seed.buffer[index] == null) seed.buffer[index] = new TrieNode();
          seed = seed.buffer[index];
        }
        seed.isEOW = true;
        seed.word = word;
      }
      this.ROOT = root;
    }

    protected String scan(String word) {
      TrieNode _root_ = this.ROOT;
      for (char ch : word.toCharArray()) {
        int index = ch - 'a';
        if (_root_.buffer[index] == null) return null;
        _root_ = _root_.buffer[index];
        if (_root_.isEOW) return _root_.word;
      }

      return null;
    }

    protected TrieNode tree() {
      return this.ROOT;
    }
  }

  public String replaceWords(List<String> dictionary, String sentence) {
    BuildTrieTree obj = new BuildTrieTree(dictionary);
    TrieNode tree = obj.tree();
    String[] tokens = sentence.split(" ");
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < tokens.length; i++) {
      String word = obj.scan(tokens[i]);
      if (word == null) sb.append(tokens[i]).append(" ");
      else sb.append(word).append(" ");
    }
    return sb.toString().trim();
  }
}

public class _648_Replace_Words {

  public static void main(String[] args) {
    System.out.println(
      new Solution()
        .replaceWords(
          Arrays.asList("a", "aa", "aaa", "aaaa"),
          new String("a aa a aaaa aaa aaa aaa aaaaaa bbb baba ababa")
        )
    );
  }
}
