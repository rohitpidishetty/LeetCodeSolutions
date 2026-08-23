class Solution {

  public int hammingWeight(int n) {
    int count = 0;
    int i = 0;
    while (i < 32) {
      if (((1 << i) & n) > 0) count++;
      i++;
    }
    return count;
  }
}

public class _191_Number_of_1_bits {

  public static void main(String[] args) {
    System.out.println(new Solution().hammingWeight(13));
  }
}
