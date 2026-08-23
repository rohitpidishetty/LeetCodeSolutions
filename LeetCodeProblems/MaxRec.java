import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class MaxRec {

  private static int find_Ln_lt_i(int value, int[] towers, int start) {
    while (start >= 0 && towers[start] >= value) start--;
    return start + 1;
  }

  private static int find_Rn_lt_i(int value, int[] towers, int start) {
    while (start < towers.length && towers[start] >= value) start++;
    return start - 1;
  }

  private static int maxRec(int[] towers) {
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < towers.length; i++) {
      // System.out.println(find_Ln_lt_i(towers[i], towers, i - 1) + " for " + i);
      max = Math.max(
        max,
        (find_Rn_lt_i(towers[i], towers, i + 1) -
          find_Ln_lt_i(towers[i], towers, i - 1) +
          1) *
        towers[i]
      );
    }
    return max;
  }

  private static int maxRec_opt_sol(int[] towers) {
    int max = Integer.MIN_VALUE;
    Stack<Integer> leftMargin = new Stack<>();
    int lmargins[] = new int[towers.length];
    int idx = 1;
    leftMargin.push(0);
    for (int i = 1; i < towers.length; i++) {
      while (
        !leftMargin.isEmpty() && towers[i] <= towers[leftMargin.peek()]
      ) leftMargin.pop();
      lmargins[idx] = leftMargin.isEmpty() ? 0 : leftMargin.peek() + 1;
      leftMargin.push(i);
      idx++;
    }

    System.out.println(Arrays.toString(lmargins));
    return max;
  }

  public static void main(String[] args) {
    int[] towers = { 2, 1, 5, 6, 2, 3 };
    System.out.println(maxRec(towers));
    System.out.println(maxRec_opt_sol(towers));
  }
}
