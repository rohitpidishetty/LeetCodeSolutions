import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

  public List<Integer> majorityElement(int[] nums) {
    Arrays.sort(nums);
    int threshold = nums.length / 3;
    List<Integer> ret = new ArrayList<>();
    for (int i = 0; i < nums.length; i++) {
      int j = i;
      int count = 0;
      while (j < nums.length && nums[j] == nums[i]) {
        j++;
        count++;
      }
      if (count > threshold) ret.add(nums[i]);
      i = j - 1;
    }
    return ret;
  }
}

public class _229_Majority_Element_II {

  public static void main(String[] args) {
    System.out.println(new Solution().majorityElement(new int[] { 1, 2 }));
  }
}
