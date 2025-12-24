import java.util.*;

class MapSum {

  protected class TrieNode {

    protected TrieNode[] buffer;
    protected boolean isEOW;
    protected String word;

    public TrieNode() {
      this.buffer = new TrieNode[26];
      this.isEOW = false;
    }
  }

  private void buildTree(String word, TrieNode seed) {
    for (char ch : word.toCharArray()) {
      int index = ch - 'a';
      if (seed.buffer[index] == null) seed.buffer[index] = new TrieNode();
      seed = seed.buffer[index];
    }
    seed.isEOW = true;
    seed.word = word;
  }

  private Map<String, Integer> map;
  private TrieNode root;

  public MapSum() {
    this.map = new HashMap<>();
    this.root = new TrieNode();
  }

  public void insert(String key, int val) {
    map.put(key, val);
    buildTree(key, this.root);
  }

  public int sum(String prefix) {
    TrieNode seed = this.root;
    for (char ch : prefix.toCharArray()) {
      int idx = ch - 'a';
      if (seed.buffer[idx] == null) return 0;
      seed = seed.buffer[idx];
    }
    return __get_children__(seed, new StringBuilder().append(prefix));
  }

  private int __get_children__(TrieNode root, StringBuilder sb) {
    if (root == null) return 0;
    int ans = 0;
    if (root.isEOW) ans += this.map.get(sb.toString());

    for (int i = 0; i < 26; i++) {
      if (root.buffer[i] != null) {
        ans += __get_children__(root.buffer[i], sb.append((char) (i + 'a')));
        sb.deleteCharAt(sb.length() - 1);
      }
    }
    return ans;
  }
}

public class _677_Map_Sum_Pairs {

  public static void main(String[] args) {
    MapSum obj = new MapSum();
    obj.insert("apple", 3);
    System.out.println(obj.sum("ap")); // 3
    obj.insert("app", 2);
    System.out.println(obj.sum("ap")); // 5
  }
}
