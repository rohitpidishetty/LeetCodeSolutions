import java.util.Arrays;

class Solution {
  public int findMinMoves(int[] machines) {
    int sum = Arrays.stream(machines).sum();
    int n = machines.length;
    if (sum % n == 0) {
      int each_machine = sum / n;
      for (int i = 0; i < n; i++)
        machines[i] -= each_machine;
      int max = 0;
      int dresses_needed_on_left_side_machined = 0;
      for (int i = 0; i < n; i++) {
        dresses_needed_on_left_side_machined += machines[i];
        max = Math.max(max, Math.max(Math.abs(dresses_needed_on_left_side_machined), machines[i]));
      }
      return max;
    }
    return -1;
  }
}

public class _517_Super_Washing_Machines {
  public static void main(String[] args) {
    System.out.println(new Solution().findMinMoves(new int[] { 1, 0, 5 }));
  }
}