// import java.util.*;

// class Solution {

//   private int bulb1(int n, int t) {
//     int i = 0, temp = 0, off = 0;
//     while (i < n) {
//       int bit = ((1 << i) & t) == 0 ? 0 : 1;
//       temp |= ((bit == 0 ? 1 : 0) << off++);
//       i++;
//     }
//     return temp;
//   }

//   private int bulb2(int n, int t) {
//     int i = 0, temp = 0, off = 0;
//     while (i < n) {
//       int bit = ((1 << i) & t) == 0 ? 0 : 1;
//       temp |= (i % 2 == 0) ? ((bit == 0 ? 1 : 0) << off++) : (bit << off++);
//       i++;
//     }
//     return temp;
//   }

//   private int bulb3(int n, int t) {
//     int i = 0, temp = 0, off = 0;
//     while (i < n) {
//       int bit = ((1 << i) & t) == 0 ? 0 : 1;
//       temp |= (i % 2 != 0) ? ((bit == 0 ? 1 : 0) << off++) : (bit << off++);
//       i++;
//     }
//     return temp;
//   }

//   private int bulb4(int n, int t) {
//     int temp = 0;

//     for (int pos = 1; pos <= n; pos++) {
//       int bitIndex = n - pos;
//       int bit = ((t >> bitIndex) & 1);
//       if (pos % 3 == 1) bit ^= 1;
//       temp |= (bit << bitIndex);
//     }

//     return temp;
//   }

//   private Set<Integer> visited;

//   private void dfs(
//     int n,
//     int curr,
//     int presses,
//     Set<Integer> finalStates,
//     Set<Integer> visited
//   ) {
//     if (presses == 0) {
//       finalStates.add(curr);
//       return;
//     }

//     for (int next : new int[] {
//       bulb1(n, curr),
//       bulb2(n, curr),
//       bulb3(n, curr),
//       bulb4(n, curr),
//     }) {
//       if (visited.add(next)) {
//         dfs(n, next, presses - 1, finalStates, visited);
//         visited.remove(next);
//       }
//     }
//   }

//   public int flipLights(int n, int presses) {
//     if (presses == 0) return 1;

//     int start = (1 << n) - 1;
//     Set<Integer> finalStates = new HashSet<>();
//     dfs(n, start, presses, finalStates, new HashSet<>());
//     return finalStates.size();
//   }
// }

class Solution {

  public int flipLights(int n, int presses) {
    if (presses == 0) return 1;
    if (n == 1) return 2;
    if (n == 2) return presses == 1 ? 3 : 4;
    if (presses == 1) return 4;
    if (presses == 2) return 7;
    return 8;
  }
}

public class _672_Bulb_Switcher_II {

  public static void main(String[] args) {
    System.out.println(new Solution().flipLights(2, 2));
  }
}
