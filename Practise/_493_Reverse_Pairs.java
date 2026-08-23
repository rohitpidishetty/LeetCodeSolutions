import java.util.Arrays;

class Solution {
  // public int reversePairs(int[] nums) {
  // int count = 0;
  // for (int j = 1; j < nums.length; j++) {
  // for (int i = 0; i < j; i++) {
  // if ((long) nums[i] > (long) ((long) nums[j] * 2))
  // count++;
  // }
  // }
  // return count;
  // }

  private int count = 0;

  private void mergeSort(int i, int j, int[] nums) {
    if (i >= j)
      return;
    int m = (i + j) / 2;
    mergeSort(i, m, nums);
    mergeSort(m + 1, j, nums);
    merge(i, m, j, nums);
  }

  private void count(int i, int j, int m, int[] nums) {
    for (int s = i; s <= m; s++) {
      int ptr = m + 1;
      while (ptr <= j && (long) nums[s] > 2 * (long) nums[ptr])
        ptr++;
      this.count += (ptr - (m + 1));
    }
  }

  private void merge(int i, int m, int j, int[] nums) {
    count(i, j, m, nums);
    int[] temp = new int[j - i + 1];
    int k = 0;
    int o = i;
    int p = m + 1;
    while (o <= m && p <= j) {
      if (nums[p] < nums[o])
        temp[k++] = nums[p++];
      else
        temp[k++] = nums[o++];
    }
    while (o <= m)
      temp[k++] = nums[o++];
    while (p <= j)
      temp[k++] = nums[p++];
    for (int t = 0; t < temp.length; t++)
      nums[i + t] = temp[t];
  }

  public int reversePairs(int[] nums) {
    mergeSort(0, nums.length - 1, nums);
    return count;
  }
}

public class _493_Reverse_Pairs {
  public static void main(String[] args) {
    System.out.println(new Solution()
        .reversePairs(new int[] { 2147483647, 2147483647, 2147483647, 2147483647, 2147483647, 2147483647 }));
  }
}
