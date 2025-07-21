import java.util.Arrays;
class Solution {

  private void remove_negatives_and_out_of_bound_elements(int[] nums) {
    for (int i = 0; i < nums.length; i++)
      if (nums[i] <= 0 || nums[i] > nums.length)
        nums[i] = 1;
  }

  public int firstMissingPositive(int[] nums) {
    // If 1 is not present we will return 1 as ans.
    boolean _1_is_present = false;
    for (int i = 0; i < nums.length; i++)
      if (nums[i] == 1)
        _1_is_present = true;
    if (!_1_is_present)
      return 1;

    // We will remove all the -ve elements as well as the elements which are out-of-bound i.e., (greater than the len of array).
    remove_negatives_and_out_of_bound_elements(nums);

    // If 1 is present, then we need to define a clever way to find the first positive number.
    // To come up with a clever solution, let us assume that the elements present in the array are our indexes. This assumption will help us to mark the elements as present which are in the array. Let us mark the presence as -ve i.e, if 'a', then mark it as '-a'.
    for (int i = 0; i < nums.length; i++) {
      int index = Math.abs(nums[i]) - 1;
      if (nums[index] > 0)
        nums[index] *= -1;
    }

    // At this point while iterating over the array, the first positive number will imply the first missing value
    for (int i = 0; i < nums.length; i++)
      if (nums[i] > 0)
        return i + 1;

    // Else just return the element that is nums.length + 1 as first positive missing value
    return nums.length + 1;
  }
}
public class _41 {

  public static void main(String[] args) {
    System.out.println(
      new Solution().firstMissingPositive(new int[] { 3, 4, -1, 1 })
    );
  }
}
