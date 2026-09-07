class Solution {

  public int longestOnes(int[] nums, int k) {
    int i = 0;
    int j = 0;
    int n = nums.length;
    int max = 0;
    for (; j < n; j++) {
      if (nums[j] == 0) k--;
      if (k >= 0) max = Math.max(max, j - i + 1);

      while (k < 0) {
        if (nums[i] == 0) k++;
        i++;
      }
    }
    return max;
  }
}

public class _1004_Max_Consecutive_Ones_III {

  public static void main(String[] args) {
    System.out.println(new Solution().longestOnes(new int[] { 0, 0, 0, 1 }, 4));
  }
}
