import java.util.Arrays;

class Solution {

  private int max(int[] buffer) {
    int max = Integer.MIN_VALUE;
    for (int v : buffer) max = Math.max(max, v);
    return max;
  }

  private int sum(int[] buffer) {
    int sum = 0;
    for (int v : buffer) sum += v;
    return sum;
  }

  private boolean possible(
    int[] nums,
    int mid,
    int[] prefix_buffer,
    int partitions
  ) {
    int n = prefix_buffer.length;
    int discard = 0;
    int partitions_made = 1;
    for (int i = 0; i < n; i++) {
      if ((prefix_buffer[i] - discard) > mid) {
        partitions_made++;
        if (i > 0) discard = prefix_buffer[i - 1];
        if (partitions_made > partitions) return false;
      }
    }
    return true;
  }

  private int[] prefix_sum(int[] nums) {
    int n = nums.length;
    int[] buffer = new int[n];
    buffer[0] = nums[0];
    for (int i = 1; i < n; i++) buffer[i] = buffer[i - 1] + nums[i];
    return buffer;
  }

  public int splitArray(int[] nums, int k) {
    int lb = max(nums), hb = sum(nums);
    int prefix_buffer[] = prefix_sum(nums);
    while (lb < hb) {
      int mid = (lb + hb) / 2;
      /**
       * Find if you can split the array 'nums' into 'k' non-empty sub-arrays with
       * 'mid' as limit for internal summation of each sub-array, i.e.,
       * each sub array's sum can not exceed more than 'mid'.
       */
      if (possible(nums, mid, prefix_buffer, k)) hb = mid;
      else lb = mid + 1;
    }
    return hb;
  }
}

public class _410_Split_Array_Largest_Sum {

  public static void main(String[] args) {
    System.out.println(
      new Solution().splitArray(new int[] { 7, 2, 5, 10, 8 }, 2)
    );
  }
}
