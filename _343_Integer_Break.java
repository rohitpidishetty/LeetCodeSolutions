// import java.util.ArrayList;
// import java.util.List;

// class Solution {

//   private int maxSoFar = Integer.MIN_VALUE;

//   private void solve(int number, List<Integer> buffer, int product) {
//     if (number < 0) return;

//     if (number == 0 && buffer.size() >= 2) {
//       maxSoFar = Math.max(maxSoFar, product);
//       return;
//     }
//     for (int i = 1; i <= number; i++) {

//       buffer.add(i);
//       solve(number - i, buffer, product * i);
//       buffer.remove(buffer.size() - 1);
//     }
//   }

//   public int integerBreak(int n) {
//     int product = 1;
//     solve(n, new ArrayList<>(), product);
//     return maxSoFar;
//   }
// }

// public class _343_Integer_Break {

//   public static void main(String[] args) {
//     System.out.println(new Solution().integerBreak(10));
//   }
// }

class Solution {

  public int integerBreak(int n) {
    if (n == 2) return 1;
    if (n == 3) return 2;
    int product = 1;
    while (n > 4) {
      product *= 3;
      n -= 3;
    }
    System.out.println(n + " " + product);
    return product * n;
  }
}

public class _343_Integer_Break {

  public static void main(String[] args) {
    System.out.println(new Solution().integerBreak(14));
  }
}
