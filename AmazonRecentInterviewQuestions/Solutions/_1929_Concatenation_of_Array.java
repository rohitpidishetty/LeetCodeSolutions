import java.util.Arrays;

class Solution {

  public int[] getConcatenation(int[] nums) {
    int n = nums.length;
    int[] buff = new int[n * 2];
    for (int i = 0; i < buff.length; i++) buff[i] = nums[i % n];

    return buff;
  }
}

public class _1929_Concatenation_of_Array {

  public static void main(String[] args) {
    System.out.println(
      Arrays.toString(new Solution().getConcatenation(new int[] { 1, 3, 2, 1 }))
    );
  }
}
