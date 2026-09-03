import java.util.ArrayList;
import java.util.List;

class Solution {

  private void solve(
    int idx,
    String digits,
    char[][] ch,
    StringBuilder sb,
    int n,
    List<String> res
  ) {
    if (idx == n) {
      res.add(sb.toString());
      return;
    }
    int index = (digits.charAt(idx) - '0') - 1;
    for (char c : ch[index]) {
      sb.append(c);
      solve(idx + 1, digits, ch, sb, n, res);
      sb.deleteCharAt(sb.length() - 1);
    }
  }

  public List<String> letterCombinations(String digits) {
    char[][] ch = {
      {},
      { 'a', 'b', 'c' },
      { 'd', 'e', 'f' },
      { 'g', 'h', 'i' },
      { 'j', 'k', 'l' },
      { 'm', 'n', 'o' },
      { 'p', 'q', 'r', 's' },
      { 't', 'u', 'v' },
      { 'w', 'x', 'y', 'z' },
    };
    List<String> res = new ArrayList<>();
    solve(0, digits, ch, new StringBuilder(), digits.length(), res);
    return res;
  }
}

public class _17_Letter_Combinations_of_a_Phone_Number {

  public static void main(String[] args) {
    System.out.println(new Solution().letterCombinations(""));
  }
}
