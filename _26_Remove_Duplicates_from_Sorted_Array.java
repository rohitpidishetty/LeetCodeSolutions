import java.util.Arrays;

class Solution {

  public int removeDuplicates(int[] nums) {
    int n = nums.length;
    int i = 1;
    int uniqueIdx = 0;
    while (i < n) {
      if (nums[uniqueIdx] == nums[i]) i++;
      else nums[++uniqueIdx] = nums[i++];
    }
    return uniqueIdx + 1;
  }
}

public class _26_Remove_Duplicates_from_Sorted_Array {

  public static void main(String[] args) {
    System.out.println(
      new Solution()
        .removeDuplicates(new int[] { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 })
    );
  }
}
