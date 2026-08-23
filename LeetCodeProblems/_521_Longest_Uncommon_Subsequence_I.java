// import java.util.HashMap;
// import java.util.Map;

// class Solution {

//   private Map<String, Integer> memo;

//   private int solve(String a, int a_i, int a_lim, String b, int b_j, int b_lim) {

//     if (a_i >= a_lim || b_j >= b_lim)
//       return 0;

//     String key = a_i + "#" + b_j;

//     if (this.memo.containsKey(key))
//       return this.memo.get(key);

//     int res = 0;
//     if (a.charAt(a_i) == b.charAt(b_j))
//       res = solve(a, a_i + 1, a_lim, b, b_j + 1, b_lim) + 1;
//     int result = Math.max(res,
//         Math.max(solve(a, a_i + 1, a_lim, b, b_j, b_lim), solve(a, a_i, a_lim, b, b_j + 1, b_lim)));
//     this.memo.put(key, result);
//     return result;
//   }

//   public int findLUSlength(String a, String b) {
//     this.memo = new HashMap<>();
//     int i = 0, j = 0;
//     int n = a.length(), m = b.length();
//     int max = Math.max(n, m);
//     int res = max - solve(a, i, n, b, j, m);
//     return res == 0 ? -1 : res;
//   }
// }

// public class _521_Longest_Uncommon_Subsequence_I {
//   public static void main(String[] args) {
//     System.out.println(new Solution().findLUSlength("aadsa", "aerdsaa"));
//   }
// }

class Solution {
  public int findLUSlength(String a, String b) {
    if (a.equals(b))
      return -1;
    return Math.max(a.length(), b.length());
  }
}

public class _521_Longest_Uncommon_Subsequence_I {
  public static void main(String[] args) {
    System.out.println(new Solution().findLUSlength("aadsa", "aerdsaa"));
    System.out.println(new Solution().findLUSlength("aaa", "aaa"));
    System.out.println(new Solution().findLUSlength("abcd", "abc"));
  }
}
