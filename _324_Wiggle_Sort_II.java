import java.util.Arrays;

class Solution {

  public void wiggleSort(int[] nums) {
    Arrays.sort(nums);
    int n = nums.length;
    int j = n - 1;
    int[] result = new int[n];
    if (n % 2 == 0) {
      int mid = (n / 2) - 1;
      int i = mid;
      for (int k = 0; k < n; k++) result[k] = k % 2 == 0
        ? nums[i--]
        : nums[j--];
    } else {
      int mid = (n / 2);
      int i = mid;
      for (int k = 0; k < n; k++) result[k] = k % 2 == 0
        ? nums[i--]
        : nums[j--];
    }
    for (int i = 0; i < n; i++) nums[i] = result[i];
  }
}

public class _324_Wiggle_Sort_II {

  public static void main(String[] args) {
    int[] buffer = new int[] { 1, 1, 2, 1, 2, 2, 1 };
    new Solution().wiggleSort(buffer);
    System.out.println(Arrays.toString(buffer));
  }
}
