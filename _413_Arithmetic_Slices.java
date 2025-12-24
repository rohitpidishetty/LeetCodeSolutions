class Solution {

  public int numberOfArithmeticSlices(int[] nums) {
    int csac = 0;
    int[] x = nums;
    int total = 0;
    for (int i = 1; i < nums.length - 1; i++) {
      if (x[i] - x[i - 1] == x[i + 1] - x[i]) {
        csac = 1 + csac;
        total += csac;
      } else csac = 0;
    }
    return total;
  }
}

public class _413_Arithmetic_Slices {

  public static void main(String[] args) {
    System.out.println(
      new Solution().numberOfArithmeticSlices(new int[] { 1, 2, 3, 4 })
    );
  }
}
