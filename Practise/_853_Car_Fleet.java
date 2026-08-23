import java.util.Arrays;
import java.util.Stack;

class Solution {

  public int carFleet(int target, int[] position, int[] speed) {
    double[][] pair = new double[position.length][];
    for (int i = 0; i < position.length; i++) {
      pair[i] = new double[] {
        position[i],
        (target - position[i]) / (double) speed[i],
      };
    }
    Arrays.sort(pair, (a, b) -> (int) b[0] - (int) a[0]);
    Stack<double[]> s = new Stack<>();
    for (int i = 0; i < position.length; i++) {
      System.out.println(pair[i][0] + " -> " + pair[i][1]);
      if (s.isEmpty()) s.push(pair[i]);
      else {
        if (s.peek()[1] >= pair[i][1]) continue;
        s.push(pair[i]);
      }
    }
    return s.size();
  }
}

public class _853_Car_Fleet {

  public static void main(String[] args) {
    System.out.println(
      new Solution().carFleet(
        12,
        new int[] { 10, 8, 0, 5, 3 },
        new int[] { 2, 4, 1, 1, 3 }
      )
    );

    System.out.println(
      new Solution().carFleet(10, new int[] { 6, 8 }, new int[] { 3, 2 })
    );
  }
}
