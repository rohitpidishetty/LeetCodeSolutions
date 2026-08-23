import java.util.*;

class Solution {

  public int evaluate(String expression) {
    return eval(expression, new HashMap<>());
  }

  private int eval(String expr, Map<String, Integer> scope) {
    if (isNumber(expr)) {
      return Integer.parseInt(expr);
    }

    if (!expr.startsWith("(")) {
      return scope.get(expr);
    }

    expr = expr.substring(1, expr.length() - 1);

    List<String> tokens = split(expr);
    String op = tokens.get(0);

    if (op.equals("add")) {
      return (
        eval(tokens.get(1), new HashMap<>(scope)) +
        eval(tokens.get(2), new HashMap<>(scope))
      );
    }

    if (op.equals("mult")) {
      return (
        eval(tokens.get(1), new HashMap<>(scope)) *
        eval(tokens.get(2), new HashMap<>(scope))
      );
    }

    Map<String, Integer> local = new HashMap<>(scope);
    for (int i = 1; i < tokens.size() - 1; i += 2) {
      String var = tokens.get(i);
      int val = eval(tokens.get(i + 1), local);
      local.put(var, val);
    }
    return eval(tokens.get(tokens.size() - 1), local);
  }

  private boolean isNumber(String s) {
    return s.charAt(0) == '-' || Character.isDigit(s.charAt(0));
  }

  private List<String> split(String s) {
    List<String> res = new ArrayList<>();
    int balance = 0;
    StringBuilder sb = new StringBuilder();

    for (char c : s.toCharArray()) {
      if (c == ' ' && balance == 0) {
        res.add(sb.toString());
        sb.setLength(0);
      } else {
        if (c == '(') balance++;
        if (c == ')') balance--;
        sb.append(c);
      }
    }
    res.add(sb.toString());
    return res;
  }
}

public class _736_Parse_Lisp_Expression {

  public static void main(String[] args) {
    System.out.println(
      new Solution().evaluate("(let x 2 (mult x (let x 3 y 4 (add x y))))")
    );
  }
}
