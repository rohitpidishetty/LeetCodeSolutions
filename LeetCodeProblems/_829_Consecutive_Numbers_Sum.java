class Solution {

  public int consecutiveNumbersSum(int n) {
    int count = 0;

    for (int k = 1; (k * (k - 1)) / 2 < n; k++) {
      if ((n - (k * (k - 1)) / 2) % k == 0) count++;
    }
    return count;
  }
}

public class _829_Consecutive_Numbers_Sum {

  public static void main(String[] args) {
    System.out.println(new Solution().consecutiveNumbersSum(15));
  }
}
