import java.util.*;

class Solution {

  private boolean solve(List<Double> buffer) {
    int size = buffer.size();
    if (size == 1) return Math.abs(buffer.get(0) - 24) < 1e-6;
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        if (i != j) {
          double a = buffer.get(i), b = buffer.get(j);
          List<Double> possible = new ArrayList<>();
          possible.add(a + b);
          possible.add(a - b);
          possible.add(a * b);
          if (b > 0) possible.add(a / b);
          if (a > 0) possible.add(b / a);
          List<Double> rest = new ArrayList<>();
          for (int k = 0; k < size && size > 1; k++) if (
            k != i && k != j
          ) rest.add(buffer.get(k));
          for (double possible_ans : possible) {
            rest.add(possible_ans);
            if (solve(rest)) return true;
            rest.removeLast();
          }
        }
      }
    }
    return false;
  }

  public boolean judgePoint24(int[] cards) {
    List<Double> buffer = new ArrayList<>();
    for (int n : cards) buffer.add(n * 1.0);

    return solve(buffer);
  }
}

public class _679_24_Game {

  public static void main(String[] args) {
    System.out.println(new Solution().judgePoint24(new int[] { 4, 1, 8, 7 }));
  }
}
