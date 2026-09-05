import java.util.Arrays;

class Solution {

  public int threeSumClosest(int[] nums, int target) {
    Arrays.sort(nums);
    int n = nums.length;
    int maxDiff = Integer.MAX_VALUE;
    int res = 0;
    for (int i = 0; i < n - 2; i++) {
      int l = i + 1;
      int h = n - 1;
      while (l < h) {
        int sum = nums[i] + nums[l] + nums[h];
        int diff = Math.abs(target - sum);
        if (target - sum > 0) l++;
        else if (target - sum < 0) h--;
        else return sum;

        if (diff < maxDiff) {
          maxDiff = diff;
          res = sum;
        }
      }
    }
    return res;
  }
}

public class _16_3Sum_Closest {

  public static void main(String[] args) {
    System.out.println(
      new Solution().threeSumClosest(new int[] { -1, 2, 1, -4 }, 1)
    );
  }
}
