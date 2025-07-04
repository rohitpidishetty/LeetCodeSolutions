import java.util.Arrays;

class Solution {

  private void swap(int i, int j, int[] nums) {
    int t = nums[i];
    nums[i] = nums[j];
    nums[j] = t;
  }

  private void reverseOrder(int i, int j, int[] nums) {
    while (i < j) {
      swap(i, j, nums);
      i++;
      j--;
    }
  }

  public void nextPermutation(int[] nums) {

    int n = nums.length - 1;
    int i = n - 1;
    int j = n;

    // 'First depth', from right towards left
    while (i >= 0 && nums[i] >= nums[i + 1])
      i--;
    if (i >= 0) {
      // Next max than the previously found 'First depth'
      while (j >= 0 && nums[i] >= nums[j])
        j--;
      swap(i, j, nums);
    }
    reverseOrder(i + 1, n, nums);
    System.out.println(Arrays.toString(nums));
  }
}

public class _30 {
  public static void main(String[] args) {
    new Solution().nextPermutation(new int[] { 2, 3, 1 });
  }
}
