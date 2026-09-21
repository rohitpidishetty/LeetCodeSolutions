class Solution {

  public int longestSubarray(int[] nums) {
    // Exempt one 0 and count the distance of window.
    int i = 0;
    int n = nums.length;
    int zeros = 0;
    int max = 0;
    int j = 0;
    for (; i < n; i++) {
      if (nums[i] == 0) zeros++;
      while (j < i && zeros > 1) {
        if (nums[j] == 0) zeros--;
        j++;
      }
      max = Math.max(max, i - j);
    }
    return max;
  }
}

public class _1493_Longest_Subarray_1_s_After_Deleting_One_Element {

  public static void main(String[] args) {
    System.out.println(
      new Solution().longestSubarray(new int[] { 0, 1, 1, 1, 0, 1, 1, 0, 1 })
    );
  }
}
