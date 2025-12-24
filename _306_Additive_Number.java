// import java.math.BigInteger;
// import java.util.ArrayList;
// import java.util.List;

// class Solution {

//   private boolean solve(String num, List<BigInteger> buffer, int idx) {
//     int x = buffer.size();
//     if (
//       x > 2 &&
//       !buffer.get(x - 1).equals(buffer.get(x - 2).add(buffer.get(x - 3)))
//     ) return false;

//     if (num.isEmpty()) return buffer.size() >= 3;

//     int n = num.length();
//     int i = 0;
//     boolean ans = false;
//     for (; i < n; i++) {
//       String consider = num.substring(0, i + 1);
//       if (consider.length() > 1 && consider.charAt(0) == '0') break;
//       String nextConsideration = num.substring(i + 1, n);
//       BigInteger number = new BigInteger(consider);
//       buffer.add(number);
//       if (solve(nextConsideration, buffer, idx)) return true;
//       buffer.remove(buffer.size() - 1);
//     }
//     return ans;
//   }

//   public boolean isAdditiveNumber(String num) {
//     return solve(num, new ArrayList<BigInteger>(), 0);
//   }
// }

// public class _306_Additive_Number {

//   public static void main(String[] args) {
//     System.out.println(new Solution().isAdditiveNumber("112358"));
//   }
// }

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

class Solution {

  private boolean solve(String num, List<BigInteger> buffer, int idx) {
    int x = buffer.size();
    if (
      x > 2 &&
      !buffer.get(x - 1).equals(buffer.get(x - 2).add(buffer.get(x - 3)))
    ) return false;

    if (num.isEmpty()) return buffer.size() >= 3;

    int n = num.length();
    int i = 0;
    boolean ans = false;
    for (; i < n; i++) {
      String consider = num.substring(0, i + 1);
      if (consider.length() > 1 && consider.charAt(0) == '0') break;
      String nextConsideration = num.substring(i + 1, n);
      BigInteger number = new BigInteger(consider);
      buffer.add(number);
      if (solve(nextConsideration, buffer, idx)) return true;
      buffer.remove(buffer.size() - 1);
    }
    return ans;
  }

  public boolean isAdditiveNumber(String num) {
    return solve(num, new ArrayList<BigInteger>(), 0);
  }
}

public class _306_Additive_Number {

  public static void main(String[] args) {
    System.out.println(new Solution().isAdditiveNumber("112358"));
  }
}
