class Solution {

  private Boolean memo[][][];

  private boolean solve(char[] tokens, int idx, int op, int cl, int n) {
    if (idx > n) return false;
    if (cl > op) return false; // (())))))
    if (idx == n) return op == cl;
    if (this.memo[idx][op][cl] != null) return this.memo[idx][op][cl];
    boolean state = false;
    if (
      tokens[idx] == '(' && solve(tokens, idx + 1, op + 1, cl, n)
    ) return true;
    else if (
      tokens[idx] == ')' && solve(tokens, idx + 1, op, cl + 1, n)
    ) return true;
    else if (tokens[idx] == '*') {
      // it can be any of [(, ), ""]
      state |=
        solve(tokens, idx + 1, op + 1, cl, n) ||
        solve(tokens, idx + 1, op, cl + 1, n) ||
        solve(tokens, idx + 1, op, cl, n);
    }

    if (state) return true;

    return this.memo[idx][op][cl] = state;
  }

  public boolean checkValidString(String s) {
    char[] tokens = s.toCharArray();
    int index, op, cl;
    this.memo = new Boolean[101][101][101];
    return solve(tokens, index = 0, op = 0, cl = 0, s.length());
  }
}

public class _678_Valid_Paranthesis_String {

  public static void main(String[] args) {
    System.out.println(new Solution().checkValidString("(()*)"));
  }
}
