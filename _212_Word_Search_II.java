import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// class Solution {

//   private Set<String> wordBucket;
//   private Set<String> Bucket;

//   private void crawl(int i, int j, char[][] board, StringBuilder word) {
//     if (
//       i < 0 ||
//       i >= board.length ||
//       j < 0 ||
//       j >= board[0].length ||
//       board[i][j] == '*'
//     ) return;
//     word.append(board[i][j]);
//     String _word_ = word.toString();
//     if (wordBucket.contains(_word_)) Bucket.add(_word_);
//     char save = board[i][j];
//     board[i][j] = '*';
//     crawl(i - 1, j, board, word);
//     crawl(i + 1, j, board, word);
//     crawl(i, j - 1, board, word);
//     crawl(i, j + 1, board, word);
//     board[i][j] = save;
//     word.deleteCharAt(word.length() - 1);
//   }

//   public List<String> findWords(char[][] board, String[] words) {
//     wordBucket = new HashSet<>();
//     Bucket = new HashSet<>();
//     for (int w = 0; w < words.length; w++) wordBucket.add(words[w]);
//     for (int i = 0; i < board.length; i++) {
//       for (int j = 0; j < board[0].length; j++) {
//         crawl(i, j, board, new StringBuilder());
//       }
//     }
//     return new ArrayList<>(Bucket);
//   }
// }
class Solution {

  private Set<String> buffer;

  static class TrieNode {

    TrieNode[] buffer = new TrieNode[26];
    boolean eow = false;
    String word = new String();
  }

  static class TrieBuilder {

    TrieNode root = new TrieNode();

    public TrieBuilder(String[] words) {
      for (String word : words) {
        TrieNode tnPtr = root;
        int i = 0;
        int n = word.length();
        for (; i < n; i++) {
          int idx = word.charAt(i);
          if (tnPtr.buffer[idx - 'a'] == null) tnPtr.buffer[idx - 'a'] =
            new TrieNode();
          tnPtr = tnPtr.buffer[idx - 'a'];
        }
        tnPtr.eow = true;
        tnPtr.word = word;
      }
    }

    protected TrieNode getRoot() {
      return root;
    }
  }

  private void crawl(int i, int j, TrieNode trieObj, char[][] board) {
    if (
      i < 0 ||
      i >= board.length ||
      j < 0 ||
      j >= board[0].length ||
      board[i][j] == '*'
    ) return;
    TrieNode tn = trieObj.buffer[board[i][j] - 'a'];
    if (tn == null) return;
    if (tn.eow == true) buffer.add(tn.word);
    trieObj = trieObj.buffer[board[i][j] - 'a'];
    char save = board[i][j];
    board[i][j] = '*';
    crawl(i - 1, j, trieObj, board);
    crawl(i + 1, j, trieObj, board);
    crawl(i, j - 1, trieObj, board);
    crawl(i, j + 1, trieObj, board);
    board[i][j] = save;
  }

  public List<String> findWords(char[][] board, String[] words) {
    TrieNode trieObj = new TrieBuilder(words).getRoot();
    buffer = new HashSet<>();
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        TrieNode root = trieObj;
        if (trieObj.buffer[board[i][j] - 'a'] != null) crawl(i, j, root, board);
      }
    }
    return new ArrayList<>(buffer);
  }
}

public class _212_Word_Search_II {

  public static void main(String[] args) {
    System.out.println(
      new Solution()
        .findWords(
          new char[][] {
            { 'o', 'a', 'a', 'n' },
            { 'e', 't', 'a', 'e' },
            { 'i', 'h', 'k', 'r' },
            { 'i', 'f', 'l', 'v' },
          },
          new String[] { "oath", "pea", "eat", "rain" }
        )
    );
  }
}
