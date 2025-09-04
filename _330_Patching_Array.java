class Solution {

  public int minPatches(int[] nums, int n) {
    int patches = 0;
    int i = 0;
    long maxCoverage = 0;
    while (maxCoverage < n) {
      if (i < nums.length && maxCoverage + 1 >= nums[i]) {
        maxCoverage += nums[i];
        i++;
      } else {
        patches++;
        maxCoverage += (maxCoverage + 1);
      }
    }
    return patches;
  }
}

public class _330_Patching_Array {

  public static void main(String[] args) {
    System.out.println(new Solution().minPatches(new int[] { 1, 5, 10 }, 20));
  }
}
