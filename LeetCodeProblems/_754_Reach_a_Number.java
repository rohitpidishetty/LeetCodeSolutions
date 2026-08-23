import java.util.ArrayDeque;
import java.util.Queue;

// class Solution {

//   public int reachNumber(int target) {
//     Queue<Integer> bfsQ = new ArrayDeque<>();
//     bfsQ.offer(0);
//     int j = 0;
//     while (!bfsQ.isEmpty()) {
//       int len = bfsQ.size();
//       for (int i = 0; i < len; i++) {
//         int p = bfsQ.poll();
//         if (p == target) return j;
//         bfsQ.offer(p - (j + 1));
//         bfsQ.offer(p + (j + 1));
//       }
//       j++;
//     }
//     return -1;
//   }
// }

class Solution {

  public int reachNumber(int target) {
    target = Math.abs(target);

    int sum = 0;
    int i_th = 0;

    while (sum < target) {
      i_th++;
      sum += i_th;
    }

    while ((sum - target) % 2 != 0) {
      i_th++;
      sum += i_th;
    }

    return i_th;
  }
}

public class _754_Reach_a_Number {

  public static void main(String[] args) {
    System.out.println(new Solution().reachNumber(2));
  }
}
