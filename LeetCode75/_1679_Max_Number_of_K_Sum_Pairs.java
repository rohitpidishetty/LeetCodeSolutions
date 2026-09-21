import java.util.Arrays;

class Solution {

  public int maxOperations(int[] nums, int k) {
    Arrays.sort(nums);
    int l = 0;
    int h = nums.length - 1;
    int count = 0;
    while (l < h) {
      int sum = nums[l] + nums[h];
      if (sum == k) {
        count++;
        l++;
        h--;
      } else if (sum < k) l++;
      else h--;
    }
    return count;
  }
}

public class _1679_Max_Number_of_K_Sum_Pairs {

  public static void main(String[] args) {
    System.out.println(
      new Solution().maxOperations(new int[] { 1, 2, 3, 4 }, 5)
    );
  }
}
