import java.util.HashMap;
import java.util.Map;

class Solution {
  private Map<Integer, Integer> memo;

  public Solution() {
    this.memo = new HashMap<>();
  }

  public int fib(int n) {
    if (memo.containsKey(n))
      return memo.get(n);
    if (n == 0)
      return 0;
    if (n == 1 || n == 2)
      return 1;
    int x = fib(n - 1) + fib(n - 2);
    memo.put(n, x);
    return x;
  }
}

public class _509_Fibonacci_Number {
  public static void main(String[] args) {
    System.out.println(new Solution().fib(6));
  }
}
