import java.util.ArrayList;
import java.util.List;

class Solution {

  private void solve(
    char[] tokens,
    int index,
    int size,
    int opBrkts,
    int clBrkts,
    int balFactor,
    List<Character> buffer
  ) {
    // Base condition
    if(index > size) return;
    buffer.add(tokens[index]);
    solve(tokens, index + 1, size, opBrkts, clBrkts, balFactor, buffer);
    solve(tokens, index + 2, size, opBrkts, clBrkts, balFactor, buffer);
  }

  public List<String> removeInvalidParentheses(String s) {
    char[] tokens = s.toCharArray();
    int size = tokens.length;
    int lbc = 0;
    int rbc = 0;
    for (char tkn : tokens) {
      if (tkn == '(') lbc++;
      else if (tkn == ')') rbc++;
    }
    int balanceFactor = Math.min(lbc, rbc);
    solve(tokens, 0, size, 0, 0, balanceFactor, new ArrayList<Character>());
    return null;
  }
}

public class _301_Remove_Invalid_Parentheses {

  public static void main(String[] args) {
    System.out.println(new Solution().removeInvalidParentheses("(a)())()"));
  }
}
