import java.util.Arrays;

class Solution {
  // public boolean checkRecord(String s) {
  // char prev = '\0';
  // int l_count = 0;
  // int absent_count = 0;
  // for (char ch : s.toCharArray()) {
  // if (ch != 'P') {
  // if (ch == 'A') {
  // absent_count++;
  // if (absent_count >= 2)
  // return false;
  // }
  // if (ch == 'L') {
  // if (ch != prev)
  // l_count = 1;
  // else {
  // l_count++;
  // if (l_count >= 3)
  // return false;
  // }
  // }
  // }
  // prev = ch;
  // }
  // return true;
  // }

  // private int solve(StringBuilder sb, int position, int limit) {
  // if (!checkRecord(sb.toString()))
  // return 0;
  // if (position == limit)
  // return 1;

  // int ans = 0;
  // for (char ch : new char[] { 'P', 'A', 'L' }) {
  // ans += solve(sb.append(ch), position + 1, limit);
  // sb.deleteCharAt(sb.length() - 1);
  // }
  // return ans;
  // }

  // public int checkRecord(int n) {
  // return solve(new StringBuilder(), 0, n);
  // }

  // private Integer[][][] memo;

  // private int solve(int days, int a, int l) {
  // int MOD = 1000000007;
  // if (this.memo[days][a][l] != null)
  // return this.memo[days][a][l];
  // if (l > 2 || a > 1)
  // return 0;
  // if (days == 0)
  // return 1;
  // int A = solve(days - 1, a + 1, 0) % MOD;
  // int L = solve(days - 1, a, l + 1) % MOD;
  // int P = solve(days - 1, a, 0) % MOD;
  // int ans = (((A + L) % MOD) + P) % MOD;
  // this.memo[days][a][l] = ans;
  // return ans;
  // }

  // public int checkRecord(int n) {
  // this.memo = new Integer[100001][3][4];
  // int A = 0, L = 0;
  // return solve(n, A, L);
  // }

  // private int solve(int days, int a, int l) {
  // int MOD = 1000000007;
  // if (this.memo[days][a][l] != null)
  // return this.memo[days][a][l];
  // if (l > 2 || a > 1)
  // return 0;
  // if (days == 0)
  // return 1;
  // int A = solve(days - 1, a + 1, 0) % MOD;
  // int L = solve(days - 1, a, l + 1) % MOD;
  // int P = solve(days - 1, a, 0) % MOD;
  // int ans = (((A + L) % MOD) + P) % MOD;
  // this.memo[days][a][l] = ans;

  // return ans;
  // }

  public int checkRecord(int n) {
    int memo[][][] = new int[n + 1][2][3];
    int A = 0, L = 0;

    for (A = 0; A <= 1; A++)
      for (L = 0; L <= 2; L++)
        memo[0][A][L] = 1;

    for (int days = 1; days <= n; days++) {
      for (A = 0; A <= 1; A++) {
        for (L = 0; L <= 2; L++) {

          long ans = (memo[days - 1][A][0]); // solve(days - 1, a, 0)
          /**
           * if (l > 2 || a > 1)
           * return 0;
           */
          ans += (L + 1 <= 2 ? memo[days - 1][A][L + 1] : 0); // solve(days - 1, a, l + 1)
          ans += (A + 1 <= 1 ? memo[days - 1][A + 1][0] : 0); // solve(days - 1, a + 1, 0)
          memo[days][A][L] = (int) (ans % 1000000007);

        }
      }
    }
    // System.out.println(Arrays.deepToString(memo));
    return (int) memo[n][0][0];
  }
}

public class _552_Student_Attendance_Record_II {
  public static void main(String[] args) {
    System.out.println(new Solution().checkRecord(10101));
  }
}
