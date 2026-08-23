class Solution {

  private Integer[][] memo;

  private int solve(String s, int l, int r) {
    if (l > r) return 0;
    if (l == r) return 1;

    if (this.memo[l][r] != null) return this.memo[l][r];

    int i = l;
    while (i <= r && s.charAt(l) == s.charAt(i)) i++;
    if (i > r) return 1;
    int j = i;
    int ans1 = 1 + solve(s, j, r);
    int ans2 = ans1;
    int j_next = j + 1;
    while (j_next <= r) {
      if (s.charAt(l) == s.charAt(j_next)) ans2 = Math.min(
        ans2,
        solve(s, i, j_next - 1) + solve(s, j_next, r)
      );
      j_next++;
    }
    return this.memo[l][r] = Math.min(ans1, ans2);
  }

  public int strangePrinter(String s) {
    this.memo = new Integer[101][101];
    return solve(s, 0, s.length() - 1);
  }
}

public class _664_Strange_Printer {

  public static void main(String[] args) {
    System.out.println(new Solution().strangePrinter("abc"));
  }
}
