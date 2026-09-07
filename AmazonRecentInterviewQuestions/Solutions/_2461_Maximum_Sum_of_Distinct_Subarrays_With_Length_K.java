import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {

  public long maximumSubarraySum(int[] nums, int k) {
    long sum = 0;
    Map<Integer, Integer> freq = new HashMap<>();

    long max = 0;

    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
      freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
      if (i >= k - 1) {
        if (freq.size() == k) max = Math.max(max, sum);

        int ele = nums[i - k + 1];
        sum -= ele;
        freq.put(ele, freq.get(ele) - 1);
        if (freq.get(ele) == 0) freq.remove(ele);
      }
    }
    return max;
  }
}

public class _2461_Maximum_Sum_of_Distinct_Subarrays_With_Length_K {

  public static void main(String[] args) {
    System.out.println(
      new Solution().maximumSubarraySum(new int[] { 1, 5, 4, 2, 9, 9, 9 }, 3)
    );
  }
}
