// import java.util.*;

// class Solution {

//   public String predictPartyVictory(String senate) {
//     System.out.println(senate);
//     int rounds = senate.length();
//     Queue<Character> R = new ArrayDeque<>();
//     Queue<Character> D = new ArrayDeque<>();
//     for (int i = 0; i < rounds; i++) {
//       char ch = senate.charAt(i);
//       if (ch == 'R') R.offer(ch);
//       else D.offer(ch);
//     }
//     for (char s : senate.toCharArray()) {
//       if (s == 'R') {
//         if (D.isEmpty()) return "Radiant";
//         D.poll();
//         if (D.isEmpty()) return "Radiant";
//       } else {
//         if (R.isEmpty()) return "Dire";
//         R.poll();
//         if (R.isEmpty()) return "Dire";
//       }
//     }
//     return null;
//   }
// }

// public class _649_Dota2_Senate {

//   public static void main(String[] args) {
//     System.out.println(new Solution().predictPartyVictory("RD"));
//   }
// }
import java.util.*;

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

      if (r < d) R.offer(r + n); // R bans D
      else D.offer(d + n); // D bans R
    }

    return R.isEmpty() ? "Dire" : "Radiant";
  }
}

public class _649_Dota2_Senate {

  public static void main(String[] args) {
    System.out.println(new Solution().predictPartyVictory("DDRRR"));
  }
}
