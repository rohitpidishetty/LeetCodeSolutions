class MagicDictionary {

  private class TrieNode {

    protected TrieNode[] buffer;
    protected boolean isEOW;

    public TrieNode() {
      this.buffer = new TrieNode[26];
      this.isEOW = false;
    }
  }

  private TrieNode root;

  public MagicDictionary() {
    this.root = new TrieNode();
  }

  public void buildDict(String[] dictionary) {
    for (String word : dictionary) {
      TrieNode seed = this.root;
      for (char ch : word.toCharArray()) {
        int index = ch - 'a';
        if (seed.buffer[index] == null) seed.buffer[index] = new TrieNode();
        seed = seed.buffer[index];
      }
      seed.isEOW = true;
    }
  }

  private boolean solve(
    String search,
    int index,
    TrieNode root,
    boolean alreadyModified,
    int n
  ) {
    if (root == null || index > n) return false;
    if (index == n) return root.isEOW && alreadyModified;
    /**
     *                          h
     *                         /
     *                       [e,a]
     *                      /     \
     *                     l       l
     *                    /         \
     *                   l           l
     *                  /             \
     *                 o               o
     */
    // We can modify a char at each index or we can simply choose not to. (skip & take idealogy)
    int ch_idx = search.charAt(index) - 'a';
    if (
      root.buffer[ch_idx] != null &&
      solve(search, index + 1, root.buffer[ch_idx], alreadyModified, n)
    ) return true;

    if (alreadyModified == false) {
      for (int i = 0; i < 26; i++) {
        if (i == ch_idx) continue;
        if (
          root.buffer[i] != null &&
          solve(search, index + 1, root.buffer[i], true, n)
        ) return true;
      }
    }

    return false;
  }

  public boolean search(String searchWord) {
    int index;
    boolean alreadyModified;
    return solve(
      searchWord,
      index = 0,
      this.root,
      alreadyModified = false,
      searchWord.length()
    );
  }
}

public class _676_Implement_Magic_Dictionary {

  public static void main(String[] args) {
    MagicDictionary obj = new MagicDictionary();
    obj.buildDict(new String[] { "hello", "leetcode", "hallo" });
    System.out.println(obj.search("hello"));
    System.out.println(obj.search("hhllo"));
    System.out.println(obj.search("hell"));
    System.out.println(obj.search("leetcoded"));
  }
}
