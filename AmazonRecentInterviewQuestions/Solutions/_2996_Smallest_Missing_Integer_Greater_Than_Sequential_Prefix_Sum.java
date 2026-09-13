import java.util.HashSet;
import java.util.Set;

class Solution {

  public int missingInteger(int[] nums) {
    Set<Integer> s = new HashSet<>();
    for (int num : nums) s.add(num);
    int sum = nums[0];
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] == nums[i - 1] + 1) sum += nums[i];
      else break;
    }
    while (s.contains(sum)) sum++;
    return sum;
  }
}

public class _2996_Smallest_Missing_Integer_Greater_Than_Sequential_Prefix_Sum {

  public static void main(String[] args) {
    System.out.println(
      new Solution().missingInteger(new int[] { 3, 4, 5, 1, 12, 14, 13 })
    );
  }
}
