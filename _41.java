import java.util.Arrays;

class Solution {

  public int firstMissingPositive(int[] nums) {
    boolean seenOne = false;
    int n = nums.length;
    for (int i = 0; i < n; i++) {
      if (nums[i] == 1) seenOne = true;
      if (nums[i] <= 0 || nums[i] > n) nums[i] = 1;
    }

    // We have converted all the negatives into first positive i.e., 1
    // We have also converted all the elements that are greater than the length of the array.
    if (seenOne == false) return 1;

    System.out.println(Arrays.toString(nums));

    for (int i = 0; i < n; i++) {
      int index = Math.abs(nums[i]); //  Every element of the array can be an index at this point of time because we have tranformed all the greater & negative numbers to 1.
      int idx = index - 1;
      if (nums[idx] > 0) nums[idx] *= -1; // An index will be marked as negative if the index is present in the array as value.
    }

    System.out.println(Arrays.toString(nums));
    for (int i = 0; i < n; i++) if (nums[i] > 0) return i + 1;
    return n + 1;
  }
}

public class _41 {

  public static void main(String[] args) {
    System.out.println(
      new Solution().firstMissingPositive(new int[] { 3, 4, -1, 1 })
    );
  }
}
