import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

class Solution {

  private class atom {

    protected String name;
    protected String num;

    public atom(String name, int num) {
      this.name = name;
      this.num = (num > 1) ? String.valueOf(num) : "";
    }
  }

  private Map<String, Integer> process(Queue<Character> q, int num) {
    q.offer('D'); // dummy
    Map<String, Integer> data = new HashMap<>();
    StringBuilder s = new StringBuilder();
    while (!q.isEmpty()) {
      if (q.peek() >= 'A' && q.peek() <= 'Z') {
        int n = s.length();
        int i = 0;
        for (; i < n; i++) {
          char ch = s.charAt(i);
          if (ch >= '0' && ch <= '9') break;
        }
        String start = s.substring(0, i);
        String end = s.substring(i);
        int en = (end.length() == 0 ? 1 : Integer.parseInt(end)) * num;
        if (start.length() != 0) {
          if (data.containsKey(start)) data.put(start, data.get(start) + en);
          else data.put(start, en);
        }
        s.setLength(0);
      }
      s.append(q.poll());
    }
    return data;
  }

  private String stringify(Map<String, Integer> data) {
    StringBuffer _sb_ = new StringBuffer();
    for (Map.Entry<String, Integer> m : data.entrySet()) {
      _sb_.append(m.getKey()).append(m.getValue());
    }
    return _sb_.toString();
  }

  public String countOfAtoms(String formula) {
    char[] tokens = formula.toCharArray();
    Stack<Character> stack = new Stack<>();
    int readPtr = tokens.length - 1;
    for (int i = readPtr; i > -1; i--) {
      String TOKEN = String.valueOf(tokens[i]);
      if (tokens[i] == '(') {
        Queue<Character> q = new ArrayDeque<>();
        while (!stack.isEmpty() && stack.peek() != ')') {
          q.offer(stack.pop());
        }
        stack.pop(); // removing ')'
        StringBuilder number = new StringBuilder();
        while (
          !stack.isEmpty() &&
          stack.peek() >= '0' &&
          stack.peek() <= '9' &&
          stack.peek() != ')'
        ) {
          number.append(stack.pop());
        }
        Integer num;
        if (number.length() == 0) num = 1;
        else num = Integer.parseInt(number.toString());
        String pushBack = stringify(process(q, num));
        int m = pushBack.length() - 1;
        for (int j = m; j >= 0; j--) stack.push(pushBack.charAt(j));
      } else stack.push(tokens[i]);
    }
    Queue<Character> q = new ArrayDeque<>();
    while (!stack.isEmpty()) q.offer(stack.pop());
    Map<String, Integer> d = process(q, 1);
    List<atom> l = new ArrayList<>();
    for (Map.Entry<String, Integer> m : d.entrySet()) {
      l.add(new atom(m.getKey(), m.getValue()));
    }
    Collections.sort(l, (a, b) -> a.name.compareTo(b.name));
    StringBuilder count = new StringBuilder();
    for (atom a : l) count.append(a.name).append(a.num);
    return count.toString();
  }
}

public class _726_Number_of_Atoms {

  public static void main(String[] args) {
    System.out.println(
      new Solution()
        .countOfAtoms(
          new String(
            "((N42)24(OB40Li30CHe3O48LiNN26)33(C12Li48N30H13HBe31)21(BHN30Li26BCBe47N40)15(H5)16)14"
          )
        )
    );
    System.out.println(new Solution().countOfAtoms(new String("Mg(H2O)N")));
  }
}
