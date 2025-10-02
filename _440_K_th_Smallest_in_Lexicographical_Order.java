import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class NTrie {

  // NTrie: Number Trie
  protected NTrie[] buffer;
  protected boolean EON;
  protected int number;

  public NTrie() {
    this.buffer = new NTrie[10];
    this.EON = false;
    this.number = 0;
  }
}

class Solution {

  private void dfs(NTrie root, List<Integer> buffer) {
    if (root == null) return;
    if (root.EON) buffer.add(root.number);
    for (NTrie buf : root.buffer) dfs(buf, buffer);
  }

  public int findKthNumber_v0(int n, int k) {
    if (k == 0) return 0;
    NTrie root = new NTrie();
    for (int i = 1; i <= n; i++) {
      NTrie subRoot = root;
      String num = Integer.toString(i);
      int m = num.length();
      for (int j = 0; j < m; j++) {
        int ch = num.charAt(j) - '0';
        if (subRoot.buffer[ch] == null) subRoot.buffer[ch] = new NTrie();
        subRoot = subRoot.buffer[ch];
      }
      subRoot.EON = true;
      subRoot.number = i;
    }

    List<Integer> buffer = new ArrayList<>();
    dfs(root, buffer);
    return buffer.get(k - 1);
  }

  public int findKthNumber(int n, int k) {
    int current = 1;
    k -= 1; // as we have already considered '1'.

    int currentNumber = current;
    while (k > 0) {
      int steps_to_goto_next_number = countSteps(
        currentNumber,
        currentNumber + 1,
        n
      );
      if (steps_to_goto_next_number <= k) {
        currentNumber++;
        k -= steps_to_goto_next_number;
      } else {
        currentNumber *= 10; // Going to the depth of the tree.
        k--;
      }
    }
    return currentNumber;
  }

  private int countSteps(int curr, int next, int limit) {
    int steps = 0;
    while (curr <= limit) {
      // Math.min(limit + 1, next) | As 'next' can not pass the limit + 1'th element, we just guard it safely with minimum.
      // step = (2 * 10^0 - 1 * 10^0) + (2 * 10^1 - 1 * 10^1) + (2 * 10^n - 1 * 10^n), where [(1 * 10^n) < limit]
      steps += (Math.min(limit + 1, next) - curr);
      curr *= 10;
      next *= 10;
    }
    return steps;
  }
}

public class _440_K_th_Smallest_in_Lexicographical_Order {

  public static void main(String[] args) {
    System.out.println(new Solution().findKthNumber(10, 3));
  }
}
