class Solution {

  public boolean isMonotonic(int[] nums) {
    int idx = 0;
    while (idx < nums.length - 1 && nums[idx] <= nums[idx + 1]) idx++;
    if (idx == nums.length - 1) return true;
    idx = 0;
    while (idx < nums.length - 1 && nums[idx] >= nums[idx + 1]) idx++;
    return idx == nums.length - 1;
  }
}

public class _896_Monotonic_Array {

  public static void main(String[] args) {
    System.out.println(new Solution().isMonotonic(new int[] { 1, 2, 2, 3 }));
    System.out.println(new Solution().isMonotonic(new int[] { 6, 5, 4, 4 }));
    System.out.println(new Solution().isMonotonic(new int[] { 1, 3, 2 }));
  }
}
