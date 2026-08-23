class Solution {

  public boolean isPerfectSquare(int num) {
    int n = num / 2;
    int i = 0;
    while (i <= n) {
      int mid = (i + n) / 2;
      long ps = (long) mid * mid;
      if (ps == num) return true;
      else if (ps > num) n = mid - 1;
      else i = mid + 1;
    }
    return false;
  }
}

public class _367_Valid_Perfect_Square {

  public static void main(String[] args) {
    System.out.println(new Solution().isPerfectSquare(17));
  }
}
