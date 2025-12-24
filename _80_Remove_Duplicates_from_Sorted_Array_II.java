import java.util.Arrays;

class Solution {

  public int removeDuplicates(int[] nums) {
    int n = nums.length;
    int i = 1;
    int count = 1;
    int j = 1;
    while (i < n) {
      if (nums[i] == nums[i - 1]) count++;
      else count = 1;
      if (count <= 2) {
        System.out.println(Arrays.toString(nums));
        nums[j++] = nums[i];
      }
      i++;
    }
    System.out.println(Arrays.toString(nums));
    return j;
  }
}

public class _80_Remove_Duplicates_from_Sorted_Array_II {

  public static void main(String[] args) {
    System.out.println(
      new Solution()
        .removeDuplicates(new int[] { 0, 0, 0, 0, 1, 1, 1, 2, 3, 3 })
    );
  }
}
