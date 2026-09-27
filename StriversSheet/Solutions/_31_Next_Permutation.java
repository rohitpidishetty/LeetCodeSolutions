import java.util.Arrays;

class Solution {

  private void swap(int buff[], int n) {
    int m = buff.length - 1;
    while (n <= m) {
      int temp = buff[n];
      buff[n] = buff[m];
      buff[m] = temp;
      n++;
      m--;
    }
  }

  public void nextPermutation(int[] nums) {
    int n = nums.length - 1;
    int X = -1;
    for (int j = n; j > 0; j--) {
      if (nums[j - 1] < nums[j]) {
        X = j - 1;
        break;
      }
    }

    int Y = -1;
    if (X > -1) {
      for (Y = n; Y > X; Y--) if (nums[Y] > nums[X]) break;
      int temp = nums[Y];
      nums[Y] = nums[X];
      nums[X] = temp;
    }

    swap(nums, X + 1);
  }
}

public class _31_Next_Permutation {

  public static void main(String[] args) {
    // new Solution().nextPermutation(new int[] { 1, 3, 2, 7, 9 });
    new Solution().nextPermutation(new int[] { 1, 2, 3, 4 });
  }
}
