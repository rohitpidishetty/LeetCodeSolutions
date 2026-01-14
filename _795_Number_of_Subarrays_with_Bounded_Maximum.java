import java.util.Arrays;

class Solution {

  public int numSubarrayBoundedMax(int[] nums, int left, int right) {
    int leftPointer = -1;
    int rightPointer = -1;
    int count = 0;

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] > right) {
        leftPointer = rightPointer = i;
        continue;
      }
      if (nums[i] >= left) rightPointer = i;
      count += (rightPointer - leftPointer);
    }
    return count;
  }
}

public class _795_Number_of_Subarrays_with_Bounded_Maximum {

  public static void main(String[] args) {
    System.out.println(
      new Solution().numSubarrayBoundedMax(new int[] { 2, 9, 2, 5, 6 }, 2, 8)
    );
    System.out.println();
    System.out.println(
      new Solution().numSubarrayBoundedMax(new int[] { 2, 1, 4, 3 }, 2, 3)
    );
    System.out.println();
    System.out.println(
      new Solution().numSubarrayBoundedMax(new int[] { 2, 1, 4, 3 }, 2, 3)
    );
  }
}
