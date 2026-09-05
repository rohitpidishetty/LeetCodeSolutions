class Solution {

  public boolean canJump(int[] nums) {
    int n = nums.length;
    int reachTo = nums.length - 1;
    for (int i = n - 1; i >= 0; i--) if (i + nums[i] >= reachTo) reachTo = i;
    return reachTo == 0;
  }
}

public class _55_Jump_Game {

  public static void main(String[] args) {
    System.out.println(new Solution().canJump(new int[] { 2, 3, 1, 1, 4 }));
  }
}
