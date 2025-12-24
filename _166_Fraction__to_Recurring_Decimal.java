import java.util.HashMap;
import java.util.Map;

class Solution {
  public String fractionToDecimal(int numerator, int denominator) {
    if (numerator == 0)
      return "0";
    long N = Math.abs((long) numerator);
    long D = Math.abs((long) denominator);
    long rem = N % D;
    long frac = N / D;
    Map<Long, Integer> m = new HashMap<>();
    StringBuilder decimalQuotient = new StringBuilder();
    if ((numerator < 0) ^ (denominator < 0))
      decimalQuotient.append("-");
    decimalQuotient.append(frac);
    if (rem == 0)
      return decimalQuotient.toString();
    decimalQuotient.append(".");
    while (rem != 0) {
      if (m.containsKey(rem)) {
        decimalQuotient.insert(m.get(rem), "(");
        decimalQuotient.append(")");
        break;
      }
      m.put(rem, decimalQuotient.length());
      rem *= 10;
      decimalQuotient.append(rem / D);
      rem = rem - ((rem / D) * D);
    }
    return decimalQuotient.toString();
  }
}

public class _166_Fraction__to_Recurring_Decimal {
  public static void main(String[] args) {
    System.out.println(new Solution().fractionToDecimal(2, 7));
  }
}
