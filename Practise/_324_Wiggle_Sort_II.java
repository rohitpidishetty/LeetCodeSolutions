import java.util.Arrays;

class Solution {

  public void wiggleSort(int[] nums) {
    int n = nums.length;
    Arrays.sort(nums);
    int j = n - 1;
    int[] result = new int[n];
    int i = n % 2 == 0 ? (n / 2) - 1 : (n / 2);
    for (int k = 0; k < n; k++) result[k] = k % 2 == 0 ? nums[i--] : nums[j--];
    for (int l = 0; l < n; l++) nums[l] = result[l];
  }
}

public class _324_Wiggle_Sort_II {

  public static void main(String[] args) {
    int[] buffer = new int[] { 1, 1, 2, 1, 2, 2, 1 };
    new Solution().wiggleSort(buffer);
    System.out.println(Arrays.toString(buffer));
  }
}
