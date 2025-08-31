import java.util.Arrays;
import java.util.LinkedHashSet;

class Solution {

  public int nthSuperUglyNumber(int n, int[] primes) {
    int[] pointers = new int[primes.length];
    long[] dp = new long[n];
    dp[0] = 1;
    int dp_idx = 1;
    int index = 0;
    Arrays.fill(pointers, index);
    while (dp_idx < n) {
      int minIdx = 0;
      long max = Long.MAX_VALUE;
      for (int i = 0; i < primes.length; i++) {
        if (primes[i] * dp[pointers[i]] < max) {
          max = (long) primes[i] * dp[pointers[i]];
          minIdx = i;
        }
      }
      pointers[minIdx]++;
      if (dp_idx > 0 && max == dp[dp_idx - 1]) continue;
      dp[dp_idx] = max;
      dp_idx++;
    }
    return (int) dp[n - 1];
  }
}

public class _313_Super_Ugly_Number {

  public static void main(String[] args) {
    System.out.println(
      new Solution().nthSuperUglyNumber(5911, new int[] { 2, 3, 5, 7 })
    );
  }
}
