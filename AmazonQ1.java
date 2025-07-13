import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AmazonQ1 {
  private int sc = 0;
  private int added = 0;
  private int nops = 0;

  private void solve(List<Integer> buffer) {
    for (int be : buffer) {
      if (be == sc + 1) {
        sc++;
        added++;
      }
    }
  }

  private void ops(List<Integer> buffer) {
    int n = buffer.size();
    while (added != n) {

      solve(buffer);
      nops++;
    }
    System.out.println(nops);
  }

  private void opt_sol(List<Integer> buffer) {
    int i = buffer.size() - 1;
    int max = buffer.get(i);
    Set<Integer> e = new HashSet<>();
    e.add(max);
    for (; i > 0; i--) {
      if (buffer.get(i) < buffer.get(i - 1))
        max = buffer.get(i - 1);
      else
        max = Math.max(max, buffer.get(i));
      e.add(max);
    }
    System.out.println(e.size());
  }

  public static void main(String[] args) {
    // new AmazonQ1().ops(new ArrayList<>(Arrays.asList(1, 3, 2, 4, 6, 5, 7, 9, 8)));
    new AmazonQ1().opt_sol(new ArrayList<>(Arrays.asList(1, 3, 2, 4, 6, 5, 7, 9, 8)));
  }
}