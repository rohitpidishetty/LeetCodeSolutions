// import java.util.ArrayList;
// import java.util.HashSet;
// import java.util.Set;

// class Solution {

//   private boolean[][] memo;

//   public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
//     boolean status = false;
//     int sum = (maxChoosableInteger * (maxChoosableInteger + 1)) / 2;
//     if (sum < desiredTotal) return false;
//     if (desiredTotal <= 0) return true;
//     memo = new boolean[2][desiredTotal + 1];
//     return solve(true, maxChoosableInteger, new HashSet<>(), desiredTotal);
//   }

//   private boolean solve(
//     boolean player,
//     int mci,
//     Set<Integer> usedNums,
//     int dt
//   ) {
//     int x = player ? 1 : 0;
//     if (memo[x][dt]) return memo[x][dt];
//     for (int i = 1; i <= mci; i++) {
//       int choice = i;
//       if (!usedNums.contains(choice)) {
//         if (dt <= choice) return true;
//         usedNums.add(choice);
//         boolean result = solve(!player, mci, usedNums, dt - choice);
//         if (result == false) {
//           usedNums.remove(choice);
//           memo[x][dt] = true;
//           return true;
//         }

//         usedNums.remove(choice);
//       }
//     }
//     memo[x][dt] = false;
//     return false;
//   }
// }

// public class _464_Can_I_Win {

//   public static void main(String[] args) {
//     System.out.println(new Solution().canIWin(10, 11));
//   }
// }

import java.util.HashMap;
import java.util.Map;

class Solution {

  Map<Integer, Boolean> memo;

  public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
    int sum = (maxChoosableInteger * (maxChoosableInteger + 1)) / 2;
    if (sum < desiredTotal) return false;
    if (desiredTotal <= 0) return true;

    memo = new HashMap<>();
    return canWin(maxChoosableInteger, 0, desiredTotal);
  }

  private boolean canWin(int mci, int usedMask, int remaining) {
    if (memo.containsKey(usedMask)) return memo.get(usedMask);

    for (int i = 1; i <= mci; i++) {
      int bit = 1 << (i - 1);
      if ((usedMask & bit) != 0) continue;

      if (i >= remaining || !canWin(mci, usedMask | bit, remaining - i)) {
        memo.put(usedMask, true);
        return true;
      }
    }

    memo.put(usedMask, false);
    return false;
  }
}

public class _464_Can_I_Win {

  public static void main(String[] args) {
    System.out.println(new Solution().canIWin(10, 11));
  }
}
