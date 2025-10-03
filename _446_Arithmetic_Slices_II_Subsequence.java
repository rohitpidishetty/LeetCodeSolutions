import java.util.HashMap;
import java.util.Map;

class Solution {

  public int numberOfArithmeticSlices(int[] nums) {
    int i = 0, j = 0, n = nums.length;
    @SuppressWarnings("unchecked")
    Map<Integer, Integer> differenceMap[] = new HashMap[n];

    for (int k = 0; k < n; k++) differenceMap[k] = new HashMap<>();

    int res = 0;
    while (i < n) {
      j = 0;
      while (j < i) {
        long diffLong = (long) nums[i] - (long) nums[j];
        if (diffLong > Integer.MIN_VALUE && diffLong < Integer.MAX_VALUE) {
          int diff = (int) diffLong;

          int curr_i_ptr_count = differenceMap[i].getOrDefault(diff, 0);
          int curr_j_ptr_count = differenceMap[j].getOrDefault(diff, 0);

          res += curr_j_ptr_count;
          differenceMap[i].put(diff, curr_i_ptr_count + curr_j_ptr_count + 1);
        }
        j++;
      }
      i++;
    }

    return res;
  }
}

public class _446_Arithmetic_Slices_II_Subsequence {

  public static void main(String[] args) {
    System.out.println(
      new Solution().numberOfArithmeticSlices(new int[] { 2, 2, 3, 4 })
    );
  }
}
