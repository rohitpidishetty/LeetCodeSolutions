import java.util.Arrays;

class Solution {

  public int minMoves2(int[] nums) {
    Arrays.sort(nums);
    int n = nums.length;
    int median = n % 2 != 0
      ? nums[n / 2]
      : (nums[n / 2] + nums[(n / 2) - 1]) / 2;
    int minMoves = 0;
    for (int x : nums) minMoves += (Math.abs(x - median));

    return minMoves;
  }
}

public class _462_Minimum_Moves_to_Equal_Array_Elements_II {

  public static void main(String[] args) {
    System.out.println(new Solution().minMoves2(new int[] { 1, 2, 3 }));
  }
}
