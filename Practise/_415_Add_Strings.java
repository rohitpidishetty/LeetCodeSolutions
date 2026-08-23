class Solution {

  public String addStrings(String num1, String num2) {
    int i = num1.length() - 1, j = num2.length() - 1;
    int cf = 0;
    int xa = 0, xb = 0, sum = 0;
    StringBuilder sb = new StringBuilder();
    while (i >= 0 && j >= 0) {
      xa = num1.charAt(i) - '0';
      xb = num2.charAt(j) - '0';
      sum = xa + xb + cf;
      if (sum < 10) {
        sb.append(sum);
        cf = 0;
      } else {
        sb.append(sum % 10);
        cf = 1;
      }
      i--;
      j--;
    }
    while (i >= 0) {
      xa = num1.charAt(i) - '0';
      sum = xa + cf;
      if (sum < 10) {
        sb.append(sum);
        cf = 0;
      } else {
        sb.append((sum % 10));
        cf = 1;
      }
      i--;
    }
    while (j >= 0) {
      xb = num2.charAt(j) - '0';
      sum = xb + cf;
      if (sum < 10) {
        sb.append(sum);
        cf = 0;
      } else {
        sb.append((sum % 10));
        cf = 1;
      }
      j--;
    }
    if (cf == 1) sb.append('1');
    return sb.reverse().toString();
  }
}

public class _415_Add_Strings {

  public static void main(String[] args) {
    System.out.println(new Solution().addStrings("123", "11"));
  }
}
