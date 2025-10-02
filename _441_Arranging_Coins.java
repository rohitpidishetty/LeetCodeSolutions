class Solution {

  // public int arrangeCoins(int n) {
  //   int previous = 0;
  //   int msb = 1;
  //   int prev_msb = 0;
  //   while ((msb + previous) <= n) {
  //     previous += msb;
  //     prev_msb = msb;
  //     msb++;
  //   }

  //   return prev_msb;
  // }

  public int arrangeCoins(int n) {
    long left = 0, right = n;
    while (left <= right) {
      long mid = (left + right) / 2;
      long coins = (mid * (mid + 1)) / 2;
      if (coins == n) return (int) mid;
      else if (coins > n) right = mid - 1;
      else left = mid + 1;
    }
    return (int) right;
  }
}

public class _441_Arranging_Coins {

  public static void main(String[] args) {
    System.out.println(new Solution().arrangeCoins(8));
  }
}
