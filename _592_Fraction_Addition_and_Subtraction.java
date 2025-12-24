// import java.util.*;

// class Solution {

// 67 / 105 testcases passed
//   public String fractionAddition(String expression) {
//     char[] tokens = expression.toCharArray();
//     int n = tokens.length, i = 0, den_sum = 1;
//     List<Integer> numerators = new ArrayList<>(), denominators =
//       new ArrayList<>();
//     while (i < n) {
//       if (tokens[i] == '/') {
//         numerators.add(
//           (tokens[i - 1] - '0') *
//           ((i - 2 >= 0 && (tokens[i - 2] == '-')) ? -1 : 1)
//         );
//         denominators.add((tokens[i + 1] - '0'));
//         den_sum *= (tokens[i + 1] - '0');
//       }
//       i++;
//     }

//     int x = denominators.size();
//     for (i = 0; i < x; i++) numerators.set(
//       i,
//       (den_sum / denominators.get(i)) * numerators.get(i)
//     );
//     int NUMERATOR = 0;
//     i = 0;
//     while (i < x) NUMERATOR += numerators.get(i++);

//     if (NUMERATOR == 0) return "0/1";
//     int max_factor = NUMERATOR > den_sum
//       ? gcd(NUMERATOR, den_sum)
//       : gcd(den_sum, NUMERATOR);

//     return (max_factor >= 0)
//       ? ((NUMERATOR / max_factor) + "/" + (den_sum / max_factor))
//       : ((NUMERATOR / (max_factor * -1))) + "/" + (den_sum / (max_factor * -1));
//   }

//   private int gcd(int N, int D) {
//     if (D == 0) return N;
//     return gcd(D, N % D);
//   }
// }

// public class _592_Fraction_Addition_and_Subtraction {

//   public static void main(String[] args) {
//     System.out.println(new Solution().fractionAddition("7/2+2/3-3/4"));
//   }
// }

import java.util.*;

class Solution {

  public String fractionAddition(String expression) {
    int numerator = 0, denominator = 1;
    int i = 0, n = expression.length();

    while (i < n) {
      int sign = 1;
      if (expression.charAt(i) == '+' || expression.charAt(i) == '-') {
        sign = expression.charAt(i) == '-' ? -1 : 1;
        i++;
      }

      int num = 0;
      while (i < n && Character.isDigit(expression.charAt(i))) {
        num = num * 10 + (expression.charAt(i) - '0');
        i++;
      }

      i++;

      int den = 0;
      while (i < n && Character.isDigit(expression.charAt(i))) {
        den = den * 10 + (expression.charAt(i) - '0');
        i++;
      }

      numerator = numerator * den + sign * num * denominator;
      denominator = denominator * den;

      int g = gcd(Math.abs(numerator), denominator);
      numerator /= g;
      denominator /= g;
    }

    return numerator + "/" + denominator;
  }

  private int gcd(int a, int b) {
    return b == 0 ? a : gcd(b, a % b);
  }
}

public class _592_Fraction_Addition_and_Subtraction {

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.fractionAddition("7/2+2/3-3/4"));
  }
}
