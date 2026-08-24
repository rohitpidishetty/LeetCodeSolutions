import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {

  public List<List<Integer>> fourSum(int[] nums, int target) {
    Arrays.sort(nums);
    int n = nums.length;
    Set<List<Integer>> res = new HashSet<>();
    for (int i = 0; i < n - 3; i++) {
      if (i > 0 && nums[i - 1] == nums[i]) continue;
      long A = (long) nums[i];
      for (int j = i + 1; j < n - 2; j++) {
        long B = (long) nums[j];
        int X = j + 1;
        int Y = n - 1;
        while (X < Y) {
          long sum = A + B + nums[X] + nums[Y];
          if (sum == target) {
            res.add(
              new ArrayList<>(List.of((int) A, (int) B, nums[X++], nums[Y--]))
            );
          } else if (sum > target) Y--;
          else if (sum < target) X++;
        }
      }
    }
    return new ArrayList<>(res);
  }
}

public class _18_4Sum {

  public static void main(String[] args) {
    System.out.println(
      new Solution().fourSum(new int[] { 1, 0, -1, 0, -2, 2 }, 0)
    );
    System.out.println(new Solution().fourSum(new int[] { 2, 2, 2, 2, 2 }, 8));
  }
}
