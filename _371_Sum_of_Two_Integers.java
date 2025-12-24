class Solution {

  public int getSum(int a, int b) {
    int cf = 0;
    int result = 0;
    int intr_result = 0;
    if (a >= 0 && b >= 0) {
      int limit = 30;
      for (int i = 0; i < limit; i++) {
        int setbit = 1;
        setbit <<= i;
        int signalOne = (a & setbit) == 0 ? 0 : 1;
        int signalTwo = (b & setbit) == 0 ? 0 : 1;
        if (signalOne == 1 && signalTwo == 1) {
          int bit = 0 ^ cf;
          bit <<= i;
          result |= bit;
          cf = 1;
        } else {
          int bit = signalOne ^ signalTwo ^ cf;
          bit <<= i;
          result |= bit;
          if (cf == 0) cf = 0;
          else cf = (signalOne == 0 && signalTwo == 0) ? 0 : 1;
        }
      }
    } else if (a >= 0 && b < 0) {
      b = Math.abs(b);
      // 2's compliment of 'b'
      int comp1 = ~b;
      int limit = 32;
      int signalTwo = 1;
      for (int i = 0; i < limit; i++) {
        int setbit = 1;
        setbit <<= i;
        int signalOne = (comp1 & setbit) == 0 ? 0 : 1;
        int bit = signalOne ^ signalTwo ^ cf;
        bit <<= i;
        intr_result |= bit;
        cf = (signalOne & signalTwo) | (signalOne & cf) | (signalTwo & cf);
        signalTwo = 0;
      }
      limit = 32;
      for (int i = 0; i < limit; i++) {
        int setbit = 1;
        setbit <<= i;
        int signalOne = (a & setbit) == 0 ? 0 : 1;
        signalTwo = (intr_result & setbit) == 0 ? 0 : 1;
        if (signalOne == 1 && signalTwo == 1) {
          int bit = 0 ^ cf;
          bit <<= i;
          result |= bit;
          cf = 1;
        } else {
          int bit = signalOne ^ signalTwo ^ cf;
          bit <<= i;
          result |= bit;
          if (cf == 0) cf = 0;
          else cf = (signalOne == 0 && signalTwo == 0) ? 0 : 1;
        }
      }
    } else if (a < 0 && b >= 0) {
      a = Math.abs(a);
      // 2's compliment of 'b'
      int comp1 = ~a;
      int limit = 32;
      int signalTwo = 1;
      for (int i = 0; i < limit; i++) {
        int setbit = 1;
        setbit <<= i;
        int signalOne = (comp1 & setbit) == 0 ? 0 : 1;
        int bit = signalOne ^ signalTwo ^ cf;
        bit <<= i;
        intr_result |= bit;
        cf = (signalOne & signalTwo) | (signalOne & cf) | (signalTwo & cf);
        signalTwo = 0;
      }
      limit = 32;
      for (int i = 0; i < limit; i++) {
        int setbit = 1;
        setbit <<= i;
        int signalOne = (intr_result & setbit) == 0 ? 0 : 1;
        signalTwo = (b & setbit) == 0 ? 0 : 1;
        if (signalOne == 1 && signalTwo == 1) {
          int bit = 0 ^ cf;
          bit <<= i;
          result |= bit;
          cf = 1;
        } else {
          int bit = signalOne ^ signalTwo ^ cf;
          bit <<= i;
          result |= bit;
          if (cf == 0) cf = 0;
          else cf = (signalOne == 0 && signalTwo == 0) ? 0 : 1;
        }
      }
    } else {
      int intr_result2 = 0;
      a = Math.abs(a);
      // 2's compliment of 'b'
      int comp1 = ~a;
      int limit = 32;
      int signalTwo = 1;
      for (int i = 0; i < limit; i++) {
        int setbit = 1;
        setbit <<= i;
        int signalOne = (comp1 & setbit) == 0 ? 0 : 1;
        int bit = signalOne ^ signalTwo ^ cf;
        bit <<= i;
        intr_result |= bit;
        cf = (signalOne & signalTwo) | (signalOne & cf) | (signalTwo & cf);
        signalTwo = 0;
      }

      b = Math.abs(b);
      // 2's compliment of 'b'
      int comp2 = ~b;

      signalTwo = 1;
      for (int i = 0; i < limit; i++) {
        int setbit = 1;
        setbit <<= i;
        int signalOne = (comp2 & setbit) == 0 ? 0 : 1;
        int bit = signalOne ^ signalTwo ^ cf;
        bit <<= i;
        intr_result2 |= bit;
        cf = (signalOne & signalTwo) | (signalOne & cf) | (signalTwo & cf);
        signalTwo = 0;
      }
      limit = 32;
      for (int i = 0; i < limit; i++) {
        int setbit = 1;
        setbit <<= i;
        int signalOne = (intr_result & setbit) == 0 ? 0 : 1;
        signalTwo = (intr_result2 & setbit) == 0 ? 0 : 1;
        if (signalOne == 1 && signalTwo == 1) {
          int bit = 0 ^ cf;
          bit <<= i;
          result |= bit;
          cf = 1;
        } else {
          int bit = signalOne ^ signalTwo ^ cf;
          bit <<= i;
          result |= bit;
          if (cf == 0) cf = 0;
          else cf = (signalOne == 0 && signalTwo == 0) ? 0 : 1;
        }
      }
    }

    return result;
  }
}

public class _371_Sum_of_Two_Integers {

  public static void main(String[] args) {
    System.out.println(new Solution().getSum(-5, -10));
  }
}
