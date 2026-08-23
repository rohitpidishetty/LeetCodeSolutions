// class Solution {

//   private int solve(int p, int s, int T) {
//     if (p == T) return 0;
//     if (p < 0 || p > 2 * T) return Integer.MAX_VALUE;

//     int A = solve(p + s, s * 2, T);
//     int R = solve(p, s > 0 ? -1 : 1, T);

//     return Math.min(A, R) + 1;
//   }

//   public int racecar(int target) {
//     int p, s;
//     return solve(p = 0, s = 1, target);
//   }
// }

// public class _818_Race_Car {

//   public static void main(String[] args) {
//     System.out.println(new Solution().racecar(6));
//   }
// }

import java.util.*;

class Solution {

  public int racecar(int target) {
    Queue<int[]> queue = new LinkedList<>();
    Set<String> seen = new HashSet<>();
    queue.offer(new int[] { 0, 1 });
    seen.add("0,1");

    int steps = 0;
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        int[] cur = queue.poll();
        int p = cur[0],
          s = cur[1];

        if (p == target) return steps;

        int np = p + s,
          ns = s * 2;
        String keyA = np + "," + ns;
        if (!seen.contains(keyA) && np >= 0 && np <= 2 * target) {
          queue.offer(new int[] { np, ns });
          seen.add(keyA);
        }

        ns = s > 0 ? -1 : 1;
        String keyR = p + "," + ns;
        if (!seen.contains(keyR)) {
          queue.offer(new int[] { p, ns });
          seen.add(keyR);
        }
      }
      steps++;
    }
    return -1;
  }
}

public class _818_Race_Car {

  public static void main(String[] args) {
    System.out.println(new Solution().racecar(6));
  }
}
