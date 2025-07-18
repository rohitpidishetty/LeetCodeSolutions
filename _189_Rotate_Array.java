import java.util.Arrays;

class Solution {

  private void reverse(int[] buffer, int s, int e) {
    int m = (s + e) / 2;
    while (s <= m) {
      int temp = buffer[s];
      buffer[s] = buffer[e];
      buffer[e] = temp;
      e--;
      s++;
    }
  }

  public void rotate(int[] nums, int k) {
    k %= nums.length;
    if (k != 0 && nums.length != 0) {
      reverse(nums, 0, nums.length - 1);
      reverse(nums, 0, k - 1);
      reverse(nums, k, nums.length - 1);
    }
  }
}

public class _189_Rotate_Array {

  public static void main(String[] args) {
    new Solution().rotate(new int[] { 1, 2, 3, 4, 5, 6, 7 }, 3);
  }
}
