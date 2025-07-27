import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

class Solution {

  private Map<String, List<Integer>> memoMap;

  private List<Integer> solve(String expression) {
    if (memoMap.containsKey(expression)) return memoMap.get(expression);
    int n = expression.length();
    if (expression.chars().allMatch(Character::isDigit)) {
      int value = 0;
      for (int i = 0; i < n; i++) value =
        (value * 10) + (expression.charAt(i) - '0');
      return new ArrayList<Integer>(List.of(value));
    }
    List<Integer> returnValues = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      char ch = expression.charAt(i);
      if (Character.isDigit(ch)) continue;
      char operator = ch;
      String leftOperands = expression.substring(0, i);
      String rightOperands = expression.substring(i + 1, n);
      List<Integer> leftRes = solve(leftOperands);
      List<Integer> rightRes = solve(rightOperands);
      switch (operator) {
        case '+':
          for (int x1 : leftRes) for (int y1 : rightRes) returnValues.add(
            x1 + y1
          );
          break;
        case '-':
          for (int x1 : leftRes) for (int y1 : rightRes) returnValues.add(
            x1 - y1
          );
          break;
        case '*':
          for (int x1 : leftRes) for (int y1 : rightRes) returnValues.add(
            x1 * y1
          );
          break;
      }
    }
    memoMap.put(expression, returnValues);
    return returnValues;
  }

  public List<Integer> diffWaysToCompute(String expression) {
    memoMap = new HashMap<>();
    return solve(expression);
  }
}

public class _241_Different_Ways_to_Add_Parentheses {

  public static void main(String[] args) {
    System.out.println(new Solution().diffWaysToCompute("2*3-4*5"));
  }
}
