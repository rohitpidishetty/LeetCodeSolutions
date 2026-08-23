import java.util.Arrays;

class Solution {

  public int countRangeSum(int[] nums, int lower, int upper) {
    int n = nums.length;
    long[] prefix_sum = new long[n + 1];
    for (int i = 0; i < n; i++) prefix_sum[i + 1] = nums[i] + prefix_sum[i];

    return custom_merge_sort(prefix_sum, 0, n + 1, lower, upper);
  }

  private int custom_merge_sort(
    long[] prefixSum,
    int left,
    int right,
    int lb,
    int hb
  ) {
    if (right - left <= 1) return 0;
    int mid = (left + right) / 2;
    int count =
      custom_merge_sort(prefixSum, left, mid, lb, hb) +
      custom_merge_sort(prefixSum, mid, right, lb, hb);
    int j = mid, k = mid;
    for (int i = left; i < mid; i++) {
      while (j < right && prefixSum[j] - prefixSum[i] < lb) j++;
      while (k < right && prefixSum[k] - prefixSum[i] <= hb) k++;
      count += (k - j);
    }
    merge(prefixSum, left, mid, right);
    return count;
  }

  private void merge(long buffer[], int left, int mid, int right) {
    long[] temp = new long[right - left];
    int i = left, j = mid, r = 0;
    while (i < mid && j < right) temp[r++] = (buffer[i] <= buffer[j])
      ? buffer[i++]
      : buffer[j++];
    while (i < mid) temp[r++] = buffer[i++];
    while (j < right) temp[r++] = buffer[j++];
    System.arraycopy(temp, 0, buffer, left, r);
  }
}

public class _327_Count_of_Range_Sum {

  public static void main(String[] args) {
    System.out.println(
      new Solution().countRangeSum(new int[] { -2, 5, -1 }, -2, 2)
    );
  }
}
