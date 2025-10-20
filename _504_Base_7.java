class Solution {
  public String convertToBase7(int num) {
    boolean negative = num < 0 ? true : false;
    num = Math.abs(num);
    StringBuilder sb = new StringBuilder();
    while (num != 0) {
      sb.append(num % 7);
      num /= 7;
    }

    return (negative ? "-" : "") + sb.reverse().toString();
  }
}

public class _504_Base_7 {
  public static void main(String[] args) {
    System.out.println(new Solution().convertToBase7(-7));
  }
}
