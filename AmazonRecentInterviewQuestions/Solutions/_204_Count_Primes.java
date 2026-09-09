import java.util.Arrays;

class Solution {

  public int countPrimes(int n) {
    if (n <= 2) return 0;
    boolean primes[] = new boolean[n];
    for (int i = 2; i * i < n; i++) {
      if (!primes[i]) for (int j = (i * i); j < n; j += i) primes[j] = true;
    }
    int count = 0;
    for (int i = 2; i < n; i++) if (!primes[i]) count++;
    return count;
  }
}

public class _204_Count_Primes {

  public static void main(String[] args) {
    System.out.println(new Solution().countPrimes(2));
  }
}
