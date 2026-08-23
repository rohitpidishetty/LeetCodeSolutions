import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

class Solution {

  public int kSimilarity(String s1, String s2) {
    int n = s1.length();

    Queue<String> bfsQ = new ArrayDeque<>();
    Set<String> visited = new HashSet<>();

    bfsQ.add(s1);

    int level = 0;
    while (!bfsQ.isEmpty()) {
      int m = bfsQ.size();

      for (int k = 0; k < m; k++) {
        String sn = bfsQ.poll();

        if (!visited.contains(sn)) {
          if (sn.equals(s2)) return level;
          // Decide i'th pos, i.e, skip all equals
          int i = 0;
          while (i < n && sn.charAt(i) == s2.charAt(i)) i++;
          char[] tkn = sn.toCharArray();

          for (int j = i + 1; j < n; j++) {
            if (tkn[j] == s2.charAt(i) && tkn[j] != s2.charAt(j)) {
              char temp = tkn[i];
              tkn[i] = tkn[j];
              tkn[j] = temp;
              bfsQ.add(new String(tkn));
              // Undoing
              temp = tkn[i];
              tkn[i] = tkn[j];
              tkn[j] = temp;
            }
          }

          visited.add(sn);
        }
      }
      level++;
    }

    return level;
  }
}

public class _854_K_Similar_Strings {

  public static void main(String[] args) {
    System.out.println(new Solution().kSimilarity("ab", "ba"));
  }
}
