class Solution {

  public String multiply(String num1, String num2) {
    if (num1.equals("0") || num2.equals("0")) return "0";

    int n = num1.length();
    int m = num2.length();

    int[] result = new int[n + m];

    for (int i = n - 1; i >= 0; i--) {
      for (int j = m - 1; j >= 0; j--) {
        int product = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');

        int pos1 = i + j;
        int pos2 = i + j + 1;

        int sum = product + result[pos2];

        result[pos2] = sum % 10;
        result[pos1] += sum / 10;
      }
    }

    StringBuilder sb = new StringBuilder();

    for (int digit : result) {
      if (sb.length() == 0 && digit == 0) continue;

      sb.append(digit);
    }

    return sb.toString();
  }
}

public class _43_Multiply_Strings {

  public static void main(String[] args) {
    System.out.println(new Solution().multiply("32", "32"));
  }
}
