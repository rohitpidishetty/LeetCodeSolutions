import java.util.Arrays;

class Solution {

  public int[] singleNumber(int[] nums) {
    long xor = 0;
    for (int num : nums) xor ^= num;
    long mask = (xor) & (-xor);
    long unq1 = 0;
    long unq2 = 0;
    for (int num : nums) {
      long res = num & mask;
      if (res == 0) unq1 ^= num;
      else unq2 ^= num;
    }
    return new int[] { (int) unq1, (int) unq2 };
  }
}

public class _260_Single_Number_III {

  public static void main(String[] args) {
    System.out.println(
      Arrays.toString(
        new Solution().singleNumber(new int[] { 1, 2, 1, 3, 2, 5 })
      )
    );
  }
}
