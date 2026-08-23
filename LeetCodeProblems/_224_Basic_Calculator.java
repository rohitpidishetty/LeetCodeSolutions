import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.regex.Pattern;

class Solution {

  private List<String> cousineNumbers(List<String> tape) {
    List<String> buffer = new ArrayList<>();
    int n = tape.size();
    for (int i = 0; i < n; i++) {
      String word = tape.get(i);
      if (Pattern.matches("[0-9]", word)) {
        StringBuilder sb = new StringBuilder();
        while (i < n && Pattern.matches("[0-9]", tape.get(i))) {
          sb.append(tape.get(i));
          i++;
        }
        buffer.add(sb.toString());
        i--;
      } else buffer.add(word);
    }
    return buffer;
  }

  private String subEquation(List<String> sEqu) {
    int n = sEqu.size();
    Stack<String> oprtStack = new Stack<>();
    Stack<String> oprdStack = new Stack<>();
    for (int i = 0; i < n; i++) {
      String word = sEqu.get(i);
      if (word.equals("#")) continue;
      if (word.equals("+") || word.equals("-")) oprtStack.push(word);
      else oprdStack.push(word);
    }

    while (!oprtStack.isEmpty()) {
      String operator = oprtStack.pop();
      int rightOperand = Integer.parseInt(oprdStack.pop());
      int leftOperand = Integer.parseInt(oprdStack.pop());
      if (operator.equals("+")) oprdStack.push(
        String.valueOf(rightOperand + leftOperand)
      );
      else oprdStack.push(String.valueOf(leftOperand - rightOperand));
    }
    return oprdStack.pop();
  }

  private int eval(List<String> tape) {
    int n = tape.size();
    Stack<String> oprdStack = new Stack<>();
    Stack<String> oprtStack = new Stack<>();
    for (int i = 0; i < n; i++) {
      String word = tape.get(i);
      if (word.equals("#")) continue;
      if (word.equals("+") || word.equals("-")) oprtStack.push(word);
      else oprdStack.push(word);
    }
    while (!oprtStack.isEmpty()) {
      String operator = oprtStack.pop();
      int rightOperand = Integer.parseInt(oprdStack.pop());
      int leftOperand = Integer.parseInt(oprdStack.pop());

      if (operator.equals("+")) oprdStack.push(
        String.valueOf(leftOperand + rightOperand)
      );
    }
    String res = oprdStack.pop();
    if (Pattern.matches("[-][0-9]+", res)) {
      return (-1 * Integer.parseInt(res.substring(1)));
    }
    return Integer.parseInt(res);
  }

  private List<String> evaluateBrackets(List<String> tape) {
    int n = tape.size();
    int j = n - 1;
    for (int i = n - 1; i >= 0; i--) {
      if (tape.get(i).equals("(")) {
        tape.set(i, "#");
        j = i + 1;
        List<String> sequ = new ArrayList<>();
        while (!tape.get(j).equals(")")) {
          sequ.add(tape.get(j));
          tape.set(j, "#");
          j++;
        }
        tape.set(j, subEquation(sequ));
      }
    }
    List<String> res = new ArrayList<>();
    for (String t : tape) if (!t.equals("#")) res.add(t);
    return res;
  }

  public int calculate(String s) {
    char[] tokens = s.toCharArray();
    List<Character> numTape = new ArrayList<>();
    List<String> TAPE = new ArrayList<>();
    for (int i = 0; i < tokens.length; i++) {
      if (tokens[i] != 32) {
        if (tokens[i] != '-') {
          numTape.add(tokens[i]);
          TAPE.add(String.valueOf(tokens[i]));
        } else {
          System.out.println(numTape);
          if (numTape.size() > 0) {
            char recentlyAdded = numTape.getLast();
            if (
              (recentlyAdded >= '0' && recentlyAdded <= '9') ||
              recentlyAdded == ')'
            ) {
              numTape.add(tokens[i]);
              TAPE.add(String.valueOf(tokens[i]));
            } else {
              StringBuilder subStream = new StringBuilder();

              i++;
              if (tokens[i] != '-') subStream.append('-');
              else i++;

              while (
                i < tokens.length && tokens[i] >= '0' && tokens[i] <= '9'
              ) subStream.append(tokens[i++]);
              i--;
              TAPE.add(subStream.toString());
            }
          }
        }
      }
    }
    List<String> res = evaluateBrackets(cousineNumbers(TAPE));
    int operandCount = 0;
    int operatorCount = 0;
    int n = res.size();
    for (int i = 0; i < n; i++) {
      if (res.get(i).equals("+") || res.get(i).equals("-")) operatorCount++;
      else operandCount++;
    }
    if (operandCount == operatorCount) return calculate(String.join("", res));
    else return eval(minusEval(res));
  }

  private List<String> minusEval(List<String> res) {
    int i = 0;
    int n = res.size();
    for (; i < n; i++) {
      if (res.get(i) == null) continue;
      if (res.get(i).equals("-")) {
        res.set(
          i - 1,
          String.valueOf(
            Integer.parseInt(res.get(i - 1)) - Integer.parseInt(res.get(i + 1))
          )
        );
        res.set(i, null);
        res.set(i + 1, null);
      }
    }
    List<String> forward = new ArrayList<>();
    for (i = 0; i < n; i++) {
      String val = res.get(i);
      if (val == null) continue;
      forward.add(val);
    }
    return forward;
  }
}

public class _224_Basic_Calculator {

  public static void main(String[] args) {
    System.out.println(
      // new Solution().calculate("(123+(434+5232   +-223)--323)+(62+8)")
    );
    // System.out.println(new Solution().calculate("10+-(13+2)"));
    // System.out.println(new Solution().calculate("2-1 + 2"));
    System.out.println(new Solution().calculate("-2-1"));
  }
}
