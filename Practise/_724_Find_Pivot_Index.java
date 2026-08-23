import java.util.Arrays;

class Solution {

  public int pivotIndex(int[] nums) {
    int n = nums.length;
    int leftPrefixSum = 0, rightPrefixSum = 0;
    for (int i = 0; i < n; i++) leftPrefixSum += nums[i];
    int pivotIndex = -1;
    for (int i = n - 1; i >= 0; i--) {
      leftPrefixSum -= nums[i];
      if (leftPrefixSum == rightPrefixSum) pivotIndex = i;
      rightPrefixSum += nums[i];
    }
    return pivotIndex;
  }
}

public class _724_Find_Pivot_Index {

  public static void main(String[] args) {
    System.out.println(new Solution().pivotIndex(new int[] { 2, 1, -1 }));
  }
}
