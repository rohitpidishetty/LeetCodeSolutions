import java.util.*;

class Solution {

  private class State {

    protected List<Integer> series;
    protected String num;

    public State(List<Integer> series, String num) {
      this.series = series;
      this.num = num;
    }
  }

  public List<Integer> splitIntoFibonacci(String num) {
    Queue<State> bfsQ = new ArrayDeque<>();
    bfsQ.offer(new State(new ArrayList<>(), num));

    while (!bfsQ.isEmpty()) {
      State curr = bfsQ.poll();
      int n = curr.num.length();
      if (n == 0 && curr.series.size() >= 3) return curr.series;

      for (int i = 0; i < n; i++) {
        String STR_F_NUM = curr.num.substring(0, i + 1);
        int x = STR_F_NUM.length();
        if ((x > 1 && STR_F_NUM.charAt(0) == '0') || x > 10) break;
        long lNumber = Long.parseLong(STR_F_NUM);
        if (lNumber > Integer.MAX_VALUE) break;
        int Number = (int) lNumber;
        int size = curr.series.size();
        if (
          size >= 2 &&
          Number != curr.series.get(size - 1) + curr.series.get(size - 2)
        ) {
          if (
            Number > curr.series.get(size - 1) + curr.series.get(size - 2)
          ) break;
          continue;
        }

        List<Integer> series = new ArrayList<>(curr.series);
        series.add(Number);
        bfsQ.offer(new State(series, curr.num.substring(i + 1)));
      }
    }
    return new ArrayList<>();
  }
}

public class _842_Split_Array_into_Fibonacci_Sequence {

  public static void main(String[] args) {
    System.out.println(
      new Solution().splitIntoFibonacci(
        new String(
          "417420815174208193484163452262453871040871393665402264706273658371675923077949581449611550452755"
        )
      )
    );
  }
}
