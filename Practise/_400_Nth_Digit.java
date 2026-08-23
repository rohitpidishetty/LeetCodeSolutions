class Solution {

  public int findNthDigit(int n) {
    // n digits at first
    long s = 1, e = 9, threshold = 9, rise = 10, x = 1;
    // Deciding block
    /**
     * 1 digit block  || 2 digit block || nth digit block
     * s:1 to e:9     || 10 to 99      || (s*10) to ((e * 10) + 9)
     */
    while (n - (long) (((e - s) + 1) * x) > 0) {
      System.out.println(n);
      n -= (e - s + 1) * x;
      e *= rise;
      e += threshold;
      s *= rise;
      x++;
    }
    // System.out.println("Block: " + x + " remaining digits " + n);
    long num = s + (n - 1) / x; // searching for 'n' th digit in  x block.
    /** if n was 11, after processing n will become 2, so then we need to search for 2 digit in x=> 2 block.
     *  2 digit in the 2 block (10 - 99) is '0', from 10, where 1 is first digit in the 2nd block and 0 is the second digit.
     */
    int digitIndex = (int) ((n - 1) % x);
    return String.valueOf(num).charAt(digitIndex) - '0';
  }
}

public class _400_Nth_Digit {

  public static void main(String[] args) {
    System.out.println(new Solution().findNthDigit(11));
  }
}
