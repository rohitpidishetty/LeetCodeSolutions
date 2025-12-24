class Solution {

  public boolean hasAlternatingBits(int n) {
    int i = 31;
    while (i >= 0) {
      if ((n & (1 << i)) != 0) break;
      i--;
    }
    boolean BIT = true;
    while (i >= 0) {
      if ((((n & (1 << i)) == 0) ? false : true) != BIT) return false;
      BIT = !BIT;
      i--;
    }
    return true;
  }
}

public class _693_Binary_Number_with_Alternating_Bits {

  public static void main(String[] args) {
    System.out.println(new Solution().hasAlternatingBits(4));
  }
}
