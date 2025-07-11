class Solution {
  public int maxProduct(int[] nums) {
    int n = nums.length;
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < n; i++) {
      int res = nums[i];
      max = Math.max(max, res);
      for (int j = i + 1; j < n; j++) {
        res = res * nums[j];
        max = Math.max(max, res);
      }
    }
    return max;
  }
}

public class _152_Maximum_Product_Subarray {
  public static void main(String[] args) {
    System.out.println(new Solution().maxProduct(new int[] { 2, 0, -1 }));
  }
}
