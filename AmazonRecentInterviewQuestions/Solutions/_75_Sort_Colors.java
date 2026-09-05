import java.util.Arrays;

class Solution {

  public void sortColors(int[] nums) {
    int[] freq = new int[3];
    for (int i = 0; i < nums.length; i++) freq[nums[i]]++;
    int idx = 0;
    for (int i = 0; i < nums.length; i++) {
      while (freq[idx] == 0) idx++;
      nums[i] = idx;
      if (--freq[idx] == 0) idx++;
    }
  }
}

public class _75_Sort_Colors {

  public static void main(String[] args) {
    int[] nums = { 1 };
    new Solution().sortColors(nums);
    System.out.println(Arrays.toString(nums));
  }
}
