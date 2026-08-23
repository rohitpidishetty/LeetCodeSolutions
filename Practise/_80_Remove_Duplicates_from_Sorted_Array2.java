import java.util.Arrays;

class Solution {
  public int removeDuplicates(int[] nums) {
    int previous = nums[0];
    int count = 1;
    int i = 1;
    int cx = 0;
    while (i < nums.length) {
      if (previous == Integer.MAX_VALUE || nums[i] != previous) {
        previous = nums[i];
        count = 1;
        i++;
      }
      if (i >= nums.length)
        break;
      if (nums[i] == previous)
        count++;
      while (count > 2 && nums[i] == previous) {
        nums[i] = Integer.MAX_VALUE;
        cx++;
        i++;
        if (i >= nums.length)
          break;
        count--;
      }
      if (i >= nums.length)
        break;
      previous = nums[i];
      i++;
      System.out.println(Arrays.toString(nums));
    }
    Arrays.sort(nums);
    System.out.println(Arrays.toString(nums));
    return nums.length - cx;
  }
}

public class _80_Remove_Duplicates_from_Sorted_Array2 {
  public static void main(String[] args) {
    System.out.println(new Solution().removeDuplicates(new int[] { 1, 1, 1, 2, 2, 3 }));
  }
}