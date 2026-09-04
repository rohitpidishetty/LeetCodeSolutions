class Solution {

  private boolean isPossible(int m, int[] buff, int k, int tot) {
    int cuts = 0;

    int sum = 0;
    for (int e : buff) {
      if (e + sum > m) {
        sum = 0;
        cuts++;
      }
      sum += e;
    }

    return k >= (cuts + 1);
  }

  public int splitArray(int[] nums, int k) {
    int l = 0;
    int h = 0;
    for (int i = 0; i < nums.length; i++) {
      l = Math.max(l, nums[i]);
      h += nums[i];
    }
    int s = h;

    while (l < h) {
      int m = (l + h) / 2;
      if (isPossible(m, nums, k, s)) {
        h = m;
      } else l = m + 1;
    }
    return l;
  }
}

public class _410_Split_Array_Largest_Sum {

  public static void main(String[] args) {
    System.out.println(
      new Solution().splitArray(new int[] { 7, 2, 5, 10, 8 }, 2)
    );
  }
}
