// import java.util.*;

// class Solution {

//   private int MOD = 1_000_000_007;

//   private int count(List<String> buffer) {
//     int count = 1;
//     for (String top : buffer) {
//       int len = top.length();
//       if (top.equals("*")) count = ((count) * 9) % MOD;
//       else if (len == 2 && top.charAt(0) == '*' && top.charAt(1) == '*') count =
//         ((count) * 15) % MOD;
//       else if (len == 2 && top.charAt(0) == '*') {
//         char d = top.charAt(1);
//         if (d == '0') count = ((count) * 2) % MOD;
//         else if (d >= '1' && d <= '6') count = ((count) * 2) % MOD;
//         else count = ((count) * 1) % MOD;
//       } else if (
//         len == 2 && top.charAt(0) == '1' && top.charAt(1) == '*'
//       ) count = ((count) * 9) % MOD;
//       else if (len == 2 && top.charAt(0) == '2' && top.charAt(1) == '*') count =
//         ((count) * 6) % MOD;
//     }
//     return count;
//   }

//   private int count = 0;

//   private void solve(String stream, List<String> buffer) {
//     int size = stream.length();

//     if (size == 0) {
//       this.count = (int) (((long) this.count + count(buffer)) % MOD);

//       return;
//     }
//     for (int i = 0; i < Math.min(2, size); i++) {
//       String consider = stream.substring(0, i + 1);
//       int m = consider.length();
//       if (
//         (m != 0 && consider.charAt(0) == '0') ||
//         (m == 2 &&
//           (consider.charAt(0) != '*' &&
//             consider.charAt(1) != '*' &&
//             Integer.parseInt(consider) > 26)) ||
//         (m == 2 &&
//           consider.charAt(1) == '*' &&
//           (consider.charAt(0) != '1' &&
//             consider.charAt(0) != '2' &&
//             consider.charAt(0) != '*'))
//       ) continue;
//       String next = stream.substring(i + 1);
//       int _size_ = consider.length();

//       buffer.add(consider);
//       solve(next, buffer);
//       buffer.remove(buffer.size() - 1);
//     }
//   }

//   // 179 / 218 testcases passed
//   public int numDecodings(String s) {
//     solve(s, new ArrayList<String>());
//     return this.count % MOD;
//   }
// }

// public class _639_Decode_Ways_II {

//   public static void main(String[] args) {
//     System.out.println(new Solution().numDecodings("1*72*"));
//   }
// }

class Solution {

  private static final int MOD = 1_000_000_007;

  public int numDecodings(String s) {
    long dp0 = 1;
    long dp1 = helper(s.charAt(0));

    for (int i = 1; i < s.length(); i++) {
      char c = s.charAt(i);
      char p = s.charAt(i - 1);

      long single = (helper(c) * dp1) % MOD;
      long pair = (helper(p, c) * dp0) % MOD;

      long dpi = (single + pair) % MOD;

      dp0 = dp1;
      dp1 = dpi;
    }

    return (int) dp1;
  }

  private int helper(char c) {
    if (c == '*') return 9;
    if (c == '0') return 0;
    return 1;
  }

  private int helper(char a, char b) {
    if (a == '*' && b == '*') return 15;
    if (a == '*') return (b >= '0' && b <= '6') ? 2 : 1;
    if (b == '*') {
      if (a == '1') return 9;
      if (a == '2') return 6;
      return 0;
    }
    int num = (a - '0') * 10 + (b - '0');
    return (num >= 10 && num <= 26) ? 1 : 0;
  }
}
