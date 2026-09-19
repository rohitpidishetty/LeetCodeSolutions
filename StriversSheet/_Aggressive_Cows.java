import java.util.Arrays;

class Solution {

  private boolean isPossible(int m, int[] nums, int k) {
    int cows = 1;
    int pos = nums[0];

    for (int i = 1; i < nums.length; i++) {
      if (nums[i] - pos >= m) {
        cows++;
        pos = nums[i];
      }
    }

    return cows >= k;
  }

  public int aggressiveCows(int[] nums, int k) {
    int l = 1;
    int h = 0;
    for (int num : nums) h = Math.max(h, num);
    Arrays.sort(nums);
    h = nums[nums.length - 1] - nums[0];
    while (l <= h) {
      int m = (l + (h - l) / 2);
      if (isPossible(m, nums, k)) l = m + 1;
      else h = m - 1;
    }
    return h;
  }
}

public class _Aggressive_Cows {

  public static void main(String[] args) {
    System.out.println(
      new Solution().aggressiveCows(new int[] { 0, 3, 4, 7, 10, 9 }, 4)
    );
  }
}
