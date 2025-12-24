import java.util.*;

class Solution {

  // public int maximumSwap(int num) {
  //   if (num < 10) return num;
  //   char[] buffer = String.valueOf(num).toCharArray();
  //   char t = buffer[0];
  //   int _0 = t + '0';
  //   int max_at = 0;
  //   int max = _0;
  //   for (int i = 1; i < buffer.length; i++) {
  //     int cur = buffer[i] + '0';
  //     if (cur > max) {
  //       max = cur;
  //       max_at = i;
  //     }
  //   }
  //   if (max_at != 0) {
  //     buffer[0] = buffer[max_at];
  //     buffer[max_at] = t;
  //     int _num_ = buffer[0] - '0';
  //     for (int i = 1; i < buffer.length; i++) {
  //       _num_ = (_num_ * 10) + ((int) buffer[i] - '0');
  //     }
  //     num = _num_;
  //   }
  //   return num;
  // }
  public int maximumSwap(int num) {
    if (num < 10) return num;
    char[] buffer = String.valueOf(num).toCharArray();
    int n = buffer.length;
    int last[] = new int[10];
    for (int i = 0; i < n; i++) last[buffer[i] - '0'] = i;
    for (int i = 0; i < n; i++) {
      int current_number = buffer[i] - '0';
      for (int j = 9; j > current_number; j--) {
        if (i < last[j]) {
          char temp = buffer[last[j]];
          buffer[last[j]] = buffer[i];
          buffer[i] = temp;
          int _num_ = buffer[0] - '0';
          for (int k = 1; k < n; k++) {
            _num_ = (_num_ * 10) + (buffer[k] - '0');
          }
          return _num_;
        }
      }
    }
    return num;
  }
}

public class _670_Maximum_Swap {

  public static void main(String[] args) {
    System.out.println(new Solution().maximumSwap(98368));
  }
}
