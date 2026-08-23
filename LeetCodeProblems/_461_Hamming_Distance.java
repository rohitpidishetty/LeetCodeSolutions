class Solution {

  public int hammingDistance(int x, int y) {
    int msb_range = 31;
    int i = 0;
    int count = 0;
    while (i < msb_range) {
      int x_bit = (((1 << i) & x) == 0) ? 0 : 1;
      int y_bit = (((1 << i) & y) == 0) ? 0 : 1;
      if (x_bit != y_bit) count++;
      i++;
    }
    return count;
  }
}

public class _461_Hamming_Distance {

  public static void main(String[] args) {
    System.out.println(new Solution().hammingDistance(1, 4));
  }
}
