import java.util.Arrays;

class Solution {
  public int singleNumber(int[] nums) {
    int k = 0;
    int ret = 0;
    for (k = 0; k < 32; k++) {
      int res = 0;
      int zeros = 0;
      int ones = 0;
      for (int n : nums) {
        if (((1 << k) & n) == 0)
          zeros++;
        else
          ones++;
      }
      res = ((zeros % 3) == 0 ? 1 : 0);
      if (res == 1)
        ret |= (1 << k);
    }
    return ret;
  }
}

public class _137_Single_Number_II {
  public static void main(String[] args) {
    System.out.println(new Solution().singleNumber(new int[] { 2, 2, 3, 2, 4, 4, 4 }));
  }
}
