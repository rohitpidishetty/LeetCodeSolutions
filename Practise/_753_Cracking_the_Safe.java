import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

// class Solution {

//   public String crackSafe(int n, int k) {
//     List<String> passwords = new ArrayList<>();
//     Queue<char[]> bfsQ = new ArrayDeque<>();
//     char key[] = new char[n];
//     Arrays.fill(key, (char) 47);
//     Set<String> visited = new HashSet<>();
//     bfsQ.add(key);
//     while (!bfsQ.isEmpty()) {
//       char curr[] = bfsQ.poll();
//       String password = new String(curr);
//       if (!password.contains("/")) passwords.add(password);
//       for (int i = 0; i < n; i++) {
//         char[] cpy = Arrays.copyOf(curr, n);
//         int m = (int) cpy[i];
//         if (m + 1 < 48 + k) {
//           cpy[i] = (char) (m + 1);
//           String next = new String(cpy);
//           if (!visited.contains(next)) {
//             bfsQ.add(cpy);
//             visited.add(next);
//           }
//         }
//       }
//     }
//     System.out.println(passwords);

//     return null;
//   }
// }

class Solution {

  StringBuilder ans = new StringBuilder();
  Set<String> visited = new HashSet<>();
  int n, k;

  public String crackSafe(int n, int k) {
    this.n = n;
    this.k = k;

    String start = "0".repeat(n - 1);

    dfs(start);

    ans.append(start);
    return ans.toString();
  }

  private void dfs(String node) {
    System.out.println(node);
    for (int i = 0; i < k; i++) {
      String edge = node + i;
      if (!visited.contains(edge)) {
        visited.add(edge);
        dfs(edge.substring(1));
        ans.append(i);
      }
    }
  }
}

public class _753_Cracking_the_Safe {

  public static void main(String[] args) {
    System.out.println(new Solution().crackSafe(4, 5));
  }
}
