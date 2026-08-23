import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

  public List<Integer> majorityElement(int[] nums) {
    Arrays.sort(nums);
    int count = 0;
    int n = nums.length;
    List<Integer> result = new ArrayList<>();
    int threshold = n / 3;
    for (int i = 0; i < n; i++) {
      if (i > 0 && nums[i - 1] != nums[i]) count = 0;
      count++;
      if (count > threshold && !result.contains(nums[i])) {
        result.add(nums[i]);
      }
    }
    return result;
  }
}

public class _229_Majority_Element_II {

  public static void main(String[] args) {
    System.out.println(new Solution().majorityElement(new int[] { 2, 2 }));
  }
}
