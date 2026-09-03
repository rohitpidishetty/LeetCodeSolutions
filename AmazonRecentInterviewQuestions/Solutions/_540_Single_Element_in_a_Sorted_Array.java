class Solution {

  public int singleNonDuplicate(int[] nums) {
    int l = 0;
    int h = nums.length - 1;
    while (l < h) {
      int m = (l + (h - l) / 2);
      if (m > 0 && nums[m] == nums[m - 1]) {
        if (((m - l) + 1) % 2 == 1) h = m - 2;
        else l = m + 1;
      } else if (m < nums.length - 1 && nums[m] == nums[m + 1]) {
        if (((h - m) + 1) % 2 == 0) h = m - 1;
        else l = m + 2;
      } else return nums[m];
    }
    return nums[l];
  }
}

public class _540_Single_Element_in_a_Sorted_Array {

  public static void main(String[] args) {
    System.out.println(
      new Solution().singleNonDuplicate(new int[] { 1, 1, 2, 3, 3, 4, 4, 8, 8 })
    );
  }
}
