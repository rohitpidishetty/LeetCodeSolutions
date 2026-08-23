class Solution {

  public int addDigits(int num) {
    if (num <= 9 && num >= 0) return num;
    int summation = 0;
    while (num > 0) {
      summation += (num % 10);
      num /= 10;
    }
    return addDigits(summation);
  }
}

public class _258_Add_Digits {

  public static void main(String[] args) {
    System.out.println(new Solution().addDigits(38));
  }
}
