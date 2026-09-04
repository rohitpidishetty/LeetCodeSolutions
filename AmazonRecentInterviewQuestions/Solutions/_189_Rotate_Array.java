import java.util.Arrays;

class Solution {

  private void rotate(int s, int e, int[] arr) {
    while (s < e) {
      int T = arr[s];
      arr[s] = arr[e];
      arr[e] = T;
      s++;
      e--;
    }
  }

  public void rotate(int[] nums, int k) {
    int n = nums.length;
    k %= n;
    rotate(0, n - 1, nums);
    rotate(0, k - 1, nums);
    rotate(k, n - 1, nums);
  }
}

public class _189_Rotate_Array {

  public static void main(String[] args) {
    int[] res = { 1, 2, 3, 4, 5, 6, 7 };
    new Solution().rotate(res, 3);
    System.out.println(Arrays.toString(res));
  }
}
