class Solution {

  public int fib(int n) {
    if (n == 0) return 0;
    if (n == 1) return 1;
    return fib(n - 1) + fib(n - 2);
  }
}

public class _509_Fibonacci_Number {

  public static void main(String[] args) {
    System.out.println(new Solution().fib(4));
  }
}
