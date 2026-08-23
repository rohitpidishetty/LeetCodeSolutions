import java.util.Arrays;

class Solution {

  public void sortColors(int[] nums) {
    int count[] = new int[3];
    for (int num : nums) count[num]++;
    int num = 0;
    int idx = 0;
    for (int cnt : count) {
      int s = idx;
      int e = (idx + cnt);
      while (s < e) nums[s++] = num;
      idx = e;
      num++;
    }
    // System.out.println(Arrays.toString(nums));
  }
}

public class _75_Sort_Colors {

  public static void main(String[] args) {
    new Solution().sortColors(new int[] { 2, 0, 2, 2, 1, 1, 1, 0, 0, 0 });
  }
}
