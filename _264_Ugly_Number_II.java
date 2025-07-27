import java.util.Arrays;
import java.util.Collections;

class Solution {

  public int nthUglyNumber(int n) {
    int i2 = 1;
    int i3 = 1;
    int i5 = 1;
    int ret[] = new int[n + 1];
    ret[1] = 1;
    for (int i = 2; i <= n; i++) {
      int i2min = 2 * ret[i2];
      int i3min = 3 * ret[i3];
      int i5min = 5 * ret[i5];
      int min = Math.min(Math.min(i2min, i3min), i5min);
      ret[i] = min;
      if (min == i2min) i2++;
      if (min == i3min) i3++;
      if (min == i5min) i5++;
    }
    return ret[n];
  }
}

public class _264_Ugly_Number_II {

  public static void main(String[] args) {
    System.out.println(new Solution().nthUglyNumber(10));
  }
}
