class Solution {
  public String optimalDivision(int[] nums) {
    // 1000 / (100 / 10 / 2)
    int n = nums.length;
    if (n == 0)
      return null;
    if (n == 1)
      return String.valueOf(nums[0]);
    if (n == 2)
      return nums[0] + "/" + nums[1];
    StringBuilder sb = new StringBuilder();
    sb.append(nums[0]).append('/').append('(');
    for (int i = 1; i < n; i++) {
      sb.append(nums[i]);
      if (i != n - 1)
        sb.append('/');
    }
    sb.append(')');
    return sb.toString();
  }
}

public class _553_Optimal_Division {
  public static void main(String[] args) {
    System.out.println(new Solution().optimalDivision(new int[] { 1000, 100, 10, 2 }));
  }
}
