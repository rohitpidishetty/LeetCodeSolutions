import java.util.*;

class Solution {

  public int triangleNumber(int[] nums) {
    int count = 0;
    int n = nums.length;
    Arrays.sort(nums);
    for (int k = n - 1; k > 1; k--) {
      int i = 0, j = k - 1;
      while (i < j) {
        if (nums[i] + nums[j] <= nums[k]) i++;
        else {
          count += (j - i);
          j--;
        }
      }
    }
    return count;
  }
}

public class _611_Valid_Triangle_Number {

  public static void main(String[] args) {
    System.out.println(new Solution().triangleNumber(new int[] { 2, 2, 3, 4 }));
  }
}
