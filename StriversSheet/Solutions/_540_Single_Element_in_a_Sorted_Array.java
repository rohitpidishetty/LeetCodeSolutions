class Solution {

  public int singleNonDuplicate(int[] nums) {
    int res = 0;
    for (int num : nums) res ^= num;
    return res;
  }
}

public class _540_Single_Element_in_a_Sorted_Array {

  public static void main(String[] args) {
    System.out.println(
      new Solution().singleNonDuplicate(new int[] { 1, 1, 2, 3, 3, 4, 4, 8, 8 })
    );
  }
}
