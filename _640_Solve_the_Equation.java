class Solution {

  private int xLeft, yLeft, xRight, yRight;

  private void get_tokens(String equ, String xMode, String yMode) {
    int i = 0, j = 0, n = equ.length(), sign = 1;
    if (equ.charAt(0) == '-') {
      sign = -1;
      i++;
      j++;
    }
    while (i <= j && j < n) {
      char ch = equ.charAt(j);
      if (ch == '+' || ch == '-' || j == n - 1) {
        String token = (j == n - 1)
          ? equ.substring(i, j + 1)
          : equ.substring(i, j);
        if (token.contains("x")) {
          int x =
            sign *
            (token.equals("x")
                ? 1
                : Integer.parseInt(token.substring(0, token.length() - 1)));
          if (xMode.equals("xl")) xLeft += x;
          else xRight += x;
        } else {
          if (yMode.equals("yl")) yLeft += Integer.parseInt(token) * sign;
          else yRight += Integer.parseInt(token) * sign;
        }
        i = j + 1;
        sign = (ch == '-' ? -1 : 1);
      }
      j++;
    }
  }

  public String solveEquation(String equation) {
    String equ[] = equation.split("=");
    String lhs = equ[0], rhs = equ[1];
    get_tokens(lhs, "xl", "yl");
    get_tokens(rhs, "xr", "yr");
    xLeft += (-1 * xRight);
    yRight += (-1 * yLeft);
    if (xLeft == 0 && yRight == 0) return "Infinite solutions";
    if (xLeft == 0) return "No solution";
    return "x=" + (yRight / xLeft);
  }
}

public class _640_Solve_the_Equation {

  public static void main(String[] args) {
    System.out.println(new Solution().solveEquation("x=x+2"));
  }
}
