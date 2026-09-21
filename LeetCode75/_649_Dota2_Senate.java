import java.util.ArrayDeque;
import java.util.Queue;

class Solution {

  public String predictPartyVictory(String senate) {
    Queue<Integer> R = new ArrayDeque<>();
    Queue<Integer> D = new ArrayDeque<>();
    int n = senate.length();
    for (int i = 0; i < n; i++) {
      if (senate.charAt(i) == 'R') R.offer(i);
      else D.offer(i);
    }

    while (!R.isEmpty() && !D.isEmpty()) {
      int r = R.poll();
      int d = D.poll();

      if (r < d) R.offer(r + n);
      else D.offer(d + n);
    }

    return R.isEmpty() ? "Dire" : "Radiant";
  }
}

public class _649_Dota2_Senate {

  public static void main(String[] args) {
    System.out.println(new Solution().predictPartyVictory("RDD"));
  }
}
