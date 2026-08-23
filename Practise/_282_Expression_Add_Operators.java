import java.util.List;

class Solution {

  private int solve(String num, int target) {
    int n = num.length();
    if(n == 1) return num.charAt(0) - '0';
    for (int i = 1; i < n; i++) {
      String leftExpr = num.substring(0, i);
      String rightExpr = num.substring(i, n);
      int leftOprnd = solve(leftExpr, target);
      int rightOprnd = solve(rightExpr, target);
      System.out.println(leftExpr + " " + rightExpr);
    }
    return 0;
  }

  public List<String> addOperators(String num, int target) {
    solve(num, target);
    return null;
  }
}

public class _282_Expression_Add_Operators {

  public static void main(String[] args) {
    System.out.println(new Solution().addOperators("232", 8));
  }
}
