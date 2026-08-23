class Solution {

  public int countNumbersWithUniqueDigits(int n) {
    if (n == 0) return 1;
    int x = 9, y = 9;
    int ans = 10;
    while (n-- > 1 && x > 0) {
      y = x-- * y;
      ans += y;
    }
    return ans;
  }
}

public class _357_Count_Numbers_with_Unique_Digits {

  public static void main(String[] args) {
    System.out.println(new Solution().countNumbersWithUniqueDigits(3));
  }
}
