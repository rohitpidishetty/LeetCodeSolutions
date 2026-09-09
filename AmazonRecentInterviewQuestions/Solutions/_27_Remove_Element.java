class Solution {

  public int removeElement(int[] nums, int val) {
    int z = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != val) nums[z++] = nums[i];
    }
    return z;
  }
}

public class _27_Remove_Element {

  public static void main(String[] args) {
    System.out.println(
      new Solution().removeElement(new int[] { 3, 2, 2, 3 }, 3)
    );
  }
}
