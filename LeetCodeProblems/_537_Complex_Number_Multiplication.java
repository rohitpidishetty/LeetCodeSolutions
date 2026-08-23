import java.util.Arrays;

class Solution {
  private String[] get_tokens(String expression) {
    boolean symbol = false;
    int i = 0, n = expression.length();
    for (; i < n; i++) {
      char ch = expression.charAt(i);
      if (!symbol && (ch == '-' || ch == '+') && i == 0)
        symbol = true;
      else if ((symbol && (ch == '-' || ch == '+')) ||
          (!symbol && i > 0 && !Character.isDigit(ch)))
        break;
    }
    return new String[] { expression.substring(0, i),
        expression.substring(i + 1, n) };
  }

  public String complexNumberMultiply(String num1, String num2) {
    return mul_comp(get_tokens(num1), get_tokens(num2));
  }

  private String mul_comp(String[] ex1, String[] ex2) {
    int ex1_fin_ex = Integer.parseInt(ex1[0]),
        ex2_fin_ex = Integer.parseInt(ex2[0]),
        ex1_remi_fin_ex = Integer.parseInt(ex1[1].replace("i", "")),
        ex2_remi_fin_ex = Integer.parseInt(ex2[1].replace("i", ""));
    return String.valueOf((-1 * ex1_remi_fin_ex * ex2_remi_fin_ex) +
        ex1_fin_ex * ex2_fin_ex) + "+" + ((ex1_remi_fin_ex *
            ex2_fin_ex + ex1_fin_ex * ex2_remi_fin_ex) + "i");
  }
}

public class _537_Complex_Number_Multiplication {
  public static void main(String[] args) {
    System.out.println(new Solution().complexNumberMultiply("78+-76i", "-86+72i"));
  }
}