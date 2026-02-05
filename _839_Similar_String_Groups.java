import java.util.Arrays;

class Solution {

  private boolean isSimilar(String s1, String s2, int m) {
    int diff = 0;
    for (int i = 0; i < m; i++) {
      if (s1.charAt(i) != s2.charAt(i)) diff++;
      if (diff > 2) return false;
    }
    return diff == 0 || diff == 2;
  }

  private int[] parent, rank;

  private int parent(int c) {
    if (this.parent[c] == c) return c;
    return this.parent[c] = parent(this.parent[c]); // Compression
  }

  private void union(int p, int c) {
    if (this.rank[p] < this.rank[c]) this.parent[p] = c;
    else if (this.rank[c] < this.rank[p]) this.parent[c] = p;
    else {
      this.parent[c] = p;
      this.rank[p]++;
    }
  }

  public int numSimilarGroups(String[] strs) {
    int n = strs.length;
    int m = strs[0].length();
    this.parent = new int[n];
    this.rank = new int[n];
    int group = n;
    for (int i = 0; i < n; i++) {
      this.parent[i] = i;
      this.rank[i] = 0;
    }
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        int parentOf_i = parent(i);
        int parentOf_j = parent(j);
        if (parentOf_i == parentOf_j) continue; // Same group
        if (isSimilar(strs[i], strs[j], m)) {
          union(parentOf_i, parentOf_j);
          group--;
        }
      }
    }
    return group;
  }
}

public class _839_Similar_String_Groups {

  public static void main(String[] args) {
    System.out.println(
      new Solution().numSimilarGroups(
        new String[] { "tars", "rats", "arts", "star" }
      )
    );
  }
}
