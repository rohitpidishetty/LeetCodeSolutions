class Solution {
  public int singleNonDuplicate(int[] nums) {
    int i = 0, j = nums.length - 1;
    while (i < j) {
      int m = (i + j) / 2;
      boolean isEven = (j - m) % 2 == 0;
      if (nums[m] == nums[m + 1]) {
        if (!isEven)
          j = m - 1;
        else
          i = m + 2;
      } else {
        if (isEven)
          j = m;
        else
          i = m + 1;
      }

    }
    return nums[j];

  }
}

public class _540_Single_Element_in_a_Sorted_Array {
  public static void main(String[] args) {
    System.out.println(new Solution().singleNonDuplicate(new int[] { 1, 1, 2, 3, 3, 4, 4, 8, 8 }));
  }
}
