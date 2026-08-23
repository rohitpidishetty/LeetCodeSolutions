import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
  class inn {
    public String addBinary(String a, String b) {
      char[] signalOne = a.toCharArray();
      char[] signalTwo = b.toCharArray();
      List<Character> out = new ArrayList<>();
      int s1m = signalOne.length - 1;
      int s2m = signalTwo.length - 1;
      int padding = Math.max(s1m + 1, s2m + 1);
      char[] s1bc = new char[padding];
      char[] s2bc = new char[padding];
      int s1lp = s1m;
      int s2lp = s2m;
      for (int pos = padding - 1; pos >= 0; pos--) {
        if (s1lp > -1)
          s1bc[pos] = signalOne[s1lp--];
        else if (s1lp <= -1)
          s1bc[pos] = '0';

      }
      for (int pos = padding - 1; pos >= 0; pos--) {
        if (s2lp > -1)
          s2bc[pos] = signalTwo[s2lp--];
        else if (s2lp <= -1)
          s2bc[pos] = '0';
      }
      signalOne = s1bc;
      signalTwo = s2bc;

      int carryForwardBit = 0;
      int s1 = 0;
      int s2 = 0;
      int idx = padding - 1;
      while (idx > -1) {
        s1 = signalOne[idx] - '0';
        s2 = signalTwo[idx] - '0';
        int op = (s1 + s2) + carryForwardBit;
        carryForwardBit = 0;
        if (op == 2) {
          out.add('0');
          carryForwardBit = 1;
        } else if (op == 3) {
          out.add('1');
          carryForwardBit = 1;
        } else
          out.add(op == 1 ? '1' : '0');
        idx--;

      }
      if (carryForwardBit == 1)
        out.add('1');
      List<Character> o = out.reversed();

      StringBuilder ret = new StringBuilder();
      while (!o.isEmpty()) {
        ret.append(o.getFirst());
        o.removeFirst();
      }
      return ret.toString();
    }
  }

  public int[] plusOne(int[] digits) {
    int pos = digits.length - 1;
    int res = 0;
    int carry = 0;
    int plus = 1;
    while (pos > -1) {

      res = (digits[pos] + plus + carry);
      carry = 0;
      if (res < 10) {
        digits[pos] = res;
        break;
      } else {
        carry = 1;
        digits[pos] = 0;
      }
      plus = 0;
      pos--;
    }

    if (carry == 1) {
      int[] buffer = new int[digits.length + 1];
      buffer[0] = 1;
      int idx = 1;
      for (int n : digits)
        buffer[idx++] = n;
      digits = buffer;
    }
    return digits;
  }
}

public class PlusOne {
  public static void main(String[] args) {
    System.out.println(Arrays.toString(new Solution().plusOne(new int[] { 9 })));
    System.out.println(new Solution().new inn().addBinary("1111", "1111"));
    // System.out.println(new Solution().new inn().addBinary("11", "1"));
  }
}
