// class Solution {

//   // 419 / 527 testcases passed
//   private int solve(int depth, int previous) {
//     if (depth == 0) return 1;
//     int ans = solve(depth - 1, 0);
//     if (previous == 0) ans += solve(depth - 1, 1);
//     return ans;
//   }

//   public int findIntegers(int n) {
//     int max_depth = 31;
//     while ((n & (1 << max_depth)) == 0) max_depth--;
//     return solve(max_depth + 1, 0);
//   }
// }

class Solution {

  public int findIntegers(int n) {
    int result = 0, prevBit = 0;
    int[] fib = new int[32];
    fib[0] = 1;
    fib[1] = 2;
    for (int i = 2; i < 32; i++) fib[i] = fib[i - 1] + fib[i - 2];

    for (int i = 30; i >= 0; i--) {
      if ((n & (1 << i)) != 0) {
        result += fib[i];
        if (prevBit == 1) return result;
        prevBit = 1;
      } else prevBit = 0;
    }
    return result + 1;
  }
}

public class _600_Non_negative_Integers_without_Consecutive_Ones {

  public static void main(String[] args) {
    System.out.println(new Solution().findIntegers(4));
  }
}
