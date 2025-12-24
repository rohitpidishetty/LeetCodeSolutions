import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {

  // Memory Limit Exceeded (24 / 127)
  // public boolean judgeSquareSum(int c) {
  //   if (c == 1 || c == 0) return true;
  //   long[] buffer = new long[(int) Math.ceil(c / 2) + 1];
  //   int number = 0;
  //   for (int i = 0; i < buffer.length; i++) buffer[i] = ((long) number *
  //     (long) number++);
  //   int i = 0, j = buffer.length - 1;
  //   while (i <= j) {
  //     if (buffer[i] + buffer[j] == c) return true;
  //     else if (buffer[i] + buffer[j] > c) j--;
  //     else i++;
  //   }
  //   return false;
  // }

  // Time Limit Exceeded 98 / 127
  // public boolean judgeSquareSum(int c) {
  //   if (c < 3) return true;
  //   int number = 0;
  //   Set<Integer> bucket = new HashSet<>();
  //   bucket.add(0);
  //   while (number * number <= c) {
  //     int num = number * number;

  //     if (bucket.contains(c - num) || num == c || num * 2 == c) return true;
  //     bucket.add(num);
  //     number++;
  //   }
  //   return false;
  // }

  public boolean judgeSquareSum(int c) {
    long left = 0, right = (int) Math.sqrt(c);
    while (left <= right) {
      long sum = (left * left) + (right * right);
      if (sum == c) return true;
      else if (sum > c) right--;
      else left++;
    }
    return false;
  }
}

public class _633_Sum_of_Square_Numbers {

  public static void main(String[] args) {
    System.out.println(new Solution().judgeSquareSum(8));
  }
}
