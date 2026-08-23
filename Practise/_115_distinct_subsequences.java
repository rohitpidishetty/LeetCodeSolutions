// import java.util.Map;
// import java.util.List;
// import java.util.HashMap;
// import java.util.ArrayList;

// class Solution {
//   public int numDistinct(String s, String t) {
//     char[] s_tokens = s.toCharArray();
//     char[] t_tokens = t.toCharArray();
//     Map<Character, List<Integer>> freq = new HashMap<>();
//     for (int i = 0; i < s_tokens.length; i++) {
//       if (freq.get(s_tokens[i]) == null) {
//         freq.put(s_tokens[i], new ArrayList<>());
//         freq.get(s_tokens[i]).add(i);
//       } else
//         freq.get(s_tokens[i]).add(i);
//     }
//     int t_index = 0;
//     for (int i = 0; i < s_tokens.length; i++) {
//       if (s_tokens[i] == t_tokens[t_index]) {
//         t_index++;
//         if (t_index >= t_tokens.length)
//           break;
//       }
//     }
//     int ret = 0;
//     if (t_index == t_tokens.length) {
//       ret = 1;
//       int t_pointer = t_index - 1;
//       while (t_pointer >= 0) {
//         List<Integer> char_range = freq.get(t_tokens[t_pointer]);
//         while (!char_range.isEmpty() && char_range.getFirst() < t_pointer)
//           char_range.removeFirst();
//         if (t_pointer == t_tokens.length - 1)
//           ret += char_range.size() - 1;
//         else {
//           while (!char_range.isEmpty() && char_range.getLast() > freq.get(t_tokens[t_pointer + 1]).getLast())
//             char_range.removeLast();
//           ret += char_range.size() - 1;
//         }
//         t_pointer--;
//       }
//     }
//     return ret;
//   }
// }

// public class _115_distinct_subsequences {
//   public static void main(String[] args) {
//     System.out.println(new Solution().numDistinct("babgbag", "bag"));
//     System.out.println(new Solution().numDistinct("rabbbit", "rabbit"));
//     System.out.println(new Solution().numDistinct("ddd", "dd"));
//     System.out.println(new Solution().numDistinct("aabb", "ab"));
//   }
// }

import java.util.Arrays;

class Solution {
  public int numDistinct(String s, String t) {
    int m = s.length();
    int n = t.length();

    int[][] dp = new int[n + 1][m + 1];

    for (int j = 0; j <= m; j++)
      dp[0][j] = 1;

    for (int i = 1; i <= n; i++)
      for (int j = 1; j <= m; j++)
        dp[i][j] = (t.charAt(i - 1) == s.charAt(j - 1)) ? dp[i - 1][j - 1] + dp[i][j - 1] : dp[i][j - 1];

    System.out.println(Arrays.deepToString(dp));

    return dp[n][m];
  }
}

public class _115_distinct_subsequences {
  public static void main(String[] args) {
    System.out.println(new Solution().numDistinct("babgbag", "bag"));
    // System.out.println(new Solution().numDistinct("rabbbit", "rabbit"));
    // System.out.println(new Solution().numDistinct("ddd", "dd"));
    // System.out.println(new Solution().numDistinct("aabb", "ab"));
  }
}
