import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

  public List<Integer> distinctNumbers(int[] nums, int k) {
    List<Integer> res = new ArrayList<>();
    Map<Integer, Integer> freq = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
      if (i >= k - 1) {
        res.add(freq.size());
        int lIdx = i - k + 1;
        if (freq.containsKey(nums[lIdx])) {
          int frq = freq.get(nums[lIdx]);
          if (frq > 1) freq.put(nums[lIdx], frq - 1);
          else freq.remove(nums[lIdx]);
        }
      }
    }

    return res;
  }
}

public class _Distinct_Numbers_in_Each_Subarray {

  public static void main(String[] args) {
    System.out.println(
      new Solution().distinctNumbers(new int[] { 1, 1, 1, 1, 2, 3, 4 }, 4)
    );
  }
}
