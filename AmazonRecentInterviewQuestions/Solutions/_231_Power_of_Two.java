class Solution {

  public boolean isPowerOfTwo(int n) {
    return (1 << (int) (Math.log(n) / Math.log(2))) == n;
  }
}

public class _231_Power_of_Two {

  public static void main(String[] args) {
    System.out.println(new Solution().isPowerOfTwo(16));
  }
}
