import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {

  public List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums);
    Set<List<Integer>> res = new HashSet<>();
    int n = nums.length;
    if (n == 3) {
      int j = 0;
      int sum = 0;
      while (j < n) sum += nums[j++];
      if (sum == 0) {
        res.add(new ArrayList<>(List.of(nums[0], nums[1], nums[2])));
        return new ArrayList<>(res);
      }
    }
    for (int i = 0; i < n - 3; i++) {
      if (i > 0 && nums[i] == nums[i - 1]) continue;
      int a = nums[i];
      int l = i + 1;
      int h = n - 1;
      while (l < h) {
        int sum = a + nums[l] + nums[h];
        if (sum == 0) {
          res.add(new ArrayList<>(List.of(a, nums[l], nums[h])));
          l++;
          h--;
        } else if (sum > 0) h--;
        else l++;
      }
    }
    return new ArrayList<>(res);
  }
}

public class _15_3Sum {

  public static void main(String[] args) {
    // System.out.println(
    //   new Solution().threeSum(new int[] { -1, 0, 1, 2, -1, -4 })
    // );
    System.out.println(new Solution().threeSum(new int[] { 0, 0, 0 }));
  }
}
