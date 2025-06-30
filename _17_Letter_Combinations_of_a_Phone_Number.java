import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

  private char[][] digMap = { {}, {}, { 'a', 'b', 'c' }, { 'd', 'e', 'f' }, { 'g', 'h', 'i' },
      { 'j', 'k', 'l' }, { 'm', 'n', 'o' }, { 'p', 'q', 'r', 's' }, { 't', 'u', 'v' }, { 'w', 'x', 'y', 'z' }
  };

  private void recFn(char[] layer, int limit, char[] tokens, int current, StringBuilder sb, List<String> ret) {
    if (current >= limit) {
      return;
    }
    for (char ch : layer) {
      sb.append(ch);
      if (sb.toString().length() == limit)
        ret.add(sb.toString());
      if (current + 1 < limit)
        recFn(digMap[tokens[current + 1] - '0'], limit, tokens, current + 1, sb, ret);
      sb.deleteCharAt(sb.length() - 1);
    }
  }

  public List<String> letterCombinations(String digits) {
    char[] tokens = digits.toCharArray();
    List<String> ret = new ArrayList<>();
    recFn(digMap[tokens[0] - '0'], tokens.length, tokens, 0, new StringBuilder(), ret);
    return ret;
  }
}

public class _17_Letter_Combinations_of_a_Phone_Number {
  public static void main(String[] args) {
    System.out.println(new Solution().letterCombinations("239"));
  }
}
