import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
  // public int largestPalindrome(int n) {
  // if (n == 1)
  // return 9;
  // long number = 0, limit = 0, i = 0;
  // while (i < n) {
  // number *= 10;
  // number += 9;
  // i++;
  // }
  // i = 0;
  // while (i < n - 1) {
  // limit *= 10;
  // limit += 9;
  // i++;
  // }
  // limit++;
  // long num1 = number, num2 = number;
  // long max = Long.MIN_VALUE;
  // while (num2 >= limit) {
  // num1 = number;
  // while (num1 >= limit) {
  // long num = num2 * num1;
  // long number_reversed = 0;
  // long temp = num;
  // while (temp != 0) {
  // number_reversed *= 10;
  // number_reversed += (temp % 10);
  // temp /= 10;
  // }

  // if (num == number_reversed)
  // max = Math.max(max, num);

  // num1--;
  // }
  // num2--;
  // }
  // return (int) (max % (long) 1337);
  // }

  public int largestPalindrome(int n) {
    if (n == 1)
      return 9;
    long number = 0, limit = 0, i = 0, __num__ = 0;
    while (i < n) {
      number *= 10;
      number += 9;
      i++;
    }
    __num__ = number;
    number *= number;
    String maximum = Long.toString(number);
    int m = maximum.length() / 2;
    maximum = maximum.substring(0, m);
    long num = Long.parseLong(maximum);
    i = 0;
    while (i < n - 1) {
      limit *= 10;
      limit += 9;
      i++;
    }
    limit++;
    while (num >= limit) {
      long _n_ = Long.parseLong(num + "" + new StringBuilder(Long.toString(num)).reverse().toString());
      long deno = __num__;
      boolean flag = false;
      while (deno >= limit) {
        if (_n_ / deno > __num__)
          break;
        if (_n_ % deno == 0) {
          long quotient = _n_ / deno;
          if (quotient >= limit && quotient <= __num__) {
            return (int) (_n_ % 1337);
          }
        }
        deno--;
      }

      num--;
    }

    return 0;
  }

}

public class _479_Largest_Palindrome_Product {
  public static void main(String[] args) {
    System.out.println(new Solution().largestPalindrome(3));
  }
}
