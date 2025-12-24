import java.util.*;

class Solution {

  private int fetch(int mid, int n, int m) {
    int count = 0;
    for (int i = 1; i <= m; i++) count += Math.min(mid / i, n);
    return count;
  }

  public int findKthNumber(int m, int n, int k) {
    int left = 1, right = m * n;
    while (left <= right) {
      int mid = (left + right) / 2;
      if (fetch(mid, n, m) >= k) right = mid - 1;
      else left = mid + 1;
    }
    return left;
  }
}

public class _668_Kth_Smallest_Number_in_Multiplication_Table {

  public static void main(String[] args) {
    System.out.println(new Solution().findKthNumber(3, 1, 3));
    System.out.println(new Solution().findKthNumber(2, 3, 6));
    System.out.println(new Solution().findKthNumber(3, 3, 5));
    System.out.println(new Solution().findKthNumber(1, 3, 2));
  }
}
