import java.util.Arrays;

class Solution {

  public boolean reorderedPowerOf2(int n) {
    int[] vector1 = new int[10];
    while (n > 0) {
      vector1[n % 10]++;
      n /= 10;
    }
    for (int i = 0; i < 31; i++) {
      int power = (int) Math.pow(2, i);
      int[] vector = new int[10];
      while (power > 0) {
        vector[power % 10]++;
        power /= 10;
      }
      if (Arrays.compare(vector, vector1) == 0) return true;
    }
    return false;
  }
}

public class _869_Reordered_Power_of_2 {

  public static void main(String[] args) {
    System.out.println(new Solution().reorderedPowerOf2(511));
  }
}
