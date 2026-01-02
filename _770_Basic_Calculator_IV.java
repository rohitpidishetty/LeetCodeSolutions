import java.util.*;

class Solution {

  static class Poly {

    Map<List<String>, Integer> map = new HashMap<>();

    Poly() {}

    Poly(int value) {
      if (value != 0) map.put(new ArrayList<>(), value);
    }

    static Poly variable(String v) {
      Poly p = new Poly();
      p.map.put(Arrays.asList(v), 1);
      return p;
    }

    Poly add(Poly other, int sign) {
      for (var e : other.map.entrySet()) {
        map.merge(e.getKey(), sign * e.getValue(), Integer::sum);
        if (map.get(e.getKey()) == 0) map.remove(e.getKey());
      }
      return this;
    }

    Poly multiply(Poly other) {
      Poly res = new Poly();
      for (var a : map.entrySet()) {
        for (var b : other.map.entrySet()) {
          List<String> vars = new ArrayList<>();
          vars.addAll(a.getKey());
          vars.addAll(b.getKey());
          Collections.sort(vars);
          res.map.merge(vars, a.getValue() * b.getValue(), Integer::sum);
        }
      }
      return res;
    }
  }

  List<String> tokens;
  int idx = 0;

  public List<String> basicCalculatorIV(
    String expression,
    String[] evalvars,
    int[] evalints
  ) {
    Map<String, Integer> env = new HashMap<>();
    for (int i = 0; i < evalvars.length; i++) env.put(evalvars[i], evalints[i]);

    tokenize(expression);
    Poly poly = parseExpr();

    Poly evaluated = new Poly();
    for (var e : poly.map.entrySet()) {
      int coef = e.getValue();
      List<String> remaining = new ArrayList<>();
      for (String v : e.getKey()) {
        if (env.containsKey(v)) coef *= env.get(v);
        else remaining.add(v);
      }
      if (coef != 0) {
        evaluated.map.merge(remaining, coef, Integer::sum);
        if (evaluated.map.get(remaining) == 0) evaluated.map.remove(remaining);
      }
    }

    return format(evaluated);
  }

  Poly parseExpr() {
    Poly res = parseTerm();
    while (
      idx < tokens.size() &&
      (tokens.get(idx).equals("+") || tokens.get(idx).equals("-"))
    ) {
      String op = tokens.get(idx++);
      Poly rhs = parseTerm();
      res.add(rhs, op.equals("+") ? 1 : -1);
    }
    return res;
  }

  Poly parseTerm() {
    Poly res = parseFactor();
    while (idx < tokens.size() && tokens.get(idx).equals("*")) {
      idx++;
      res = res.multiply(parseFactor());
    }
    return res;
  }

  Poly parseFactor() {
    String t = tokens.get(idx++);
    if (t.equals("(")) {
      Poly p = parseExpr();
      idx++; // consume ')'
      return p;
    }
    if (Character.isDigit(t.charAt(0))) return new Poly(Integer.parseInt(t));
    return Poly.variable(t);
  }

  void tokenize(String s) {
    tokens = new ArrayList<>();
    int n = s.length();
    for (int i = 0; i < n;) {
      char c = s.charAt(i);
      if (c == ' ') {
        i++;
        continue;
      }
      if ("+-*()".indexOf(c) >= 0) {
        tokens.add("" + c);
        i++;
      } else {
        int j = i;
        while (j < n && Character.isLetterOrDigit(s.charAt(j))) j++;
        tokens.add(s.substring(i, j));
        i = j;
      }
    }
  }

  List<String> format(Poly p) {
    if (p.map.isEmpty()) return new ArrayList<>();

    List<Map.Entry<List<String>, Integer>> list = new ArrayList<>(
      p.map.entrySet()
    );

    list.sort((a, b) -> {
      if (a.getKey().size() != b.getKey().size()) return (
        b.getKey().size() - a.getKey().size()
      );
      return a.getKey().toString().compareTo(b.getKey().toString());
    });

    List<String> res = new ArrayList<>();
    for (var e : list) {
      StringBuilder sb = new StringBuilder();
      sb.append(e.getValue());
      for (String v : e.getKey()) sb.append("*").append(v);
      res.add(sb.toString());
    }
    return res;
  }
}
