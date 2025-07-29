class Solution {

  public int findDuplicate(int[] nums) {
    int fp = nums[0];
    int sp = nums[0];

    // Detect the cycle first
    do {
      sp = nums[sp];
      fp = nums[nums[fp]];
    } while (sp != fp);

    sp = nums[0];
    // Traverse one by one to meet at a single re-occuring point
    while (sp != fp) {
      // System.out.println(sp + " " + fp);
      sp = nums[sp];
      fp = nums[fp];
    }
    return sp;
  }
}

public class _287_Find_the_Duplicate_Number {

  public static void main(String[] args) {
    System.out.println(
      new Solution().findDuplicate(new int[] { 1, 3, 4, 2, 2 })
    );
  }
}
