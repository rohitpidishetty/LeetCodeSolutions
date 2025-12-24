import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

class Solution {

  static class trie_node {

    protected trie_node[] buffer;
    protected boolean EON;
    protected int number;

    public trie_node() {
      buffer = new trie_node[10];
      EON = false;
      number = 0;
    }
  }

  private static class Trie {

    private static trie_node root;

    protected static void init() {
      root = new trie_node();
    }

    protected static trie_node object() {
      return root;
    }

    protected static void seed(int integer) {
      int save = integer;
      List<Integer> buffer = new ArrayList<>();
      if (integer > 9) {
        while (integer != 0) {
          buffer.addFirst(integer % 10);
          integer /= 10;
        }
      } else buffer.add(integer);
      int n = buffer.size();
      trie_node path = root;
      for (int i = 0; i < n; i++) {
        int number = buffer.get(i);
        if (path.buffer[number] == null) path.buffer[number] = new trie_node();
        path = path.buffer[number];
      }
      path.EON = true;
      path.number = save;
    }
  }

  protected void dfs(trie_node tn, List<Integer> buffer) {
    if (tn == null) return;
    if (tn.EON) buffer.add(tn.number);
    for (trie_node ptr : tn.buffer) dfs(ptr, buffer);
  }

  public List<Integer> lexicalOrder(int n) {
    Trie.init();
    for (int i = 1; i <= n; i++) Trie.seed(i);
    List<Integer> buffer = new ArrayList<>();
    dfs(Trie.object(), buffer);
    return buffer;
  }
}

public class _386_Lexicographical_Numbers {

  public static void main(String[] args) {
    System.out.println(new Solution().lexicalOrder(13));
  }
}
