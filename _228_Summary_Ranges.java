import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

  public List<String> summaryRanges(int[] nums) {
    List<String> ret = new ArrayList<>();
    int[] P = { nums[0], Integer.MIN_VALUE };
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] == (nums[i - 1] + 1)) {
        if (P[0] == Integer.MIN_VALUE) P[0] = nums[i];
        else P[1] = nums[i];
      }
      if (nums[i] != (nums[i - 1] + 1) || i == nums.length - 1) {
        ret.add(P[1] != Integer.MIN_VALUE ? P[0] + "->" + P[1] : P[0] + "");
        P = new int[] { Integer.MIN_VALUE, Integer.MIN_VALUE };
        P[0] = nums[i];
      }
      if (i == nums.length - 1 && nums[i] != nums[i - 1] + 1) {
        ret.add(P[1] != Integer.MIN_VALUE ? P[0] + "->" + P[1] : P[0] + "");
        P = new int[] { Integer.MIN_VALUE, Integer.MIN_VALUE };
        P[0] = nums[i];
      }
    }
    return ret;
  }

  public List<String> summaryRanges_v2(int[] nums) {
    List<String> result = new ArrayList<>();
    if (nums == null || nums.length == 0) return result;

    int start = nums[0];
    for (int i = 1; i <= nums.length; i++) {
      if (i == nums.length || nums[i] != nums[i - 1] + 1) {
        if (start == nums[i - 1]) result.add(String.valueOf(start));
        else result.add(start + "->" + nums[i - 1]);
        if (i < nums.length) start = nums[i];
      }
    }
    return result;
  }
}

public class _228_Summary_Ranges {

  public static void main(String[] args) {
    System.out.println(
      new Solution().summaryRanges(new int[] { 0, 2, 3, 4, 6, 8, 9 })
    );
  }
}
